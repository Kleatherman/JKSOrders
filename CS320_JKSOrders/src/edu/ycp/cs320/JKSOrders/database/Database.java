package edu.ycp.cs320.JKSOrders.database;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Inventory;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;

public interface Database {

	/**
	 * @return
	 */
	public ArrayList<EmployeeAccount> getEmployeeAccounts();
	
	/**
	 * @return
	 */
	public ArrayList<CustomerAccount> getCustomerAccounts();
	
	/**
	 * @return
	 */
	public ArrayList<LoginInfo> getEmployeeLoginInfo();
	
	/**
	 * @return
	 */
	public ArrayList<LoginInfo> getCustomerLoginInfo();
	
	/**
	 * @return
	 */
	public Inventory getInventory();
	
	/**
	 * @return
	 */
	public Catalog getCatalog();
	
	/**
	 * @return
	 */
	public ArrayList<Notification> getNotifications();
	
	public ArrayList<Item> getVisibleItems();
	
	public void setVisibility(int x);
	
	public void addNotification(Notification notify);
	
	public ArrayList<Notification> getNotifications(String accountNumber);
	
	public Notification getNotification(String notificationID);

	public ArrayList<Notification> getSourceNotifications(String accountNumber);
	
	public String getPasswordForCustomerAccount(Account account);

	public String getPasswordForEmployeeAccount(Account account);

	public EmployeeAccount getEmployeeAccount(String name);
	
	public CustomerAccount getCustomerAccount(String name);
	
	public void addEmployeeAccount(EmployeeAccount account);
	
	public void addCustomerAccount(CustomerAccount account);
	
	public Account getAccount(String accountNumber);
	
	public String getLastCustomerAccountNumber();
	
	public String getLastEmployeeAccountNumber();
	
	public void deleteNotification(String notification_id);
	
	public ArrayList<String> AllEmployeeNames();

	public void updateNotification(Notification notify);
}
