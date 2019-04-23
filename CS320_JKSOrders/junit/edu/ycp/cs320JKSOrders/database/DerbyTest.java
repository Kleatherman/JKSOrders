package edu.ycp.cs320JKSOrders.database;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDerbyDatabase;

public class DerbyTest {
	Database db;
	ArrayList<EmployeeAccount> Elist;
	ArrayList<CustomerAccount> Clist;
	ArrayList<LoginInfo> Llist;
	ArrayList<Notification> Nlist;
	ArrayList<Item> Ilist;
	
	@Before
	public void setUp() {
		db = new InitDerbyDatabase().init();
		
	}
	@Test 
	public void testGetEmployeeAccounts() {
		Elist= db.getEmployeeAccounts();
		assertTrue(Elist.size()==3);
		assertTrue( Elist.get(0).getAccountNumber().equals("M0"));
	}
	@Test 
	public void testGetCustomersAccounts() {
		Clist= db.getCustomerAccounts();
		assertTrue(Clist.size()==3);
		assertTrue(Clist.get(0).getAccountNumber().equals("C0"));
	}
	@Test
	public void testGetCustomerLogin() {
		Llist= db.getCustomerLoginInfo();
		assertTrue(Llist.size()==3);
		assertTrue( Llist.get(0).getPassword().equals("password"));
	}
	@Test
	public void testGetEmployeeLogin() {
		Llist= db.getEmployeeLoginInfo();
		assertTrue(Llist.size()==3);
		assertTrue( Llist.get(0).getPassword().equals("password"));
	}
	
	@Test
	public void testGetVisibleItems() {
		Ilist = db.getVisibleItems();
		assertTrue(Ilist.size()==2);
		for(Item item : Ilist) {
			assertTrue(item.isVisable());
		}
	}
	
	@Test
	public void testGetNotificationTest() {
		Nlist = db.getNotifications();
		assertTrue(Nlist.size()==4);
		assertTrue(Nlist.get(0).getMessage().equals("HELLO World"));
		assertTrue(Nlist.get(0).getDestination().size()==3);
	}
	
	@Test
	public void testGetCatalog() {
		ArrayList<String> greater = new ArrayList<String>();
		ArrayList<String> less = new ArrayList<String>();
		Catalog catalog = db.getCatalog();
		assertTrue(!catalog.getItemMap().isEmpty());
		assertTrue(catalog.getItemMap().get("I0").getNumInInventory()==5);
		assertTrue(catalog.getItemMap().get("I1").getNumInInventory()==7);
		catalog.returnGreaterorLess(6, greater, less);
		assertTrue(greater.get(0).equals("I1"));
		assertTrue(less.get(0).equals("I0"));
	}
	
	@Test
	public void testGetNotifications() {
		ArrayList<Notification> notifications = db.getNotifications("M0");
		System.out.println(notifications.size());
		assertTrue(notifications.size()==1);
		assertTrue(notifications.get(0).getSourceAccountNumber().equals("M2"));
		notifications = db.getNotifications("M2");
		assertTrue(notifications.size()==2);
		assertTrue(notifications.get(0).getSourceAccountNumber().equals("M2"));
		assertTrue(notifications.get(1).getNotificationID().equals("U1"));
	}
	
	@Test
	public void testGetNotification() {
		Notification notify = db.getNotification("N0");
		assertTrue(notify.getDestination().size()==3);
		assertTrue(notify.getMessage().equals("HELLO world"));
		notify = db.getNotification("U0");
		assertTrue(notify.getDestination().size()==1);
		assertTrue(notify.getSourceAccountNumber().equals("M0"));
	}
}
