package edu.ycp.cs320.JKSOrders.database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.classes.Pair;

class DerbyDatabase implements Database {
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
					
					
					stmt2 = conn.prepareStatement(
							"create table catalog (" +
							"	item_id varchar(5) primary key, " +
							"	item_name varchar(70)," +
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
							"	customer_id varchar(5) primary key, " +
							"	first_name varchar(50)," +
							"	last_name varchar(50)," +
							"	email varchar(50)," +
							"	phoneNumber varchar(12)," +
							"	creditCard_id varchar(20)" +
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
							"	phoneNumber varchar(20)" +
							")"
					);
					stmt4.executeUpdate();
					
					System.out.println("Employees table created");
					
					stmt1 = conn.prepareStatement(
							"create table cars (" +
							"	customer_id varchar(5) constraint customer_id references customers,"	+						
							"	color varchar(40)," +
							"	brand varchar(40)," +
							"	make varchar(40), built integer)"
						);	
						stmt1.executeUpdate();
					
					System.out.println("cars table created");
					
					stmt5 = conn.prepareStatement(
							"create table login (" +
							"	user_id varchar(5), " +
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
							"	user_id varchar(5)" +
							")"
					);
					stmt7.executeUpdate();
					
					System.out.println("Order table created");
					
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
							"	item_id varchar(5)," +
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
				List<Car> carsList;
				List<CustomerAccount> customersList;
				List<EmployeeAccount> employeesList;
				List<LoginInfo> loginInfoList;
				List<Notification> notificationsList;
				List<Order> ordersList;
				List<Item> itemsList;
				Catalog catalog = new Catalog();
				try {
/*1*/				carsList			= InitialData.getInitialCars();
/*2*/				customersList		= InitialData.getInitialCustomerAccounts();
/*3*/				employeesList		= InitialData.getInitialEmployeeAccounts();
/*4*/				loginInfoList 		= InitialData.getInitialLoginInfo();
/*5*/				notificationsList 	= InitialData.getInitialNotifications();
/*6*/				ordersList			= InitialData.getInitialOrders();
					InitialData.getInitialCatalog(catalog);
					itemsList			= catalog.returnItemList();

				} catch (IOException e) {
					throw new SQLException("Couldn't read initial data", e);
				}

				PreparedStatement insertCar     				= null;
				PreparedStatement insertCustomer				= null;
				PreparedStatement insertEmployee 				= null;
				PreparedStatement insertLoginInfo				= null;
				PreparedStatement insertNotification			= null;
				PreparedStatement insertOrder					= null;
				PreparedStatement insertNotificationRecipients	= null;
				PreparedStatement insertOrderItemJunction		= null;
				PreparedStatement insertCatalog					= null;
				
				try {
					// must completely populate Authors table before populating BookAuthors table because of primary keys
					
					
					// must completely populate Books table before populating BookAuthors table because of primary keys
					insertCustomer = conn.prepareStatement("insert into customers (customer_id, first_name, last_name, email, phoneNumber, creditCard_id) values (?, ?, ?, ?, ?, ?)");
					for (CustomerAccount customer : customersList) {
						insertCustomer.setString(1, customer.getAccountNumber());
						insertCustomer.setString(2, customer.getFirstName());
						insertCustomer.setString(3, customer.getLastName());
						insertCustomer.setString(4, customer.getEmail());
						insertCustomer.setString(5, customer.getPhoneNumber());
						insertCustomer.setString(6, customer.getCreditCard().getAccountNumber());
						insertCustomer.addBatch();
					}
					insertCustomer.executeBatch();
					
					System.out.println("Customers table populated");					
					
					// must wait until all Books and all Authors are inserted into tables before creating BookAuthor table
					// since this table consists entirely of foreign keys, with constraints applied
					insertEmployee = conn.prepareStatement("insert into employees (employee_id, first_name, last_name, email, phoneNumber) values (?, ?, ?, ?, ?)");
					for (EmployeeAccount employee : employeesList) {
						insertEmployee.setString(1, employee.getAccountNumber());
						insertEmployee.setString(2, employee.getFirstName());
						insertEmployee.setString(3, employee.getLastName());
						insertEmployee.setString(4, employee.getEmail());
						insertEmployee.setString(5, employee.getPhoneNumber());
						insertEmployee.addBatch();
					}
					insertEmployee.executeBatch();	
					
					System.out.println("Employees table populated");	
					
					insertCar = conn.prepareStatement("insert into cars (customer_id, color, brand, make, built) values (?, ?, ?, ?, ?)");
					for (Car car : carsList) {
//						insertAuthor.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
						insertCar.setString(1, car.getOwner());
						insertCar.setString(2, car.getColor());
						insertCar.setString(3, car.getBrand());
						insertCar.setString(4, car.getType());
						insertCar.setInt(5, car.getYear());
						insertCar.addBatch();
					}
					insertCar.executeBatch();
					
					System.out.println("Cars table populated");
					
					insertLoginInfo = conn.prepareStatement("insert into login (user_id, username, password) values (?, ?, ?)");
					for (LoginInfo login : loginInfoList) {
						insertLoginInfo.setString(1, login.getOwnerAccount());
						insertLoginInfo.setString(2, login.getUserName());
						insertLoginInfo.setString(3, login.getPassword());
						insertLoginInfo.addBatch();
					}
					insertLoginInfo.executeBatch();	
					
					System.out.println("LoginInfo table populated");
					
					insertNotification = conn.prepareStatement("insert into notifications (notification_id, employee_id, message) values (?, ?, ?)");
					for (Notification notify : notificationsList) {
						insertNotification.setString(1, notify.getNotificationID());
						insertNotification.setString(2, notify.getSourceAccountNumber());
						insertNotification.setString(3, notify.getMessage());
						insertNotification.addBatch();
					}
					insertNotification.executeBatch();	
					
					System.out.println("Notifications table populated");
					
					insertNotificationRecipients = conn.prepareStatement("insert into notificationRecipients (notification_id, employee_id) values (?, ?)");
					for (Notification notify : notificationsList) {
						for(String employeeID : notify.getDestination()) {
							insertNotificationRecipients.setString(1, notify.getNotificationID());
							insertNotificationRecipients.setString(2, employeeID);
							insertNotificationRecipients.addBatch();
						}
					}
					insertNotificationRecipients.executeBatch();	
					
					System.out.println("notificationRecipients table populated");
					
					insertOrder = conn.prepareStatement("insert into orders (order_id, user_id) values (?, ?)");
					for (Order order : ordersList) {
						insertOrder.setString(1, order.getOrderType());
						insertOrder.setString(2, order.getAccountNum());
						insertOrder.addBatch();
					}
					insertOrder.executeBatch();	
					
					System.out.println("Orders table populated");
					
					insertOrderItemJunction = conn.prepareStatement("insert into orderItemJunction (order_id, item_id, quantity) values (?, ?, ?)");
					for (Order order : ordersList) {
						for(Item item : order.getItemlist()) {
							insertOrderItemJunction.setString(1, order.getOrderType());
							insertOrderItemJunction.setString(2, item.getUPC());
							insertOrderItemJunction.setInt(3, order.getQuantityMap().get(item.getUPC()));
							insertOrderItemJunction.addBatch();
						}
					}
					insertOrderItemJunction.executeBatch();	
					
					System.out.println("OrderItemJunction table populated");
					
					
					insertCatalog = conn.prepareStatement("insert into catalog(item_id, item_name, price, location, quantity, visible) values (?, ?, ?, ?, ?, ?)");
					for(Item item : itemsList) {
						insertCatalog.setString(1, item.getUPC());
						insertCatalog.setString(2, item.getItemName());
						insertCatalog.setFloat(3, (float)item.getPrice());
						insertCatalog.setString(4, item.getLocation());
						insertCatalog.setInt(5, item.getNumInInventory());
						if(item.isVisable()) {
							insertCatalog.setInt(6, 1);
						}
						else{
							insertCatalog.setInt(6, 0);
						}
						
					}

					System.out.println("Catalog table populated");
					return true;
				} finally {
					DBUtil.closeQuietly(insertCar);
					DBUtil.closeQuietly(insertCustomer);
					DBUtil.closeQuietly(insertEmployee);	
					DBUtil.closeQuietly(insertLoginInfo);
					DBUtil.closeQuietly(insertNotification);
					DBUtil.closeQuietly(insertOrder);
					DBUtil.closeQuietly(insertNotificationRecipients);
					DBUtil.closeQuietly(insertOrderItemJunction);
					DBUtil.closeQuietly(insertCatalog);
				}
			}
		});
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		System.out.println("Creating tables...");
		DerbyDatabase db = new DerbyDatabase();
		db.createTables();
		
		System.out.println("Loading initial data...");
		db.loadInitialData();
		
		System.out.println("JKSOrders DB successfully initialized!");
	}

	@Override
	public ArrayList<EmployeeAccount> getEmployeeAccounts() {
		return executeTransaction(new Transaction<ArrayList<EmployeeAccount>>() {
			@Override
			public ArrayList<EmployeeAccount> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from employees " +
							" order by last_name asc, first_name asc"
					);
					
					ArrayList<EmployeeAccount> result = new ArrayList<EmployeeAccount>();
					ArrayList<LoginInfo> logins = getEmployeeLoginInfo();
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						EmployeeAccount employee = new EmployeeAccount();
						employee.setAccountNumber(resultSet.getString(1));
						employee.setFirstName(resultSet.getString(2));
						employee.setLastName(resultSet.getString(3));
						employee.setEmail(resultSet.getString(4));
						employee.setPhoneNumber(resultSet.getString(5));
						
						for(LoginInfo login : logins) {
							if(login.getOwnerAccount().equals(employee.getAccountNumber())) {
								employee.setLogin(login);
							}
						}
						result.add(employee);
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No customers were found in the database");
					}
					else
						System.out.println("We got all customers");
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public ArrayList<CustomerAccount> getCustomerAccounts() {
		return executeTransaction(new Transaction<ArrayList<CustomerAccount>>() {
			@Override
			public ArrayList<CustomerAccount> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from customers " +
							" order by last_name asc, first_name asc"
					);
					
					ArrayList<CustomerAccount> result = new ArrayList<CustomerAccount>();
					
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					ArrayList<LoginInfo> logins = getCustomerLoginInfo();
					while (resultSet.next()) {
						found = true;
						CustomerAccount customer = new CustomerAccount();
						customer.setAccountNumber(resultSet.getString(1));
						customer.setFirstName(resultSet.getString(2));
						customer.setLastName(resultSet.getString(3));
						customer.setEmail(resultSet.getString(4));
						customer.setPhoneNumber(resultSet.getString(5));
						customer.getCreditCard().setCVC(resultSet.getString(6));
						for(LoginInfo login : logins) {
							if(login.getOwnerAccount().equals(customer.getAccountNumber())) {
								customer.setLogin(login);
							}
						}
						result.add(customer);
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No employees were found in the database");
					}
					else
						System.out.println("We got all employees");
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public ArrayList<LoginInfo> getEmployeeLoginInfo() {
		return executeTransaction(new Transaction<ArrayList<LoginInfo>>() {
			@Override
			public ArrayList<LoginInfo> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from login " +
							" order by user_id asc"
					);
					
					ArrayList<LoginInfo> result = new ArrayList<LoginInfo>();
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						LoginInfo login = new LoginInfo();
						login.setOwnerAccount(resultSet.getString(1));
						login.setUserName(resultSet.getString(2));
						login.setPassword(resultSet.getString(3));
						char[] user_id = login.getOwnerAccount().toCharArray();
						if(user_id[0]=='C') {
						}
						else
							result.add(login);
					}
					// check if any authors were found
					if (!found) {
						System.out.println("No employee LoginInfo were found in the database");
					}
					else
						System.out.println("We got all employee LoginInfo");
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public ArrayList<LoginInfo> getCustomerLoginInfo() {
		return executeTransaction(new Transaction<ArrayList<LoginInfo>>() {
			@Override
			public ArrayList<LoginInfo> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from login " +
							" order by user_id asc"
					);
					
					ArrayList<LoginInfo> customer = new ArrayList<LoginInfo>();
					resultSet = stmt.executeQuery();
					
					// for testing that a result was returned
					Boolean found = false;
					
					while (resultSet.next()) {
						found = true;
						LoginInfo login = new LoginInfo();
						login.setOwnerAccount(resultSet.getString(1));
						login.setUserName(resultSet.getString(2));
						login.setPassword(resultSet.getString(3));
						char[] user_id = login.getOwnerAccount().toCharArray();
						if(user_id[0]=='C') {
							customer.add(login);
						}
					}
					// check if any authors were found
					if (!found) {
						System.out.println("No customer LoginInfo were found in the database");
					}
					else
						System.out.println("We got all customer LoginInfo");
					return customer;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public Catalog getCatalog() {
		return executeTransaction(new Transaction<Catalog>() {
			@Override
			public Catalog execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from catalog " +
							" order by item_id"
					);
					
					Catalog result = new Catalog();
					resultSet = stmt.executeQuery();
					
					
					
					boolean found= false;
					while (resultSet.next()) {
						found = true;
						
						Item item= new Item();
						item.setUPC(resultSet.getString(1));
						item.setItemName(resultSet.getString(2));
						item.setPrice(resultSet.getFloat(3));
						item.setLocation(resultSet.getString(4));
						item.setNumInInventory(resultSet.getInt(5));
						if(resultSet.getInt(6)==1) {
							item.setVisable(true);
						}
						else {
							item.setVisable(false);
						}
						result.setItem(item);
						
					}
					// check if any authors were found
					if (!found) {
						System.out.println("No catalog items were found in the database");
					}
					else
						System.out.println("We got all catalog items");
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public ArrayList<Notification> getNotifications() {
		return executeTransaction(new Transaction<ArrayList<Notification>>() {
			@Override
			public ArrayList<Notification> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;

				PreparedStatement stmt2 = null;
				ResultSet resultSet2 = null;
				try {
					stmt = conn.prepareStatement(
							"select * from notifications " +
							" order by notification_id"
					);
					
					ArrayList<Notification> result = new ArrayList<Notification>();
					resultSet = stmt.executeQuery();
					
					stmt2 = conn.prepareStatement(
							"select * from notificationRecipients " +
							" order by notification_id"
					);
					
					resultSet2 = stmt2.executeQuery();
					// for testing that a result was returned
					Boolean found = false;
					ArrayList<Pair<String, String>> junction = new ArrayList<Pair<String, String>>();
					while (resultSet2.next()) {
						Pair<String, String> pair = new Pair<String, String>();
						pair.setLeft(resultSet.getString(1));
						pair.setRight(resultSet.getString(2));
						junction.add(pair);
					}
					
					while (resultSet.next()) {
						found = true;
						Notification notify = new Notification();
						notify.setNotificationID(resultSet.getString(1));
						notify.setSourceAccountNumber(resultSet.getString(2));
						notify.setMessage(resultSet.getString(3));
						for(Pair<String, String> pair : junction) {
							if(notify.getNotificationID().equals(pair.getLeft())) {
								notify.addDestinationName(pair.getRight());
							}
						}
						result.add(notify);
					}
					
					// check if any authors were found
					if (!found) {
						System.out.println("No Notifications were found in the database");
					}
					else
						System.out.println("We got all Notification");
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
					DBUtil.closeQuietly(resultSet2);
					DBUtil.closeQuietly(stmt2);
				}
			}
		});
	}

	@Override
	public ArrayList<Item> getVisibleItems() {
		return executeTransaction(new Transaction<ArrayList<Item>>() {
			@Override
			public ArrayList<Item> execute(Connection conn) throws SQLException {
				PreparedStatement stmt = null;
				ResultSet resultSet = null;
				
				try {
					stmt = conn.prepareStatement(
							"select * from catalog " +
							" order by item_id"
					);
					
					ArrayList<Item> result = new ArrayList<Item>();
					resultSet = stmt.executeQuery();
					
					
					
					boolean found= false;
					while (resultSet.next()) {
						found = true;
						if(resultSet.getInt(6)==1) {
							Item item= new Item();
							item.setUPC(resultSet.getString(1));
							item.setItemName(resultSet.getString(2));
							item.setPrice(resultSet.getFloat(3));
							item.setLocation(resultSet.getString(4));
							item.setNumInInventory(resultSet.getInt(5));
							item.setVisable(true);
							result.add(item);
						}
					}
					// check if any authors were found
					if (!found) {
						System.out.println("No visible items were found in the database");
					}
					else
						System.out.println("We got all visible items");
					return result;
				} finally {
					DBUtil.closeQuietly(resultSet);
					DBUtil.closeQuietly(stmt);
				}
			}
		});
	}

	@Override
	public void setVisibility(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addNotification(Notification notify) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Notification> getNotifications(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notification getNotification(String notificationID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Notification> getSourceNotifications(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPasswordForCustomerAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPasswordForEmployeeAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeAccount getEmployeeAccount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerAccount getCustomerAccount(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEmployeeAccount(EmployeeAccount account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addCustomerAccount(CustomerAccount account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getAccount(String accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastCustomerAccountNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLastEmployeeAccountNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNotification(String notification_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<String> AllEmployeeNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateNotification(Notification notify) {
		// TODO Auto-generated method stub
		
	}
}
