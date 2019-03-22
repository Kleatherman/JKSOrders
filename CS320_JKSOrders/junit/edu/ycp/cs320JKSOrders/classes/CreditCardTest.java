package edu.ycp.cs320JKSOrders.classes;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.CreditCard;


public class CreditCardTest {
	CreditCard creditCard;
	
	@Before
	public void setUp() {
		creditCard = new CreditCard();
	}
	
	@Test
	public void testSetAccountNumber() {
		creditCard.setAccountNumber("0000000000000000");
		assertEquals("0000000000000000",creditCard.getAccountNumber());
		assertNotEquals("000012414212",creditCard.getAccountNumber());
	}
	
	@Test
	public void testSetCVC() {
		creditCard.setCVC("131");
		assertEquals("131", creditCard.getCVC());
		assertNotEquals("130", creditCard.getCVC());
	}
	
	@Test
	public void testSetNameOnCard() {
		creditCard.setNameOnCard("Kyle Leatherman");
		assertEquals("Kyle Leatherman", creditCard.getNameOnCard());
		assertNotEquals("Josiah Sam", creditCard.getNameOnCard());
	}
	
	@Test
	public void testSetExperationDate() {
		creditCard.setExpirationDate("03/21/1999");
		assertEquals("03/21/1999", creditCard.getExpirationDate());
	}
	
}
