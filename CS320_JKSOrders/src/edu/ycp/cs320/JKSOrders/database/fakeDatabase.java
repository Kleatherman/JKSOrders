package edu.ycp.cs320.JKSOrders.database;

import java.util.ArrayList;
import java.util.Iterator;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Inventory;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;

public class fakeDatabase implements database{
	private ArrayList<LoginInfo> employeeLogin;
	private ArrayList<LoginInfo> customerLogin;
	private ArrayList<EmployeeAccount> employeeAccounts;
	private ArrayList<CustomerAccount> customerAccounts;
	private Inventory inventory;
	private Catalog catalog;
	private ArrayList<Notification> notifications;
	
	public fakeDatabase() {
		
	}
	
	@Override
	public ArrayList<EmployeeAccount> getEmployeeAccounts(){
		employeeAccounts = new ArrayList<EmployeeAccount>();
		initializeEmployeeAccountArrayList(employeeAccounts);
		return employeeAccounts;
	}
	

	@Override
	public ArrayList<CustomerAccount> getCustomerAccounts() {
		customerAccounts = new ArrayList<CustomerAccount>();
		initializeCustomerAccountArrayList(customerAccounts);
		return customerAccounts;
	}
	

	@Override
	public ArrayList<LoginInfo> getEmployeeLoginInfo() {
		employeeLogin = new ArrayList<LoginInfo>();
		initializeEmployeeLoginArrayList(employeeLogin);
		return employeeLogin;
	}

	@Override
	public ArrayList<LoginInfo> getCustomerLoginInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventory getInventory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Catalog getCatalog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Notification> getNotifications() {
		// TODO Auto-generated method stub
		return null;
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
}
