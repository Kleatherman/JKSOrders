package edu.ycp.cs320.JKSOrders.database;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.classes.Order;

public interface Database {

	/**
	 * @return All Employee Accounts
	 */
	public ArrayList<EmployeeAccount> getEmployeeAccounts();
	
	/**
	 * @return All customer accounts
	 */
	public ArrayList<CustomerAccount> getCustomerAccounts();
	
	/**
	 * @return All Employee Login Info
	 */
	public ArrayList<LoginInfo> getEmployeeLoginInfo();
	
	/**
	 * @return All Customer Login Info
	 */
	public ArrayList<LoginInfo> getCustomerLoginInfo();
	
	
	/**
	 * @return The Catalog
	 */
	public Catalog getCatalog();
	
	/**
	 * @return All notifications in the system currently
	 */
	public ArrayList<Notification> getNotifications();
	
	/**
	 * 
	 * @return All items that are visible
	 */
	public ArrayList<Item> getVisibleItems();
	
	/**
	 * 
	 * @param x - Go through the catalog and set all items under x to notVisible
	 */
	public void setVisibility(int x);
	
	/**
	 * 
	 * @param notify - Add this notification to the system
	 */
	public void addNotification(Notification notify);
	
	/**
	 * 
	 * @param accountNumber
	 * @return - All notifications that has this account as a destination
	 */
	public ArrayList<Notification> getNotifications(String accountNumber);
	
	/**
	 * 
	 * @param notificationID
	 * @return the notification that has this notificationID
	 */
	public Notification getNotification(String notificationID);

	/**
	 * 
	 * @param accountNumber
	 * @return All notifications that were created by this account
	 */
	public ArrayList<Notification> getSourceNotifications(String accountNumber);
	
	/**
	 * 
	 * @param account
	 * @return return the password for the customer account
	 */
	public String getPasswordForCustomerAccount(Account account);

	/**
	 * 
	 * @param account
	 * @return return the password for the employee account
	 */
	public String getPasswordForEmployeeAccount(Account account);

	/**
	 * 
	 * @param name - Either AccountID, userName or Name
	 * @return the account that has that string associated with it
	 */
	public EmployeeAccount getEmployeeAccount(String name);
	
	/**
	 * 
	 * @param name - Either AccountID, userName or Name
	 * @return the account that has that string associated with it
	 */
	public CustomerAccount getCustomerAccount(String name);
	
	/**
	 * 
	 * @param account - add the following account to the list of employeeAccounts
	 */
	public void addEmployeeAccount(EmployeeAccount account);
	
	/**
	 * 
	 * @param account
	 */
	public void addCustomerAccount(CustomerAccount account);
	
	public Account getAccount(String accountNumber);
	
	public String getLastCustomerAccountNumber();
	
	public String getLastEmployeeAccountNumber();
	
	public void deleteNotification(String notification_id);
	
	public ArrayList<String> AllEmployeeNames();

	public void updateNotification(Notification notify);
	
	public String getLastOrderNumber();
	
	public void addOrder(Order order);
	
	public void updateOrder(Order order);
	
	public Order getOrder(String orderNumber);

	public ArrayList<Order> getOrders();
}
