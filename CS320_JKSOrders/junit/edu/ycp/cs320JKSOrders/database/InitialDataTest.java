package edu.ycp.cs320JKSOrders.database;


import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.database.InitialData;

public class InitialDataTest {
	InitialData data= new InitialData();
	List<EmployeeAccount> eaccount;
	List<CustomerAccount> caccount;
	List<Car> car;
	List<LoginInfo>login;
	List<Order>order;
	List<Notification>note;
	Catalog catalog;
	
	
	@Before
	public void setUp() {
		try {
			catalog= new Catalog();
			car = InitialData.getInitialCars() ;
			eaccount= InitialData.getInitialEmployeeAccounts();
			caccount= InitialData.getInitialCustomerAccounts();
			login=InitialData.getInitialLoginInfo();
			order= InitialData.getInitialOrders();
			note=InitialData.getInitialNotifications();
			InitialData.getInitialCatalog(catalog);
			} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCar() {
		System.out.println(car.get(0).getBrand());
		if(car.get(0).getBrand().equals("Ford")) {
			assert true;
		}
	}
	
	@Test
	public void testEmployee() {
		System.out.println(eaccount.get(0).getFirstName());
		if(eaccount.get(0).getFirstName().equals("Samuel")) {
			assert true;
		}
	}
	
	@Test
	public void testCustomer() {
		System.out.println(caccount.get(0).getFirstName());
		if(caccount.get(0).getFirstName().equals("Samuel")) {
			assert true;
		}
	}
	
	@Test
	public void testLogin() {
		System.out.println(login.get(0).getUserName());
		if(eaccount.get(0).getFirstName().equals("scesario")) {
			assert true;
		}
	}
	@Test
	public void testOrder() {
		
		
		System.out.println(order.get(0).getOrderType());
		System.out.println(order.get(0).getQuantityMap().get("I0"));
		System.out.println(order.get(0).getItemlist().get(0).getUPC());
		if(order.get(0).getOrderType().equals("P0") && order.get(0).getItemlist().get(0).getUPC().equals("I0")) {
			assert true;
		}
		else {
			assert false;
		}
	}
	@Test
	public void testNotification() {
		System.out.println(note.get(0).getNotificationID());
		if(note.get(0).getNotificationID().equals("U0")) {
			assert true;
		}
	}
	
	@Test
	public void testCatalog() {
		System.out.println(catalog.getItem("I0").getUPC());
		if(catalog.getItem("I0").getUPC().equals("I0")) {
			assert true;
		}
	}
	


	
	
}
