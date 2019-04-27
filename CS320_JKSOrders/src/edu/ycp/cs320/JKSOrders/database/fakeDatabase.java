package edu.ycp.cs320.JKSOrders.database;

import java.util.ArrayList;
import java.util.Iterator;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.classes.Order;

public class fakeDatabase implements Database{
	private Catalog catalog;
	private ArrayList<CustomerAccount> customerAccounts;
	private ArrayList<LoginInfo> customerLogin;
	private ArrayList<EmployeeAccount> employeeAccounts;
	private ArrayList<LoginInfo> employeeLogin;
	private ArrayList<Notification> notifications;
	private ArrayList<Order> orders;
	
	public fakeDatabase() {
		initilizeNotificationArrayList();
		catalog = new Catalog();
		this.initilizeCatalog(catalog);
		initilizeOrderArrayList();
	}
	
	private void initilizeOrderArrayList() {
		orders = new ArrayList<Order>();
		for(int i = 0; i<2; i++) {
			Order order = new Order();
			if(i==0) {
				order.setOrderType("P"+i);
				order.setAccountNum(this.getLastCustomerAccountNumber());
				order.addItem(catalog.returnItemList().get(0), 5);
				order.addItem(catalog.returnItemList().get(catalog.returnItemList().size()-2), 8);
				order.setTotalPrice();
			}
			else {
				order.setOrderType("I"+i);
				order.setAccountNum(this.getCustomerAccounts().get(0).getAccountNumber());
				order.addItem(catalog.returnItemList().get(catalog.returnItemList().size()-2), 3);
				order.addItem(catalog.returnItemList().get(0), 1);
				order.setTotalPrice();
			}
			System.out.println("This is the total price of order: "+order.getOrderType()+". It has "+order.getQuantityMap().get(order.getItemlist().get(0).getUPC()) +
					" of "+order.getItemlist().get(0).getItemName()+" which are priced "+order.getItemlist().get(0).getPrice()+". It also has "+
					order.getQuantityMap().get(order.getItemlist().get(1).getUPC()) +
					" of "+order.getItemlist().get(1).getItemName()+" which are priced "+order.getItemlist().get(1).getPrice()+
					". So it's total price is "+order.getTotalPrice());
			orders.add(order);
		}
	}

	/* (non-Javadoc)
	 * @see edu.ycp.cs320.JKSOrders.database.database#getCatalog()
	 */
	@Override
	public Catalog getCatalog() {
		catalog = new Catalog();
		initilizeCatalog(catalog);
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
			account.setFirstName(names[i]);
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
			account.setFirstName(names[i]);
			login = new LoginInfo();
			login.setPassword("PassWord"+i);
			login.setUserName("employee"+i);
			account.setLogin(login);
			if(account.getFirstName().equals("Josiah Sam")||account.getFirstName().equals("Kyle Leatherman")||account.getFirstName().equals("Sam Cesario")) {
				account.setManager(true);
			}
			if(account.getFirstName().equals("Josiah Sam")) {
				login.setPassword("FireFox7");
				login.setUserName("jsam");
				account.setLogin(login);
				account.setAccountNumber("M2");
			}
			else if(account.getFirstName().equals("Kyle Leatherman")) {
				login.setPassword("BadPassword");
				login.setUserName("McGee");
				account.setLogin(login);
				account.setAccountNumber("M1");
			}
			else if(account.getFirstName().equals("Sam Cesario")) {
				login.setPassword("password");
				login.setUserName("scesario1");
				account.setLogin(login);
				account.setAccountNumber("M0");
			}
			accounts.add(account);
		}
	}

	private void initializeEmployeeLoginArrayList(ArrayList<LoginInfo> logins) {
		ArrayList<EmployeeAccount> accounts = getEmployeeAccounts();
		Iterator<EmployeeAccount> i = accounts.iterator();
		while(i.hasNext()) {
			Account account = i.next();
			logins.add(account.getLogin());
		}
	}
	
	private void initilizeCatalog(Catalog catalog){
		String[] itemNames = {"Tomatoes", "Apples", "Oranges", "Pecans", "Pumkins"};
		for(int i = 0; i<itemNames.length; i++) {
			Item item = new Item();
			item.setItemName(itemNames[i]);
			item.setUPC(itemNames[i]+i);
			item.setPrice(11.1*i);
			item.setDescription(itemNames[i]+" are one of many delicious options we offer. They are only $"+item.getPrice()+".");
			item.setLocation("A"+i+"B"+(5-1));
			catalog.setItemKey(item);
			item.setNumInInventory(i);
		}
		
		this.setVisibility(2);
	}
	
	@Override
	public ArrayList<Item> getVisibleItems() {
		catalog = new Catalog();
	
		initilizeCatalog(catalog);
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
		catalog.returnGreaterorLess(x, more, less);
		for(int i = 0; i<more.size(); i++) {
			catalog.getItem(more.get(i)).setVisable(true);
		}
		for(int j = 0; j<less.size(); j++) {
			catalog.getItem(less.get(j)).setVisable(false);
		}
	}

	@Override
	public void addNotification(Notification notify) {
		notifications = new ArrayList<Notification>();
		initilizeNotificationArrayList();
		if(notify.getNotificationID()==null)
			notify.setNotificationID(generateNotificationCode(notify.getUrgency(), notifications.size()+1));
		notifications.add(notify);
		Notification notification = new Notification();
		notification = notifications.get(notifications.size()-1);
		System.out.println("This is a new notification "+notification.getNotificationID()+". Message reads: "+notification.getMessage());
		System.out.println("This is the source account number: "+notification.getSourceAccountNumber()+". These are the destination numbers: ");
		for(String numbers : notification.getDestination()) {
			System.out.println(numbers);
		}
	}
	
	private void initilizeNotificationArrayList() {
		employeeAccounts = new ArrayList<EmployeeAccount>();
		notifications = new ArrayList<Notification>();
		Notification notify;
		initializeEmployeeAccountArrayList(employeeAccounts);
		String[] accountNumberManagers = {employeeAccounts.get(5).getAccountNumber(), employeeAccounts.get(6).getAccountNumber(), employeeAccounts.get(7).getAccountNumber()};
		for(int i = 0; i<3; i++) {
			notify = new Notification();
			notify.addDestinationName(employeeAccounts.get(i).getAccountNumber());
			notify.addDestinationName(employeeAccounts.get(i+3).getAccountNumber());
			notify.addDestinationName(employeeAccounts.get(i+6).getAccountNumber());
			notify.setSourceAccountNumber(accountNumberManagers[i]);
			notify.setUrgency(i==2);
			notify.setMessage("This is notification "+i+". Please respond ASAP!");
			notify.setNotificationID(generateNotificationCode(notify.getUrgency(), notifications.size()));
			notifications.add(notify);
		}
	}

	@Override
	public ArrayList<Notification> getNotifications(String accountNumber) {
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
		for(Notification notify : notifications) {
			if(notify.getNotificationID().equals(notificationID)) {
				return notify;
			}
		}
		return null;
	}

	@Override
	public String getPasswordForCustomerAccount(Account account) {
		customerAccounts = new ArrayList<CustomerAccount>();
		initializeCustomerAccountArrayList(customerAccounts);
		for(Account cAccount : customerAccounts ) {
			if(cAccount.getLogin().getUserName().equals(account.getLogin().getUserName())) {
				return cAccount.getLogin().getPassword();
			}
		}
		return "Account was not found";
	}
	
	@Override
	public String getPasswordForEmployeeAccount(Account account) {
		employeeAccounts = new ArrayList<EmployeeAccount>();
		initializeEmployeeAccountArrayList(employeeAccounts);
		for(Account eAccount : employeeAccounts ) {
			if(eAccount.getLogin().getUserName().equals(account.getLogin().getUserName())) {
				return eAccount.getLogin().getPassword();
			}
		}
		
		return "Account was not found";
	}

	@Override
	public Account getAccount(String accountNumber) {
		employeeAccounts = new ArrayList<EmployeeAccount>();
		initializeEmployeeAccountArrayList(employeeAccounts);
		customerAccounts = new ArrayList<CustomerAccount>();
		initializeCustomerAccountArrayList(customerAccounts);
		for(Account account : employeeAccounts) {
			if(account.getAccountNumber().equals(accountNumber)||account.getFirstName().equals(accountNumber)||account.getLogin().getUserName().equals(accountNumber)) {
				return account;
			}
		}
		for(Account account : customerAccounts) {
			if(account.getAccountNumber().equals(accountNumber)||account.getFirstName().equals(accountNumber)||account.getLogin().getUserName().equals(accountNumber)) {
				return account;
			}
		}
		return null;

	}

	@Override
	public EmployeeAccount getEmployeeAccount(String Accountnum) {
		employeeAccounts = new ArrayList<EmployeeAccount>();
		initializeEmployeeAccountArrayList(employeeAccounts);
		for(EmployeeAccount account : employeeAccounts) {
			if(account.getAccountNumber().equals(Accountnum)||account.getFirstName().equals(Accountnum)||account.getLogin().getUserName().equals(Accountnum)) {
				return account;
			}
		}
		return null;
	}

	@Override
	public CustomerAccount getCustomerAccount(String Accountnum) {
		customerAccounts = new ArrayList<CustomerAccount>();
		initializeCustomerAccountArrayList(customerAccounts);
		for(CustomerAccount account : customerAccounts) {
			if(account.getAccountNumber().equals(Accountnum)||account.getFirstName().equals(Accountnum)||account.getLogin().getUserName().equals(Accountnum)) {
				return account;
			}
		}
		return null;
	}

	@Override
	public void addEmployeeAccount(EmployeeAccount account) {
		employeeAccounts = new ArrayList<EmployeeAccount>();
		initializeEmployeeAccountArrayList(employeeAccounts);
		employeeAccounts.add(account);
		System.out.println("new employee Login: "+employeeAccounts.get(employeeAccounts.size()-1).getLogin().getPassword()+" "+employeeAccounts.get(employeeAccounts.size()-1).getLogin().getUserName()+" "+employeeAccounts.get(employeeAccounts.size()-1).getFirstName());
	}

	@Override
	public void addCustomerAccount(CustomerAccount account) {
		customerAccounts = new ArrayList<CustomerAccount>();
		initializeCustomerAccountArrayList(customerAccounts);
		customerAccounts.add(account);
		System.out.println("new customer Login: "+customerAccounts.get(customerAccounts.size()-1).getLogin().getPassword()+" "+customerAccounts.get(customerAccounts.size()-1).getLogin().getUserName()+" "+customerAccounts.get(customerAccounts.size()-1).getFirstName());
		
	}

	@Override
	public String getLastCustomerAccountNumber() {
		customerAccounts = new ArrayList<CustomerAccount>();
		initializeCustomerAccountArrayList(customerAccounts);
		
		return customerAccounts.get(customerAccounts.size()-1).getAccountNumber() ;
		
		
	}

	@Override
	public String getLastEmployeeAccountNumber() {
		
		employeeAccounts = new ArrayList<EmployeeAccount>();
		initializeEmployeeAccountArrayList(employeeAccounts);
		return employeeAccounts.get(employeeAccounts.size()-1).getAccountNumber() ;
		
	}
	


	@Override
	public ArrayList<String> AllEmployeeNames() {
		employeeAccounts = new ArrayList<EmployeeAccount>();
		initializeEmployeeAccountArrayList(employeeAccounts);
		ArrayList<String> employeeNames = new ArrayList<String>();
		for(EmployeeAccount account : employeeAccounts) {
			employeeNames.add(account.getFirstName());
		}
		return employeeNames;
	}
	
	private String generateNotificationCode(boolean urgent, int i) {
		if(urgent) {
			return "UABCD"+i;
		}
		return "NABCD"+i;
	}

	
	@Override
	public ArrayList<Notification> getSourceNotifications(String accountNumber) {
		ArrayList<Notification> accountNotifications = new ArrayList<Notification>();
		for(Notification notify : notifications) {
			if(notify.getSourceAccountNumber().equals(accountNumber)) {
				accountNotifications.add(notify);
			}	
		}
		return accountNotifications;
	}

	@Override
	public void updateNotification(Notification notify) {
		deleteNotification(notify.getNotificationID());
		addNotification(notify);
	}

	@Override
	public void deleteNotification(String notification_id) {
		System.out.println("We are in the deleteNotification Method");
		Iterator<Notification> i = notifications.iterator();
		while(i.hasNext()) {
			Notification note = i.next();
			if(note.getNotificationID().equals(notification_id)) {
				i.remove();
			}
		}
		System.out.println("Successfully deleted notification "+notification_id);
	}

	@Override
	public String getLastOrderNumber() {
		return orders.get(orders.size()-1).getOrderType();
	}

	@Override
	public void addOrder(Order order) {
		orders.add(order);
		Order newOrder = orders.get(orders.size()-1);
		System.out.println("A new order has been created!! Order number: "+newOrder.getOrderType()+" with this price: "+newOrder.getTotalPrice()+" And the owner account "+newOrder.getAccountNum()+"And the following items: ");
		for(Item item : newOrder.getItemlist()) {
			System.out.println(item.getItemName()+" : "+ item.getUPC()+" : "+item.getPrice()+" : "+newOrder.getQuantityMap().get(item.getUPC()));
		}
	}

	@Override
	public void updateOrder(Order updateOrder) {
		for(Order order : orders) {
			if(order.getOrderType().equals(updateOrder)) {
				orders.remove(order);
				orders.add(updateOrder);
			}
		}
		Order newOrder = orders.get(orders.size()-1);
		System.out.println("An order has been Updated!! Order number: "+newOrder.getOrderType()+" with this price: "+newOrder.getTotalPrice()+" And the owner account "+newOrder.getAccountNum()+"And the following items: ");
		for(Item item : newOrder.getItemlist()) {
			System.out.println(item.getItemName()+" : "+ item.getUPC()+" : "+item.getPrice()+" : "+newOrder.getQuantityMap().get(item.getUPC()));
		}
	}

	@Override
	public Order getOrder(String orderNumber) {
		for(Order order : orders) {
			if(order.getOrderType().equals(orderNumber)) {
				return order;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Order> getOrders() {
		return orders;
	}

	@Override
	public ArrayList<Car> getCars() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAccount(String accountNumber) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
