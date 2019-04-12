package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.CreditCard;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.classes.PickUpInfo;

public class CustomerAccountTest {
	CustomerAccount customerAccount;
	
	 
	
	
	@Before
	public void setUp() {
		customerAccount = new CustomerAccount();
	}
	
	@Test
	public void testSetCreditCard() {
		CreditCard creditCard = null;
		customerAccount.setCreditCard(creditCard);
		assertTrue(creditCard ==customerAccount.getCreditCard());
	}
	
	@Test
	public void testSetEmail() {
		customerAccount.setEmail("email");
		assertEquals("email", customerAccount.getEmail());
	}
	
	@Test
	public void testSetPickupInfo() {
		PickUpInfo pickUpInfo = null;
		customerAccount.setPickUpInfo(pickUpInfo);
		assertEquals(pickUpInfo, customerAccount.getPickUpInfo());
	}
	@Test
	public void testSetAccountNumber() {
		customerAccount.setAccountNumber("accountNumber");
		assertEquals("accountNumber", customerAccount.getAccountNumber());
	}
	
	@Test
	public void testSetName() {
		customerAccount.setFirstName("Name");
		assertEquals("Name", customerAccount.getFirstName());
	}
	
	@Test
	public void testSetLogin() {
		LoginInfo login = null;
		customerAccount.setLogin(login);;
		assertEquals(login, customerAccount.getLogin());
	}
	
	@Test
	public void testSetPhoneNumber() {
		customerAccount.setPhoneNumber("7178818242");
		assertEquals("7178818242", customerAccount.getPhoneNumber());
	}
	
	@Test
	public void testSetOrders() {
		ArrayList<Order> orders = null;
		customerAccount.setOrders(orders);
		assertEquals(orders, customerAccount.getOrders());
	}
	
	
	public void testRemoveOrder() {
		ArrayList<Order> orders = null;
		customerAccount.setOrders(orders);
		Order order = new Order();
		customerAccount.addOrder(order);
		customerAccount.removeOrder(0);
		assertEquals(true, customerAccount.getOrders().isEmpty());
	}
	
	public void testaddOrder() {
		Order order0 = null;
		Order order1 = null;
		Order order2 = null;
		customerAccount.addOrder(order0);
		customerAccount.addOrder(order1);
		customerAccount.addOrder(order2);
		assertEquals(order0, customerAccount.getOrder(0));
		assertEquals(order1, customerAccount.getOrder(1));
		assertEquals(order2, customerAccount.getOrder(2));
	}
	
}
