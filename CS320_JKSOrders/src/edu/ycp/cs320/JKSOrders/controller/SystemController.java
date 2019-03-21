package edu.ycp.cs320.JKSOrders.controller;

import java.util.ArrayList;
import java.util.Iterator;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Inventory;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.database.Database;


public class SystemController {
	private ArrayList<LoginInfo> employeeLogin;
	private ArrayList<LoginInfo> customerLogin;
	private ArrayList<Account> employeeAccounts;
	private ArrayList<Account> customerAccounts;
	private Inventory inventory;
	private Catalog catalog;
	private ArrayList<Notification> notifications;
	
	public SystemController() {
		employeeLogin = new ArrayList<LoginInfo>();
		customerLogin = new ArrayList<LoginInfo>();
		notifications = new ArrayList<Notification>();
		inventory = new Inventory();
		catalog = new Catalog();
		employeeAccounts = new ArrayList<Account>();
		customerAccounts = new ArrayList<Account>();
		
		initializeEmployeeAccountArrayList(employeeAccounts);
		initializeCustomerAccountArrayList(customerAccounts);
		initializeEmployeeLoginArrayList(employeeLogin);
		initializeCustomerLoginArrayList(customerLogin);
		initilizeCatalogInventory(catalog, inventory);
	}
	
	/**
	 * @param loginTest
	 * @param logins
	 * @return
	 */
	public boolean verifyEmployeeLoginInfo(LoginInfo loginTest, ArrayList<LoginInfo> logins) {
		/*System.out.println("Test login: "+loginTest.getPassword()+" "+loginTest.getUserName());
		Iterator<LoginInfo> i = employeeLogin.iterator();
		while(i.hasNext()) {
			if(i.next().equals(loginTest)) {
				return true;
			}
		}
		return false;*/
		
		System.out.println("Test login: "+loginTest.getPassword()+" "+loginTest.getUserName());
		Iterator<LoginInfo> i = logins.iterator();
		while(i.hasNext()) {
			if(i.next().equals(loginTest)) {
				return true;
			}
		}
		return false;
	}
	
<<<<<<< HEAD
	public boolean verifyCustomerLoginInfo(LoginInfo loginTest, ArrayList<LoginInfo> logins) {
		/*System.out.println("Test login: "+loginTest.getPassword()+" "+loginTest.getUserName());
=======
	/**
	 * @param loginTest
	 * @return
	 */
	public boolean verifyCustomerLoginInfo(LoginInfo loginTest) {
		System.out.println("Test login: "+loginTest.getPassword()+" "+loginTest.getUserName());
>>>>>>> master
		Iterator<LoginInfo> i = customerLogin.iterator();
		while(i.hasNext()) {
			if(i.next().equals(loginTest)) {
				return true;
			}
		}
		return false;*/
		
		System.out.println("Test login: "+loginTest.getPassword()+" "+loginTest.getUserName());
		Iterator<LoginInfo> i = logins.iterator();
		while(i.hasNext()) {
			if(i.next().equals(loginTest)) {
				return true;
			}
		}
		return false;
	}
	
	public void createNotification(Notification notify, Database db) {
		db.addNotification(notify);
	}

	/**
	 * @param item
	 */
	public void updateCatalogItem(Item item) {
		catalog.setItem(item);		
	}

	public void createAccount() {
		
	}
	
	/**
	 * @param x
	 */
	public void setVisability(int x) {
		System.out.println("Setting visability");
		ArrayList<String> less = new ArrayList<String>();
		ArrayList<String> more = new ArrayList<String>();
		inventory.returnGreaterorLess(x, more, less);
		for(int i = 0; i<more.size(); i++) {
			catalog.getItem(more.get(i)).setVisable(true);
		}
		for(int j = 0; j<less.size(); j++) {
			catalog.getItem(less.get(j)).setVisable(false);
		}
		
	}
	
	private void initializeEmployeeLoginArrayList(ArrayList<LoginInfo> logins) {
		Iterator<Account> i = employeeAccounts.iterator();
		while(i.hasNext()) {
			Account account = i.next();
			System.out.println("initilize Employee Login: "+account.getLogin().getPassword()+" "+account.getLogin().getUserName()+" "+account.getName());
			logins.add(account.getLogin());
		}
	}
	
	private void initializeCustomerLoginArrayList(ArrayList<LoginInfo> logins) {
		Iterator<Account> i = customerAccounts.iterator();
		while(i.hasNext()) {
			Account account = i.next();
			System.out.println("initilize customer Login: "+account.getLogin().getPassword()+" "+account.getLogin().getUserName()+" "+account.getName());
			logins.add(account.getLogin());
		}
	}

	private void initializeEmployeeAccountArrayList(ArrayList<Account> accounts) {
		EmployeeAccount account;
		String[] names = {"John Adams", "William Wallace", "Henry Morris", "Thomas Edison", "Nikola Tesla", "Kyle Leatherman", "Josiah Sam", "Sam Cesario", "Don Hake", "Elvis Presley"};
		LoginInfo login;
		for(int i = 0; i<10; i++) {
			account = new EmployeeAccount();
			account.setAccountNumber("ABCDEF"+i);
			account.setName(names[i]);
			login = new LoginInfo();
			login.setPassword("PassWord"+i);
			login.setUserName("employee"+i);
			System.out.println("employee account initilization" + login.getPassword()+" "+login.getUserName());
			account.setLogin(login);
			System.out.println("employee account initilization" + account.getLogin().getPassword()+" "+account.getLogin().getUserName());
			if(account.getName().equals("Josiah Sam")||account.getName().equals("Kyle Leatherman")||account.getName().equals("Sam Cesario")) {
				account.setManager(true);
			}
			if(account.getName().equals("Josiah Sam")) {
				login.setPassword("FireFox7");
				login.setUserName("jsam");
				account.setLogin(login);
			}
			else if(account.getName().equals("Kyle Leatherman")) {
				login.setPassword("BadPassword");
				login.setUserName("McGee");
				account.setLogin(login);
			}
			else if(account.getName().equals("Sam Cesario")) {
				login.setPassword("password");
				login.setUserName("scesario1");
				account.setLogin(login);
			}
			employeeAccounts.add(account);
		}
	}
	
	private void initializeCustomerAccountArrayList(ArrayList<Account> accounts) {
		Account account;
		String[] names = {"Adams John", "Wallace William", "Morris Henry", "Edison Thomas", "Tesla Nikola", "Leathermen Kyle", "Sam Josiah", "Cesario Sam", "Hake Don", "Presley Elvis"};
		for(int i = 0; i<10; i++) {
			account = new CustomerAccount();
			account.setAccountNumber("GHIJKL"+i);
			account.setName(names[i]);
			LoginInfo login = new LoginInfo();
			login.setPassword("password"+i);
			login.setUserName("user"+i);
			account.setLogin(login);
			customerAccounts.add(account);
		}
	}
	
	public ArrayList<Item> getVisibleItems() {
		ArrayList<Item> visibleItems = new ArrayList<Item>();
		Iterator<String> i = catalog.getItemMap().keySet().iterator();
		while(i.hasNext()) {
			Item item = catalog.getItem(i.next());
			if(item.isVisable()) {
				visibleItems.add(item);
				System.out.println(item.getDescription());
			}
		}
		return visibleItems;
	}
	
	private void initilizeCatalogInventory(Catalog catalog, Inventory inventory) {
		String[] itemNames = {"Tomatoes", "Apples", "Oranges", "Pecans", "Pumkins"};
		System.out.println("Initilizing Inventory and Catalog");
		for(int i = 0; i<itemNames.length; i++) {
			Item item = new Item();
			item.setItemName(itemNames[i]);
			item.setUPC(itemNames[i]+i);
			item.setPrice(11.1*i);
			item.setDescription(itemNames[i]+" are one of many delicious options we offer. They are only $"+item.getPrice()+".");
			System.out.println(item.getDescription());
			item.setLocation("A"+i+"B"+(5-1));
			catalog.setItemKey(item);
			inventory.setItemQuantity(item.getUPC(), i);
		}
		
		this.setVisability(2);
	}
	
	public Account getEmployeeAccount(String name) {
		Iterator<Account> i = employeeAccounts.iterator();
		while(i.hasNext()) {
			Account account = i.next();
			if(account.getLogin().getUserName().equals(name)) {
				return account;
			}	
		}
		return null;
	}
}
