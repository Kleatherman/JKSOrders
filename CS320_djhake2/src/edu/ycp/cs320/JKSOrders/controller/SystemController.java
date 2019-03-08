package edu.ycp.cs320.JKSOrders.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

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
		notifications = new ArrayList<Notification>();
		inventory = new Inventory();
		catalog = new Catalog();
		
		initializeLoginArrayList(login);
		initilizeCatalogInventory(catalog, inventory);
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
		if(notify.getUrgency()) {
			System.out.println("Urgent Message!");
		}
	}

	public void updateCatalogItem(Item item) {
		catalog.setItem(item);		
	}

	public void createAccount() {
		
	}
	
	public void setVisability(int i) {
		ArrayList<String> less = new ArrayList<String>();
		ArrayList<String> more = new ArrayList<String>();
		inventory.returnGreaterorLess(i, more, less);
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
	
	private void initilizeCatalogInventory(Catalog catalog, Inventory inventory) {
		String[] itemNames = {"Tomatoes", "Apples", "Oranges", "Pecans", "Pumkins"};
		
		for(int i = 0; i<itemNames.length; i++) {
			Item item = new Item();
			item.setItemName(itemNames[i]);
			item.setUPC(itemNames[i]+i);
			item.setPrice(11.1*i);
			item.setDescription(itemNames[i]+" are one of many delicious options we offer. They are only $"+item.getPrice()+".");
			item.setLocation("A"+i+"B"+(5-1));
			catalog.setItemKey(item);
			inventory.setItemQuantity(item.getUPC(), i);
		}
		
		this.setVisability(3);
	}
}
