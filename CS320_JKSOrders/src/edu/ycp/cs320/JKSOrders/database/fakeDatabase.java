package edu.ycp.cs320.JKSOrders.database;

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

public class fakeDatabase implements Database{
	private Catalog catalog;
	private ArrayList<CustomerAccount> customerAccounts;
	private ArrayList<LoginInfo> customerLogin;
	private ArrayList<EmployeeAccount> employeeAccounts;
	private ArrayList<LoginInfo> employeeLogin;
	private Inventory inventory;
	private ArrayList<Notification> notifications;
	
	public fakeDatabase() {
		
	}
	
	/* (non-Javadoc)
	 * @see edu.ycp.cs320.JKSOrders.database.database#getCatalog()
	 */
	@Override
	public Catalog getCatalog() {
		catalog = new Catalog();
		inventory = new Inventory();
		initilizeCatalogInventory(catalog, inventory);
		return catalog;
	}

	/* (non-Javadoc)
	 * @see edu.ycp.cs320.JKSOrders.database.database#getCustomerAccounts()
	 */
	@Override
	public ArrayList<CustomerAccount> getCustomerAccounts() {
		customerAccounts = new ArrayList<CustomerAccount>();
		initializeCustomerAccountArrayList(customerAccounts);
		return customerAccounts;
	}
	
	/* (non-Javadoc)
	 * @see edu.ycp.cs320.JKSOrders.database.database#getCustomerLoginInfo()
	 */
	@Override
	public ArrayList<LoginInfo> getCustomerLoginInfo() {
		customerLogin = new ArrayList<LoginInfo>();
		initializeCustomerLoginArrayList(customerLogin);
		return customerLogin;
	}

	/* (non-Javadoc)
	 * @see edu.ycp.cs320.JKSOrders.database.database#getEmployeeAccounts()
	 */
	@Override
	public ArrayList<EmployeeAccount> getEmployeeAccounts(){
		employeeAccounts = new ArrayList<EmployeeAccount>();
		initializeEmployeeAccountArrayList(employeeAccounts);
		return employeeAccounts;
	}

	/* (non-Javadoc)
	 * @see edu.ycp.cs320.JKSOrders.database.database#getEmployeeLoginInfo()
	 */
	@Override
	public ArrayList<LoginInfo> getEmployeeLoginInfo() {
		employeeLogin = new ArrayList<LoginInfo>();
		initializeEmployeeLoginArrayList(employeeLogin);
		return employeeLogin;
	}

	/* (non-Javadoc)
	 * @see edu.ycp.cs320.JKSOrders.database.database#getInventory()
	 */
	@Override
	public Inventory getInventory() {
		catalog = new Catalog();
		inventory = new Inventory();
		initilizeCatalogInventory(catalog, inventory);
		return inventory;
	}

	/* (non-Javadoc)
	 * @see edu.ycp.cs320.JKSOrders.database.database#getNotifications()
	 */
	@Override
	public ArrayList<Notification> getNotifications() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void initializeCustomerAccountArrayList(ArrayList<CustomerAccount> accounts) {
		CustomerAccount account;
		String[] names = {"Adams John", "Wallace William", "Morris Henry", "Edison Thomas", "Tesla Nikola", "Leathermen Kyle", "Sam Josiah", "Cesario Sam", "Hake Don", "Presley Elvis"};
		for(int i = 0; i<10; i++) {
			account = new CustomerAccount();
			account.setAccountNumber("GHIJKL"+i);
			account.setName(names[i]);
			LoginInfo login = new LoginInfo();
			login.setPassword("password"+i);
			login.setUserName("user"+i);
			account.setLogin(login);
			accounts.add(account);
		}
	}
	
	private void initializeCustomerLoginArrayList(ArrayList<LoginInfo> logins) {
		ArrayList<CustomerAccount> accounts = getCustomerAccounts();
		Iterator<CustomerAccount> i = accounts.iterator();
		while(i.hasNext()) {
			Account account = i.next();
			System.out.println("initilize customer Login: "+account.getLogin().getPassword()+" "+account.getLogin().getUserName()+" "+account.getName());
			logins.add(account.getLogin());
		}
	}
	
	private void initializeEmployeeAccountArrayList(ArrayList<EmployeeAccount> accounts) {
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
			accounts.add(account);
		}
	}

	private void initializeEmployeeLoginArrayList(ArrayList<LoginInfo> logins) {
		ArrayList<EmployeeAccount> accounts = getEmployeeAccounts();
		Iterator<EmployeeAccount> i = accounts.iterator();
		while(i.hasNext()) {
			Account account = i.next();
			System.out.println("initilize Employee Login: "+account.getLogin().getPassword()+" "+account.getLogin().getUserName()+" "+account.getName());
			logins.add(account.getLogin());
		}
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
		
		this.setVisibility(2);
	}
	

	@Override
	public ArrayList<Item> getVisibleItems() {
		catalog = new Catalog();
		inventory = new Inventory();
		initilizeCatalogInventory(catalog, inventory);
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

	@Override
	public void setVisibility(int x) {
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

	@Override
	public void addNotification(Notification notify) {
		initilizeNotificationArrayList();
		notifications = new ArrayList<Notification>();
		notifications.add(notify);
	}
	
	private void initilizeNotificationArrayList() {
		employeeAccounts = new ArrayList<EmployeeAccount>();
		notifications = new ArrayList<Notification>();
		Notification notify;
		initializeEmployeeAccountArrayList(employeeAccounts);
		for(int i = 0; i<3; i++) {
			notify = new Notification();
			notify.addDestinationName(employeeAccounts.get(i).getAccountNumber());
			notify.addDestinationName(employeeAccounts.get(i+3).getAccountNumber());
			notify.addDestinationName(employeeAccounts.get(i+6).getAccountNumber());
			notify.setUrgency(i==2);
			notify.setMessage("This is notification "+i+". Please respond ASAP!");
			notify.setNotificationID("ABCD"+i);
			notifications.add(notify);
		}
	}

	@Override
	public ArrayList<Notification> getNotifications(String accountNumber) {
		initilizeNotificationArrayList();
		ArrayList<Notification> accountNotifications = new ArrayList<Notification>();
		for(Notification notify : notifications) {
			for(String destName : notify.getDestination()) {
				if(destName.equals(accountNumber)) {
					accountNotifications.add(notify);
				}
			}	
		}
		return accountNotifications;
	}

	@Override
	public Notification getNotification(String notificationID) {
		initilizeNotificationArrayList();
		for(Notification notify : notifications) {
			if(notify.getNotificationID().equals(notificationID)) {
				return notify;
			}
		}
		return null;
	}
	

}
