package edu.ycp.cs320JKSOrders.database;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDerbyDatabase;

public class DerbyInitialDataTest {
	Database db;
	ArrayList<EmployeeAccount> InitE;
	ArrayList<CustomerAccount> InitC;
	ArrayList<LoginInfo> InitLC;
	ArrayList<LoginInfo> InitLE;
	ArrayList<Notification> InitN;
	ArrayList<Item> InitI;
	ArrayList<Car> InitV;
	ArrayList<Order> InitO;
	
	@Before
	public void setUp() {
		db = new InitDerbyDatabase().init();
		InitC= db.getCustomerAccounts();
		InitE= db.getEmployeeAccounts();
		InitI= db.getVisibleItems();
		InitN= db.getNotifications();
		InitV= db.getCars();
		InitO= db.getOrders();
		InitLC= db.getCustomerLoginInfo();
		InitLE= db.getEmployeeLoginInfo();
	}
	
	@Test 
	public void testGetEmployeeAccounts() {
		assertTrue(InitE.size()==3);
		assertTrue( InitE.get(0).getAccountNumber().equals("M0"));
	}
	@Test 
	public void testGetCustomersAccounts() {
		assertTrue(InitC.size()==3);
		assertTrue(InitC.get(0).getAccountNumber().equals("C0"));
		assertTrue(InitC.get(0).getPickUpInfo().getCar().getOwner()!= null);
	}
	@Test
	public void testGetCustomerLogin() {
		assertTrue(InitLC.size()==3);
		assertTrue( InitLC.get(0).getPassword().equals("password"));
		assertTrue( InitLC.get(0).getUserName().equals("email1@gmail.com"));
	}
	@Test
	public void testGetEmployeeLogin() {
		assertTrue(InitLE.size()==3);
		assertTrue( InitLE.get(0).getPassword().equals("password"));
		assertTrue(InitLE.get(0).getOwnerAccount().equals("M0"));
	}
	@Test
	public void testGetNotificationTest() {
		assertTrue(InitN.size()==4);
		assertTrue(InitN.get(0).getMessage().equals("HELLO World"));
		assertTrue(InitN.get(0).getDestination().size()==3);
	}
	@Test
	public void testGetOrders() {
		assertTrue(InitO.size()==2);
		assertTrue(InitO.get(0).getAccountNum().equals("C0"));
		assertTrue(InitO.get(0).getItemlist().get(0).getUPC().equals("IO"));
		assertTrue(InitO.get(1).getItemlist().get(0).getUPC().equals("IO"));
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
		assertTrue(notifications.size()==1);
		assertTrue(notifications.get(0).getSourceAccountNumber().equals("M2"));
		notifications = db.getNotifications("M2");
		assertTrue(notifications.size()==2);
		assertTrue(notifications.get(0).getSourceAccountNumber().equals("M2"));
		assertTrue(notifications.get(1).getNotificationID().equals("U1"));
	}

	@Test
	public void testGetEmployeeAccountFromName() {
		EmployeeAccount eaccount= db.getEmployeeAccount("M0");
		assertTrue(InitE.get(0).getAccountNumber().equals(eaccount.getAccountNumber()));
		eaccount = db.getEmployeeAccount("Samuel");
		assertTrue(InitE.get(0).getAccountNumber().equals(eaccount.getAccountNumber()));
		eaccount= db.getEmployeeAccount("kleatherman");
		assertTrue(InitE.get(1).getAccountNumber().equals(eaccount.getAccountNumber()));
		
	}
	@Test
	public void testGetCustomerAccountFromName() {
		CustomerAccount eaccount= db.getCustomerAccount("C0");
		assertTrue(InitC.get(0).getAccountNumber().equals(eaccount.getAccountNumber()));
		eaccount = db.getCustomerAccount("Samuel");
		assertTrue(InitC.get(0).getAccountNumber().equals(eaccount.getAccountNumber()));
		eaccount= db.getCustomerAccount("kleatherman");
		assertTrue(InitC.get(1).getAccountNumber().equals(eaccount.getAccountNumber()));
	}
	@Test
	public void testGetAccount() {
		Account account= db.getAccount("C0");
		assertTrue(InitC.get(0).getAccountNumber().equals(account.getAccountNumber()));
		account = db.getAccount("M0");
		assertTrue(InitE.get(0).getAccountNumber().equals(account.getAccountNumber()));
		account= db.getAccount("C2");
		assertTrue(InitC.get(2).getAccountNumber().equals(account.getAccountNumber()));
	}
	@Test
	public void testGetAllEmployeeName() {
		ArrayList<String> names= db.AllEmployeeNames();
		assertTrue(names.get(0).equals("Samuel Cesario"));
		assertTrue(names.get(1).equals("Kyle Leatherman"));
		assertTrue(names.get(2).equals("Josiah Sam"));
	}
	

	
	@Test
	public void testGetNotification() {
		Notification notify = db.getNotification("N0");
		assertTrue(notify.getDestination().size()==3);
		assertTrue(notify.getMessage().equals("HELLO World"));
		notify = db.getNotification("U0");
		assertTrue(notify.getDestination().size()==1);
		assertTrue(notify.getDestination().get(0).equals("M1"));
		assertTrue(notify.getSourceAccountNumber().equals("M0"));
		
	}
	
	@Test
	public void testGetSourceNotifications() {
		ArrayList<Notification> notifications = db.getSourceNotifications("M0");
		assertTrue(notifications.size()==1);
		assertTrue(notifications.get(0).getDestination().size()==1);
		assertTrue(notifications.get(0).getNotificationID().equals("U0"));
		notifications = db.getSourceNotifications("M2");
		assertTrue(notifications.size()==2);
		assertTrue(notifications.get(0).getNotificationID().equals("N0"));
		assertTrue(notifications.get(1).getNotificationID().equals("U2"));
	}
	
	@Test
	public void testGetPasswordForEmployeeAccount() {
		Account account = db.getEmployeeAccounts().get(0);
		assertTrue(account.getLogin().getPassword().equals(db.getPasswordForEmployeeAccount(account)));
		account = db.getEmployeeAccounts().get(1);
		assertTrue(account.getLogin().getPassword().equals(db.getPasswordForEmployeeAccount(account)));
		account = db.getEmployeeAccounts().get(db.getEmployeeAccounts().size()-1);
		assertTrue(account.getLogin().getPassword().equals(db.getPasswordForEmployeeAccount(account)));
	}
	
	@Test
	public void testGetPasswordForCustomerAccount() {
		Account account = db.getCustomerAccounts().get(0);
		assertTrue(account.getLogin().getPassword().equals(db.getPasswordForCustomerAccount(account)));
		account = db.getCustomerAccounts().get(1);
		assertTrue(account.getLogin().getPassword().equals(db.getPasswordForCustomerAccount(account)));
		account = db.getCustomerAccounts().get(db.getCustomerAccounts().size()-1);
		assertTrue(account.getLogin().getPassword().equals(db.getPasswordForCustomerAccount(account)));
	}
	
	@Test
	public void testGetLastCustomerAccountNumber() {
		String lastAccountNum = db.getLastCustomerAccountNumber();
		assertTrue(lastAccountNum.equals(db.getCustomerAccounts().get(db.getCustomerAccounts().size()-1).getAccountNumber()));
	}
	
	@Test
	public void testGetLastEmployeeAccountNumber() {
		String lastAccountNum = db.getLastEmployeeAccountNumber();
		assertTrue(lastAccountNum.equals(db.getEmployeeAccounts().get(db.getEmployeeAccounts().size()-1).getAccountNumber()));
	}
	@Test
	public void testGetVisibleItems() {
		db.setVisibility(0);
		InitI= db.getVisibleItems();
		assertTrue(InitI.size()==2);
		for(Item item : InitI) {
			assertTrue(item.isVisable());
		}
	}
}
