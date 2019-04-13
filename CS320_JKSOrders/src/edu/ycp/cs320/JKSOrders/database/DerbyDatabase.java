package edu.ycp.cs320.JKSOrders.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.booksdb.model.Author;
import edu.ycp.cs320.booksdb.model.Book;
import edu.ycp.cs320.booksdb.model.BookAuthor;
import edu.ycp.cs320.booksdb.model.Pair;
import edu.ycp.cs320.booksdb.persist.DBUtil;
import edu.ycp.cs320.booksdb.persist.IDatabase;
import edu.ycp.cs320.booksdb.persist.InitialData;
import edu.ycp.cs320.booksdb.persist.PersistenceException;

public class DerbyDatabase implements Database {
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby driver");
		}
	}
	
	private interface Transaction<ResultType> {
		public ResultType execute(Connection conn) throws SQLException;
	}

	private static final int MAX_ATTEMPTS = 10;

	// wrapper SQL transaction function that calls actual transaction function (which has retries)
	public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
		try {
			return doExecuteTransaction(txn);
		} catch (SQLException e) {
			throw new PersistenceException("Transaction failed", e);
		}
	}
	
	// SQL transaction function which retries the transaction MAX_ATTEMPTS times before failing
	public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
		Connection conn = connect();
		
		try {
			int numAttempts = 0;
			boolean success = false;
			ResultType result = null;
			
			while (!success && numAttempts < MAX_ATTEMPTS) {
				try {
					result = txn.execute(conn);
					conn.commit();
					success = true;
				} catch (SQLException e) {
					if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
						// Deadlock: retry (unless max retry count has been reached)
						numAttempts++;
					} else {
						// Some other kind of SQLException
						throw e;
					}
				}
			}
			
			if (!success) {
				throw new SQLException("Transaction failed (too many retries)");
			}
			
			// Success!
			return result;
		} finally {
			DBUtil.closeQuietly(conn);
		}
	}

	// TODO: Here is where you name and specify the location of your Derby SQL database
	// TODO: Change it here and in SQLDemo.java under CS320_LibraryExample_Lab06->edu.ycp.cs320.sqldemo
	// TODO: DO NOT PUT THE DB IN THE SAME FOLDER AS YOUR PROJECT - that will cause conflicts later w/Git
	private Connection connect() throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:derby:C:/JKSOrders-2019-LibraryExample-DB/library.db;create=true");		
		
		// Set autocommit() to false to allow the execution of
		// multiple queries/statements as part of the same transaction.
		conn.setAutoCommit(false);
		
		return conn;
	}
	
	// retrieves Author information from query result set
	private void loadAuthor(Author author, ResultSet resultSet, int index) throws SQLException {
		author.setAuthorId(resultSet.getInt(index++));
		author.setLastname(resultSet.getString(index++));
		author.setFirstname(resultSet.getString(index++));
	}
	
	// retrieves Book information from query result set
	private void loadBook(Book book, ResultSet resultSet, int index) throws SQLException {
		book.setBookId(resultSet.getInt(index++));
//		book.setAuthorId(resultSet.getInt(index++));  // no longer used
		book.setTitle(resultSet.getString(index++));
		book.setIsbn(resultSet.getString(index++));
		book.setPublished(resultSet.getInt(index++));
	}
	
	// retrieves WrittenBy information from query result set
	private void loadBookAuthors(BookAuthor bookAuthor, ResultSet resultSet, int index) throws SQLException {
		bookAuthor.setBookId(resultSet.getInt(index++));
		bookAuthor.setAuthorId(resultSet.getInt(index++));
	}
	
	//  creates the Authors and Books tables
	public void createTables() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				System.out.println("Creating Prepared Statements");
				PreparedStatement stmt1 = null;
				PreparedStatement stmt2 = null;
				PreparedStatement stmt3 = null;	
				PreparedStatement stmt4 = null;
				PreparedStatement stmt5 = null;
				PreparedStatement stmt6 = null;	
				PreparedStatement stmt7 = null;
				PreparedStatement stmt8 = null;
				PreparedStatement stmt9 = null;	
			
				try {

					System.out.println("Beginning to create tables");
					stmt1 = conn.prepareStatement(
							"create table cars (" +
							"	cars_id varchar(5),"	+						
							"	color varchar(40)," +
							"	brand varchar(40)," +
							"	make varchar(40), built integer)"
						);	
						stmt1.executeUpdate();
					
					System.out.println("cars table created");
					
					stmt2 = conn.prepareStatement(
							"create table catalog (" +
							"	item_id varchar(5) primary key, " +
							"	iten_name varchar(70)," +
							"	price float(10)," +
							"   location char(4)," +
							"	quantity integer," +
							"	visible integer" +
							")"
					);
					stmt2.executeUpdate();
					
					System.out.println("Catalog table created");		
					
					stmt3 = conn.prepareStatement(
							"create table customers (" +
							"	curtomer_id varchar(5) primary key, " +
							"	first_name varchar(50)," +
							"	last_name varchar(50)," +
							"	email varchar(50)," +
							"	phoneNumber integer," +
							"	creditCard_id integer" +
							")"
					);
					stmt3.executeUpdate();
					
					System.out.println("Customers table created");
					
					stmt4 = conn.prepareStatement(
							"create table employees (" +
							"	employee_id varchar(5) primary key, " +
							"	first_name varchar(50)," +
							"	last_name varchar(50)," +
							"	email varchar(50)," +
							"	phoneNumber integer" +
							")"
					);
					stmt4.executeUpdate();
					
					System.out.println("Employees table created");
					
					stmt5 = conn.prepareStatement(
							"create table login (" +
							"	employee_id varchar(5), " +
							"	username varchar(50)," +
							"	password varchar(50))"
					);
					stmt5.executeUpdate();
					
					System.out.println("login table created");
					
					stmt6 = conn.prepareStatement(
							"create table notifications (" +
							"	notification_id varchar(5) primary key, " +
							"	employee_id varchar(50)," +
							"	message varchar(1000)" +
							")"
					);
					stmt6.executeUpdate();
					
					System.out.println("notifications table created");
					
					stmt7 = conn.prepareStatement(
							"create table orders (" +
							"	order_id varchar(5) primary key, " +
							"	employee_id varchar(5) constraint employee_id references employees," +
							"	message varchar(1000)" +
							")"
					);
					stmt7.executeUpdate();
					
					System.out.println("Order Junction table created");
					
					stmt8 = conn.prepareStatement(
							"create table notificationRecipients (" +
							"	notification_id varchar(5) constraint notification_id references notifications," +
							"	employee_id varchar(5)" +
							")"
					);
					stmt8.executeUpdate();
					
					System.out.println("notificationRecipients table created");
					
					stmt9 = conn.prepareStatement(
							"create table orderItemJunction (" +
							"	order_id varchar(5) constraint order_id references orders," +
							"	item_id varchar(5) constraint item_id references catalog," +
							"	quantity integer" +
							")"
					);
					stmt9.executeUpdate();
					
					System.out.println("orderItemJunction table created");			
										
					return true;
				} finally {
					DBUtil.closeQuietly(stmt1);
					DBUtil.closeQuietly(stmt2);
					DBUtil.closeQuietly(stmt3);
					DBUtil.closeQuietly(stmt4);
					DBUtil.closeQuietly(stmt5);
					DBUtil.closeQuietly(stmt6);
					DBUtil.closeQuietly(stmt7);
					DBUtil.closeQuietly(stmt8);
					DBUtil.closeQuietly(stmt9);
				}
			}
		});
	}
	
	// loads data retrieved from CSV files into DB tables in batch mode
	public void loadInitialData() {
		executeTransaction(new Transaction<Boolean>() {
			@Override
			public Boolean execute(Connection conn) throws SQLException {
				List<Author> authorList;
				List<Book> bookList;
				List<BookAuthor> bookAuthorList;
				
				try {
					authorList     = InitialData.getAuthors();
					bookList       = InitialData.getBooks();
					bookAuthorList = InitialData.getBookAuthors();					
				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertAuthor     = null;
				PreparedStatement insertBook       = null;
				PreparedStatement insertBookAuthor = null;

				try {
					// must completely populate Authors table before populating BookAuthors table because of primary keys
					insertAuthor = conn.prepareStatement("insert into authors (lastname, firstname) values (?, ?)");
					for (Author author : authorList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertAuthor.setString(1, author.getLastname());
						insertAuthor.setString(2, author.getFirstname());
						insertAuthor.addBatch();
					}
					insertAuthor.executeBatch();
					
					System.out.println("Authors table populated");
					
					// must completely populate Books table before populating BookAuthors table because of primary keys
					insertBook = conn.prepareStatement("insert into books (title, isbn, published) values (?, ?, ?)");
					for (Book book : bookList) {
//						insertBook.setInt(1, book.getBookId());		// auto-generated primary key, don't insert this
//						insertBook.setInt(1, book.getAuthorId());	// this is now in the BookAuthors table
						insertBook.setString(1, book.getTitle());
						insertBook.setString(2, book.getIsbn());
						insertBook.setInt(3, book.getPublished());
						insertBook.addBatch();
					}
					insertBook.executeBatch();
					
					System.out.println("Books table populated");					
					
					// must wait until all Books and all Authors are inserted into tables before creating BookAuthor table
					// since this table consists entirely of foreign keys, with constraints applied
					insertBookAuthor = conn.prepareStatement("insert into bookAuthors (book_id, author_id) values (?, ?)");
					for (BookAuthor bookAuthor : bookAuthorList) {
						insertBookAuthor.setInt(1, bookAuthor.getBookId());
						insertBookAuthor.setInt(2, bookAuthor.getAuthorId());
						insertBookAuthor.addBatch();
					}
					insertBookAuthor.executeBatch();	
					
					System.out.println("BookAuthors table populated");					
					
					return true;
				} finally {
					DBUtil.closeQuietly(insertBook);
					DBUtil.closeQuietly(insertAuthor);
					DBUtil.closeQuietly(insertBookAuthor);					
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		//System.out.println("Loading initial data...");
		//db.loadInitialData();
		
		//System.out.println("Library DB successfully initialized!");
	}
}
