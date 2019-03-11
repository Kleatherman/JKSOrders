package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.LoginInfo;


public class LoginInfoTest {
	LoginInfo login;
	
	@Before
	public void setUp() {
		login = new LoginInfo();
	}
	
	@Test
	public void testSetUserName() {
		login.setUserName("jsam");
		assertEquals("jsam",login.getUserName());
	}
	
	@Test
	public void testSetStoreID() {
		login.setPassword("Password");
		assertEquals("Password",login.getPassword());
	}
	
	@Test
	public void testEquals() {
		assertTrue(login.equals(login));
		assertTrue(!login.equals(null));
	}
}
