package edu.ycp.cs320.JKSOrders.database;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Inventory;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;

public interface Database {

	public ArrayList<EmployeeAccount> getEmployeeAccounts();
	
	public ArrayList<CustomerAccount> getCustomerAccounts();
	
	public ArrayList<LoginInfo> getEmployeeLoginInfo();
	
	public ArrayList<LoginInfo> getCustomerLoginInfo();
	
	public Inventory getInventory();
	
	public Catalog getCatalog();
	
	public ArrayList<Notification> getNotifications();
}
