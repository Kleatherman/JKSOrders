package edu.ycp.cs320.JKSOrders.controller;

import java.util.ArrayList;
import java.util.Iterator;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.Inventory;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;


public class SystemController {
	private ArrayList<LoginInfo> login;
	private ArrayList<Account> accounts;
	private Inventory inventory;
	private Catalog catalog;
	private ArrayList<Notification> notifications;
	
	public SystemController() {
		login = new ArrayList<LoginInfo>();
		initializeLoginArrayList(login);
		notifications = new ArrayList<Notification>();
	}
	
	public boolean verifyLoginInfo(LoginInfo loginTest) {
		System.out.println("Test login: "+loginTest.getPassword()+" "+loginTest.getUserName());
		Iterator<LoginInfo> i = login.iterator();
		while(i.hasNext()) {
			if(i.next().equals(loginTest)) {
				return true;
			}
		}
		return false;
	}
	
	public void createNotification(Notification notify) {
		notifications.add(notify);

		System.out.println(notify.getMessage());
	}

	public void updateCatalogItem(Item item) {
		catalog.setItem(item);		
	}

	private void initializeLoginArrayList(ArrayList<LoginInfo> logins) {
		LoginInfo login;
		for(int i = 0; i<10; i++) {
			login = new LoginInfo();
			login.setPassword("password"+i);
			login.setUserName("user"+i);
			logins.add(login);
			System.out.println("System Login #"+i+": Password = "+login.getPassword()+", UserName = "+login.getUserName());
		}
	}

	//private void initializeAccountArrayList(ArrayList<Account> accounts) {
		
	//}
}
