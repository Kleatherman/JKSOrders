package edu.ycp.cs320.JKSOrders.model;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.classes.Order;

public class WorkPage {
	
	private EmployeeAccount eaccount;
	private CustomerAccount caccount;
	private ArrayList<Order> orders;
	private ArrayList<Notification> sourceNotifications;
	private ArrayList<Notification> receivedNotifications;
	private ArrayList<Item> items;
	private String message; 
	private String accountNumber; 
	private Notification notification; 
	private boolean isManager; 
	private ArrayList<String> employeeNames;



	public WorkPage() {
		orders = new ArrayList<Order>();
		caccount = new CustomerAccount();
		eaccount =new EmployeeAccount();
		sourceNotifications = new ArrayList<Notification>();
		receivedNotifications = new ArrayList<Notification>();
		notification = new Notification();
		employeeNames = new ArrayList<String>();
		items = new ArrayList<Item>();
	}
	
	public ArrayList<Notification> getSourceNotifications() {
		return sourceNotifications;
	}
	public void setSourceNotifications(ArrayList<Notification> sourceNotifications) {
		this.sourceNotifications = sourceNotifications;
	}
	
	public EmployeeAccount getEmployeeAccount() {
		return eaccount;
	}
	public void setEmployeeAccount(EmployeeAccount eaccount) {
		this.eaccount= eaccount;
	}
	public CustomerAccount getCustomerAccount() {
		return caccount;
	}
	public void setCustomerAccount(CustomerAccount caccount) {
		this.caccount= caccount;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<Notification> getReceivedNotifications() {
		return receivedNotifications;
	}

	public void setReceivedNotifications(ArrayList<Notification> receivedNotifications) {
		this.receivedNotifications = receivedNotifications;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}

	public boolean isManager() {
		return isManager;
	}

	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}

	public ArrayList<String> getEmployeeNames() {
		return employeeNames;
	}

	public void setEmployeeNames(ArrayList<String> employeeNames) {
		this.employeeNames = employeeNames;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	
	
}
