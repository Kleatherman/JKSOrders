package edu.ycp.cs320.JKSOrders.controller;

import java.util.ArrayList;
import java.util.Iterator;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.database.Database;


public class SystemController {
	private ArrayList<LoginInfo> employeeLogin;
	private ArrayList<LoginInfo> customerLogin;
	private ArrayList<Account> employeeAccounts;
	private ArrayList<Account> customerAccounts;
	private Catalog catalog;
	private ArrayList<Notification> notifications;
	
	public SystemController() {
		employeeLogin = new ArrayList<LoginInfo>();
		customerLogin = new ArrayList<LoginInfo>();
		notifications = new ArrayList<Notification>();
		catalog = new Catalog();
		employeeAccounts = new ArrayList<Account>();
		customerAccounts = new ArrayList<Account>();
	}
	
	/**
	 * @param loginTest
	 * @param logins
	 * @return
	 */
	public boolean verifyEmployeeLoginInfo(LoginInfo loginTest, ArrayList<LoginInfo> logins) {
		Iterator<LoginInfo> i = logins.iterator();
		while(i.hasNext()) {
			if(i.next().equals(loginTest)) {
				return true;
			}
		}
		return false;
	}
	

	
	/**
	 * @param loginTest
	 * @return
	 */
	public boolean verifyCustomerLoginInfo(LoginInfo loginTest, ArrayList<LoginInfo> logins) {
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

	public boolean isEmployee(String accountNumber) {
		accountNumber.toLowerCase();
		char[] number = accountNumber.toCharArray();
		if(number[0]=='e') {
			return true;
		}
		return false;
	}
	
	public boolean isInventoryOrder(String orderNumber) {
		orderNumber.toLowerCase();
		char[] number = orderNumber.toCharArray();
		if(number[0]=='i') {
			return true;
		}
		return false;
	}
	
	public boolean isManagerOrder(String accountNumber) {
		accountNumber.toLowerCase();
		char[] number = accountNumber.toCharArray();
		if(number[0]=='m') {
			return true;
		}
		return false;
	}
	
	public boolean isUrgentNotification(String notificationNumber) {
		notificationNumber.toLowerCase();
		char[] number = notificationNumber.toCharArray();
		if(number[0]=='u') {
			return true;
		}
		return false;
	}
	
	public String generateNextOrderNumber(Database db, char firstCharacter) {
		String lastOrderNumber = (String) db.getLastPickUpOrderNumber();
		if(lastOrderNumber != null) {
			System.out.println(lastOrderNumber.substring(1));
			Integer lastDigit = Integer.parseInt(lastOrderNumber.substring(1, lastOrderNumber.length()));
			lastDigit++;
			return firstCharacter+lastDigit.toString();
		}
		return "P0";
	}

}
