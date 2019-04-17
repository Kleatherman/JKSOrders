package edu.ycp.cs320.JKSOrders.database;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.classes.Order;


public class InitialData {

	// There are tests for these methods although they aren't very comprehensive yet
	// Most of these methods return a list with the exception of the Catalog method
	
	public static List<CustomerAccount> getInitialCustomerAccounts() throws IOException {
		List<CustomerAccount> accountList = new ArrayList<CustomerAccount>();
		ReadCSV readAccounts = new ReadCSV("customers.csv");
		try {
			
			while (true) {
				List<String> tuple = readAccounts.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				CustomerAccount customeraccount = new CustomerAccount();
			
				
				customeraccount.setAccountNumber(i.next());			
				customeraccount.setFirstName(i.next());
				customeraccount.setLastName(i.next());
				customeraccount.setEmail(i.next());
				customeraccount.setPhoneNumber(i.next());
				customeraccount.getCreditCard().setAccountNumber(i.next());;
				accountList.add(customeraccount);
			}

			System.out.println("Customer List loaded from CSV file");
			return accountList;
		}finally {
			readAccounts.close();
		}
		
	}
	public static List<EmployeeAccount> getInitialEmployeeAccounts() throws IOException {
		List<EmployeeAccount> accountList = new ArrayList<EmployeeAccount>();
		ReadCSV readAccounts = new ReadCSV("employees.csv");
		try {
			
			while (true) {
				List<String> tuple = readAccounts.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				EmployeeAccount employeeaccount = new EmployeeAccount();

				
				employeeaccount.setAccountNumber(i.next());;				
				employeeaccount.setFirstName(i.next());
				employeeaccount.setLastName(i.next());
				employeeaccount.setEmail(i.next());
				employeeaccount.setPhoneNumber(i.next());;
				
				accountList.add(employeeaccount);
			}
			System.out.println("Employee List loaded from CSV file");
			return accountList;
		} finally {
			readAccounts.close();
		}
	}
	public static List<Car> getInitialCars() throws IOException {
		List<Car> carList = new ArrayList<Car>();
		ReadCSV readCars = new ReadCSV("Cars.csv");
		try {
			
			while (true) {
				List<String> tuple = readCars.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Car car= new Car();
		
				
				car.setOwner(i.next());
				car.setColor(i.next());
				car.setBrand(i.next());
				car.setType(i.next());
				car.setYear(Integer.parseInt(i.next()));
				carList.add(car);
			}
			System.out.println("Car List loaded from CSV file");
			return carList;
		} finally {
			readCars.close();
		}
	}
	
	public static List<LoginInfo> getInitialLoginInfo() throws IOException {
		List<LoginInfo> infoList = new ArrayList<LoginInfo>();
		ReadCSV readInfo = new ReadCSV("LoginInfo.csv");
		try {
			
			while (true) {
				List<String> tuple = readInfo.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				LoginInfo login= new LoginInfo();
				login.setOwnerAccount(i.next());
				login.setUserName(i.next());
				login.setPassword(i.next());
				infoList.add(login);
			}
			System.out.println("Login Info loaded from CSV file");
			return infoList;
		} finally {
			readInfo.close();
		}
	}
	
	//Since order has a quantity map in it this will also call the Junction CSV
	
	public static List<Order> getInitialOrders() throws IOException {
		List<Order> orderList = new ArrayList<Order>();
		ReadCSV readOrders = new ReadCSV("Orders.csv");
		ReadCSV readJunc= new ReadCSV("OrderItemJunction.csv");
		try {
			
			while (true) {
				List<String> tuple = readOrders.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Order order = new Order();
				order.setOrderType(i.next());
				order.setAccountNum(i.next());
				
				orderList.add(order);
			}
			while(true) {
				List<String> tuple = readJunc.next();
				if(tuple== null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String orderid=i.next();
				for(int j=0; j<orderList.size(); j++) {
					if(orderList.get(j).getOrderType()== orderid) {
							orderList.get(j).getQuantityMap().put(i.next(),  Integer.parseInt(i.next())); 
					}
				}
				
			}
			System.out.println("Order List loaded from CSV file");
			return orderList;
		} finally {
			readOrders.close();
		}
	}
	
	//this was done as a controller method 
	
	public static void getInitialCatalog(Catalog catalog) throws IOException {
		List<Item> itemList = new ArrayList<Item>();
		ReadCSV readItems = new ReadCSV("Catalog.csv");
		try {
			
			while (true) {
				List<String> tuple = readItems.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Item item = new Item();
				item.setUPC(i.next());
				item.setItemName(i.next());
				item.setPrice(Integer.parseInt(i.next()));
				item.setLocation(i.next());
				item.setNumInInventory(Integer.parseInt(i.next()));
				
				
				catalog.setItem(item);
				
				itemList.add(item);
			}
			System.out.println("Catalog and Inventory loaded from CSV file");
		} finally {
			readItems.close();
		}
	}
	
	//Since notification has a list of recipients build in notificationrecipients.csv is included
	
	public static List<Notification> getInitialNotifications() throws IOException {
		List<Notification> pokeList = new ArrayList<Notification>();
		ReadCSV readPokes = new ReadCSV("Notifications.csv");
		ReadCSV readPokees = new ReadCSV("NotificationRecipients.csv");
		try {
			
			while (true) {
				List<String> tuple = readPokes.next();
				if (tuple == null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				Notification poke= new Notification();
				
				poke.setNotificationID(i.next());
				poke.setSourceAccountNumber(i.next());
				poke.setMessage(i.next());
				
				pokeList.add(poke);
			}
			
			while(true) {
				List<String> tuple = readPokees.next();
				if(tuple== null) {
					break;
				}
				Iterator<String> i = tuple.iterator();
				String id=i.next();
				for(int j=0; j<pokeList.size(); j++) {
					if(pokeList.get(j).getNotificationID()==id) {
						while(i.hasNext()) {
							pokeList.get(j).addDestinationName(i.next()); 
						}
					}
				}
				
			}
			System.out.println("Notifications loaded from CSV file");
			return pokeList;
		} finally {
			readPokes.close();
			readPokees.close();
		}
	}
	
	
	
	
	
	
}