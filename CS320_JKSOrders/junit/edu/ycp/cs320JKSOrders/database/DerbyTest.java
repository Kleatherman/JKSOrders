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
	public void testSetVisible() {
		db.setVisibility(0);
		Ilist = db.getVisibleItems();
		assertTrue(InitI.size()==2);
		db.setVisibility(99);
		Ilist = db.getVisibleItems();
		assertTrue(Ilist.size()==0);
		db.setVisibility(60);
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
		// assertTrue(Nlist.get(3).getNotificationID().equals("U3"));
		// assertTrue(Nlist.get(3).getMessage().equals("I'm dummy thicc"));
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
	
	@Test
	public void testDeleteAccount() {
		Elist= db.getEmployeeAccounts();
		Clist= db.getCustomerAccounts();
		Nlist = db.getNotifications();
		ArrayList<Car> cars = db.getCars();
		ArrayList<Order> allOrders = db.getOrders();
		int carSize = cars.size();
		int orderSize = allOrders.size();
		int Ecount = Elist.size();
		int Ccount = Clist.size();
		int notificationSize = Nlist.size();
		
		db.deleteAccount("C0");
		Elist= db.getEmployeeAccounts();
		Clist= db.getCustomerAccounts();
		Nlist = db.getNotifications();
		cars = db.getCars();
		allOrders = db.getOrders();
		
		assertTrue(Clist.size()==Ccount-1);
		assertTrue(Nlist.size()==notificationSize);
		assertTrue(Elist.size()==Ecount);
		assertTrue(!Clist.get(0).getAccountNumber().equals("C0"));
		assertTrue(cars.size()==carSize-1);
		assertTrue(db.getSourceOrders("C0")==null);
		
		db.deleteAccount("M0");
		Elist= db.getEmployeeAccounts();
		Clist= db.getCustomerAccounts();
		Nlist = db.getNotifications();
		cars = db.getCars();
		allOrders = db.getOrders();
		
		assertTrue(Clist.size()==Ccount-1);
		assertTrue(Nlist.size()==notificationSize-1);
		assertTrue(Elist.size()==Ecount-1);
		assertTrue(!Clist.get(0).getAccountNumber().equals("C0"));
		assertTrue(cars.size()==carSize-1);
		assertTrue(db.getSourceNotifications("M0")==null);
		assertTrue(!Elist.get(0).getAccountNumber().equals("M0"));
	
	}

	@Test
	public void testAddOrders() {
		TreeMap<String, Integer> Map= new TreeMap<String,Integer>();
		ArrayList<Item> itemlist= new ArrayList<Item>();
		int itemcount= db.getVisibleItems().get(0).getNumInInventory();
		itemlist.add(db.getVisibleItems().get(0));
		Map.put(itemlist.get(0).getUPC(), 2);
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
		assertTrue(db.getVisibleItems().get(0).getNumInInventory()==itemcount-2);
		assertTrue(db.getOrder("P12").getItemlist().get(0).getNumInOrder()==2);
		assertTrue(db.getOrder("P12").getTotalPrice()!=0);
		order.setOrderType("P13");
		db.addOrder(order);
		assertTrue(db.getOrder("P13").getItemlist().get(0).getUPC().equals("I0"));
		assertTrue(db.getVisibleItems().get(0).getNumInInventory()==itemcount-4);
		assertTrue(db.getOrder("P13").getItemlist().get(0).getNumInOrder()==2);
		assertTrue(db.getOrder("P13").getTotalPrice()!=0);
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
	@Test
	public void testGetLastPickupOrderNumber() {
		String test= db.getLastPickUpOrderNumber();
		int lastInt2 = Integer.parseInt(test.substring(1));
		
		
		TreeMap<String, Integer> Map= new TreeMap<String,Integer>();
		ArrayList<Item> itemlist= new ArrayList<Item>();
		itemlist.add(db.getVisibleItems().get(0));
		Map.put(itemlist.get(0).getUPC(), 1);
		Order order = new Order();
		order.setAccountNum("C2");
		order.setItemlist(itemlist);
		order.setQuantityMap(Map);
		order.setItemQuantities();
		order.setOrderType("P96");
		order.setTotalPrice();
		db.addOrder(order);
		
		test= db.getLastPickUpOrderNumber();
		int lastInt = Integer.parseInt(test.substring(1));
		System.out.println("This is LastInt "+lastInt);
		assertTrue(96==lastInt);
		
		order.setAccountNum("C2");
		order.setItemlist(itemlist);
		order.setQuantityMap(Map);
		order.setItemQuantities();
		order.setOrderType("I675");
		order.setTotalPrice();
		
		test= db.getLastPickUpOrderNumber();
		lastInt = Integer.parseInt(test.substring(1));
		assertTrue(96==lastInt);
	}
	
	@Test
	public void testUpdateCustomerAccount() {
		CustomerAccount updatedCustomer = db.getCustomerAccount("C0");
		updatedCustomer.setEmail("newEmail@email.com");
		updatedCustomer.setFirstName("John");
		updatedCustomer.setLastName("Smith");
		updatedCustomer.getLogin().setUserName("fakeUserNameYall!!");
		db.updateCustomerAccount(updatedCustomer);
		
		CustomerAccount newCustomer = db.getCustomerAccount("C0");
		assertTrue(newCustomer.getFirstName().equals("John")&&newCustomer.getLastName().equals("Smith"));
		assertTrue(newCustomer.getLogin().getUserName().equals("fakeUserNameyall!!"));
		assertTrue(newCustomer.getEmail().equals("newEmail@email.com"));
		assertTrue(newCustomer.getAccountNumber().equals(updatedCustomer.getAccountNumber()));
	}

	@Test
	public void testUpdateEmployeeAccount() {
		EmployeeAccount updatedEmployee = db.getEmployeeAccount("M0");
		updatedEmployee.setEmail("newEmail@email.com");
		updatedEmployee.setFirstName("John");
		updatedEmployee.setLastName("Smith");
		updatedEmployee.getLogin().setUserName("fakeUserNameYall!!");
		db.updateEmployeeAccount(updatedEmployee);
		
		EmployeeAccount newEmployee = db.getEmployeeAccount("M0");
		assertTrue(newEmployee.getFirstName().equals("John")&&newEmployee.getLastName().equals("Smith"));
		assertTrue(newEmployee.getLogin().getUserName().equals("fakeUserNameyall!!"));
		assertTrue(newEmployee.getEmail().equals("newEmail@email.com"));
		assertTrue(newEmployee.getAccountNumber().equals(updatedEmployee.getAccountNumber()));
	}
}
