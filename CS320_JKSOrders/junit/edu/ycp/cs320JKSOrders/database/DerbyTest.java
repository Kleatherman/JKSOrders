package edu.ycp.cs320JKSOrders.database;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.CreditCard;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.classes.PickUpInfo;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDerbyDatabase;

public class DerbyTest {
	Database db;
	ArrayList<EmployeeAccount> Elist;
	ArrayList<CustomerAccount> Clist;
	ArrayList<LoginInfo> LClist;
	ArrayList<LoginInfo> LElist;
	ArrayList<Notification> Nlist;
	ArrayList<Item> Ilist;
	ArrayList<Car> Cars;
	ArrayList<Order> Olist;
	
	ArrayList<EmployeeAccount> InitE;
	ArrayList<CustomerAccount> InitC;
	ArrayList<LoginInfo> InitLC;
	ArrayList<LoginInfo> InitLE;
	ArrayList<Notification> InitN;
	ArrayList<Item> InitI;
	ArrayList<Car> InitV;
	ArrayList<Order> InitO;
	
	// The init lists are made to represent the initial tables-- do not use add delete or edit methods on them 
	@Before
	public void setUp() {
		db = new InitDerbyDatabase().init();
		Clist= db.getCustomerAccounts();
		InitC= db.getCustomerAccounts();
		Elist= db.getEmployeeAccounts();
		InitE= db.getEmployeeAccounts();
		Ilist = db.getVisibleItems();
		Nlist = db.getNotifications();
    InitI= db.getVisibleItems();
		Nlist = new ArrayList<Notification>();
		InitN= db.getNotifications();
		System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj"+ InitN.size());
		Cars = db.getCars();
		InitV= db.getCars();
		Olist= db.getOrders();
		InitO= db.getOrders();
		LClist= db.getCustomerLoginInfo();
		InitLC= db.getCustomerLoginInfo();
		LElist= db.getEmployeeLoginInfo();
		InitLE= db.getEmployeeLoginInfo();
	}
	
	@Test 
	public void testGetEmployeeAccounts() {
		assertTrue(Elist.size()==3);
		assertTrue( Elist.get(0).getAccountNumber().equals("M0"));
	}
	@Test 
	public void testGetCustomersAccounts() {
		assertTrue(Clist.size()==4);
		assertTrue(Clist.get(0).getAccountNumber().equals("C0"));
		// need fix assertTrue(Clist.get(0).getPickUpInfo().getCar().getOwner()!= null);
	}
	@Test
	public void testGetCustomerLogin() {
		Llist= db.getCustomerLoginInfo();
		assertTrue(Llist.size()==4);
		assertTrue( Llist.get(0).getPassword().equals("password"));
	}
	@Test
	public void testGetEmployeeLogin() {
		Llist= db.getEmployeeLoginInfo();
		assertTrue(Llist.size()==3);
		assertTrue( Llist.get(0).getPassword().equals("password"));
		assertTrue(Llist.get(0).getOwnerAccount().equals("M0"));
	}
	
	@Test
	public void testGetVisibleItems() {
		db.setVisibility(0);
		Ilist= db.getVisibleItems();
		assertTrue(Ilist.size()==2);
		for(Item item : Ilist) {
			assertTrue(item.isVisable());
		}
	}
	
	@Test
	public void testGetNotificationTest() {
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
		assertTrue(Elist.get(0).getAccountNumber().equals(eaccount.getAccountNumber()));
		eaccount = db.getEmployeeAccount("Samuel");
		assertTrue(Elist.get(0).getAccountNumber().equals(eaccount.getAccountNumber()));
		eaccount= db.getEmployeeAccount("kleatherman");
		assertTrue(Elist.get(1).getAccountNumber().equals(eaccount.getAccountNumber()));
		
	}
	@Test
	public void testGetCustomerAccountFromName() {
		CustomerAccount eaccount= db.getCustomerAccount("C0");
		assertTrue(Clist.get(0).getAccountNumber().equals(eaccount.getAccountNumber()));
		eaccount = db.getCustomerAccount("Samuel");
		assertTrue(Clist.get(0).getAccountNumber().equals(eaccount.getAccountNumber()));
		eaccount= db.getCustomerAccount("kleatherman");
		assertTrue(Clist.get(1).getAccountNumber().equals(eaccount.getAccountNumber()));
	}
	@Test
	public void testGetAccount() {
		Account account= db.getAccount("C0");
		assertTrue(Clist.get(0).getAccountNumber().equals(account.getAccountNumber()));
		account = db.getAccount("M0");
		assertTrue(Elist.get(0).getAccountNumber().equals(account.getAccountNumber()));
		account= db.getAccount("C2");
		assertTrue(Clist.get(3).getAccountNumber().equals(account.getAccountNumber()));
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
	public void testSetVisible() {
		db.setVisibility(0);
		Ilist = db.getVisibleItems();
		assertTrue(InitI.size()==2);
		db.setVisibility(99);
		Ilist = db.getVisibleItems();
		assertTrue(Ilist.size()==0);
		db.setVisibility(6);
		Ilist= db.getVisibleItems();
		assertTrue(Ilist.size()==1);
	}
	@Test
	public void testAddNotification() {
		Nlist = db.getNotifications();
		int count= Nlist.size();
		Notification notify = new Notification();
		ArrayList<String> dest = new ArrayList<String>();
		dest.add("M0");
		dest.add("M2");
		notify.setDestination(dest);
		notify.setMessage("I'm dummy thicc");
		notify.setUrgency(true);
		notify.setSourceAccountNumber("M1");
		notify.setNotificationID(null);
		db.addNotification(notify);
		Nlist= db.getNotifications();
		assertTrue(Nlist.size()==count+1);
		assertTrue(Nlist.get(0).getMessage().equals("HELLO World"));
		assertTrue(Nlist.get(4).getMessage().equals("I'm dummy thicc"));
		assertTrue(Nlist.get(4).getUrgency().equals(true));
		assertTrue(Nlist.get(4).getSourceAccountNumber().equals("M1"));
		assertTrue(Nlist.get(4).getDestination().get(0).equals("M0"));
		assertTrue(Nlist.get(4).getNotificationID()!=null);
		db.deleteNotification(Nlist.get(4).getNotificationID()); 
	}
	@Test
	public void testAddEmployeeAccount() {
		int count = Elist.size();
		LoginInfo login = new LoginInfo();
		login.setPassword("password");
		login.setUserName("BOB");
		EmployeeAccount eaccount = new EmployeeAccount();
		eaccount.setEmail("Yadda@gmail.com");
		eaccount.setFirstName("Bob");
		eaccount.setLastName("McJoe");
		eaccount.setPhoneNumber("7175559848");
		eaccount.setManager(false);
		eaccount.setLogin(login);
		db.addEmployeeAccount(eaccount);
		Elist= db.getEmployeeAccounts();
		assertTrue(Elist.size()==count+1);
		assertTrue(Elist.get(0).getAccountNumber().equals("M0"));
		assertTrue(Elist.get(3).getAccountNumber()!=null);
		System.out.println("\\n\\n\\n\\n\\n\\n\\n"+ Elist.get(3).getFirstName());
		assertTrue(Elist.get(2).getFirstName().equals("Bob"));
		assertTrue(Elist.get(2).getLastName().equals("McJoe"));
		assertTrue(Elist.get(2).getEmail().equals("Yadda@gmail.com"));
		assertTrue(Elist.get(2).getPhoneNumber().equals("7175559848"));
		assertTrue(Elist.get(2).getLogin().getOwnerAccount()!= null);
		assertTrue(Elist.get(2).getLogin().getPassword().equals("password"));
	}
	@Test
	public void testAddCustomerAccount() {
		int count = Clist.size();
		CreditCard card= new CreditCard();
		card.setNameOnCard("Bob");
		card.setCVC("563");
		card.setExpirationDate("5/24");
		Car car= new Car();
		car.setBrand("Ford");
		car.setColor("Red");
		car.setType("Focus");
		car.setYear(1);
		PickUpInfo PUI= new PickUpInfo();
		PUI.setCar(car);
		LoginInfo login = new LoginInfo();
		login.setPassword("password");
		login.setUserName("BOB");
		CustomerAccount eaccount = new CustomerAccount();
		eaccount.setEmail("Yadda@gmail.com");
		eaccount.setFirstName("Bob");
		eaccount.setLastName("McJoe");
		eaccount.setPhoneNumber("7175559848");
		eaccount.setPickUpInfo(PUI);
		eaccount.setCreditCard(card);
		eaccount.setLogin(login);
		db.addCustomerAccount(eaccount);
		Clist= db.getCustomerAccounts();
		assertTrue(Clist.size()==count+1);
		assertTrue(Clist.get(0).getAccountNumber().equals("C0"));
		assertTrue(Clist.get(2).getAccountNumber()!=null);
		assertTrue(Clist.get(2).getFirstName().equals("Bob"));
		assertTrue(Clist.get(2).getLastName().equals("McJoe"));
		assertTrue(Clist.get(2).getEmail().equals("Yadda@gmail.com"));
		assertTrue(Clist.get(2).getPhoneNumber().equals("7175559848"));
		assertTrue(Clist.get(2).getLogin().getOwnerAccount()!= null);
		assertTrue(Clist.get(2).getLogin().getPassword().equals("password"));
		// NEEDS FIX assertTrue(Clist.get(0).getPickUpInfo().getCar().getOwner()!= null);
		//assertTrue(Clist.get(2).getCreditCard().getAccountNumber()!=null);
		//assertTrue(Clist.get(2).getCreditCard().getNameOnCard().equals("Bob"));
		// NEEDS FIX assertTrue(Clist.get(2).getPickUpInfo().getCar().getOwner()!= null);
		// NEEDS FIX assertTrue(Clist.get(2).getPickUpInfo().getCar().getBrand().equals("Ford"));

		
	}
	
	@Test
	public void testDeleteNotifications() {
		assertTrue(Clist.size()==4);
		Nlist= db.getNotifications();
		int count = Nlist.size();
		db.deleteNotification("U0");
		Nlist= db.getNotifications();
		assertTrue(Nlist.size()==count-1);
		assertTrue(Nlist.get(0).getNotificationID().equals("N0"));
		assertTrue(Nlist.get(0).getMessage().equals("HELLO World"));
		assertTrue(Nlist.get(1).getNotificationID().equals("U1"));
		assertTrue(Nlist.get(1).getMessage().equals("HELLO World"));
		assertTrue(Nlist.get(2).getNotificationID().equals("U2"));
		assertTrue(Nlist.get(2).getMessage().equals("HELLO World"));
		assertTrue(Nlist.get(3).getNotificationID().equals("U3"));
		assertTrue(Nlist.get(3).getMessage().equals("I'm dummy thicc"));
	}
	
	
	
	@Test
	public void testDeleteOrders() {
		Olist= db.getOrders();
		int count = Olist.size();
		db.deleteOrder(db.getOrder("P0"));
		Olist= db.getOrders();
		assertTrue(Olist.size()==count-1);
		assertTrue(db.getOrder("P0")==null);
		assertTrue(db.getOrder("S0").getItemlist().size()==2);
		assertTrue(db.getOrder("S0").getItemlist().get(0).getUPC().equals("I0"));
		assertTrue(db.getOrder("S0").getItemlist().get(1).getUPC().equals("I1"));
	}
	/*
	@Test
	public void testDeleteAccount() {
		Elist= db.getEmployeeAccounts();
		Clist= db.getCustomerAccounts();
		int Ecount = Elist.size();
		int Ccount = Clist.size();
		db.deleteAccount("C0");
		Elist= db.getEmployeeAccounts();
		Clist= db.getCustomerAccounts();
		assertTrue(Clist.size()==Ccount-1);
		assertTrue(Elist.size()==Ecount);
		assertTrue(!Clist.get(0).getAccountNumber().equals("C0"));
		db.deleteAccount("M0");
		Elist= db.getEmployeeAccounts();
		Clist= db.getCustomerAccounts();
		assertTrue(Elist.size()==Ecount-1);
		assertTrue(Clist.size()==Ccount-1);
		assertTrue(!Elist.get(0).getAccountNumber().equals("M0"));
	
	}
*/
	@Test
	public void testAddOrders() {
		TreeMap<String, Integer> Map= new TreeMap<String,Integer>();
		ArrayList<Item> itemlist= new ArrayList<Item>();
		int itemcount= db.getVisibleItems().get(0).getNumInInventory();
		itemlist.add(db.getVisibleItems().get(0));
		Map.put(itemlist.get(0).getUPC(), 5);
		Order order = new Order();
		order.setAccountNum("C2");
		order.setItemlist(itemlist);
		order.setQuantityMap(Map);
		order.setItemQuantities();
		order.setOrderType("P12");
		order.setTotalPrice();
		Olist= db.getOrders();
		int count = Olist.size();
		db.addOrder(order);
		Olist= db.getOrders();
		assertTrue(Olist.size()==count+1);
		assertTrue(db.getOrder("P12").getItemlist().get(0).getUPC().equals("I0"));
		assertTrue(db.getVisibleItems().get(0).getNumInInventory()==itemcount-5);
		assertTrue(db.getOrder("P12").getItemlist().get(0).getNumInOrder()==5);
		assertTrue(db.getOrder("P12").getTotalPrice()!=0);
	}
	@Test
	public void testAddItems() {
		db.setVisibility(0);
		Ilist= db.getVisibleItems();
		int count = Ilist.size();
		Item item= new Item();
		item.setDescription("Used to belong to Prof Ponytail");
		item.setItemName("Tesla Parts");
		item.setLocation("A4ST");
		item.setNumInInventory(35);
		item.setPrice(44.0);
		item.setUPC("I56");
		db.addItem(item);
		db.setVisibility(0);
		Ilist= db.getVisibleItems();
		assertTrue(Ilist.size()==count+1);
		assertTrue(db.getCatalog().getItem("I56").getDescription().equals("Used to belong to Prof Ponytail"));
		assertTrue(db.getCatalog().getItem("I56").getItemName().equals("Tesla Parts"));
		assertTrue(db.getCatalog().getItem("I56").getLocation().equals("A4ST"));
		assertTrue(db.getCatalog().getItem("I56").getNumInInventory()==35);
		assertTrue(db.getCatalog().getItem("I56").getPrice()==44.0);
		
		
	}

}
