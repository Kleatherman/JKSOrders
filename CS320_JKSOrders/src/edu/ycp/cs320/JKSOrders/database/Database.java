package edu.ycp.cs320.JKSOrders.database;

import java.util.ArrayList;

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

}