package edu.ycp.cs320JKSOrders.database;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDerbyDatabase;

public class DerbyTest {
	Database db;
	ArrayList list;
	
	@Before
	public void setUp() {
		db = new InitDerbyDatabase().init();
		
	}
	@Test 
	public void testGetEmployeeAccounts() {
		list= db.getEmployeeAccounts();
		assertTrue(list.size()==3);
		assertTrue(((Account) list.get(0)).getAccountNumber().equals("M0"));
	}
	@Test 
	public void testGetCustomersAccounts() {
		list= db.getCustomerAccounts();
		assertTrue(list.size()==3);
		assertTrue(((Account) list.get(0)).getAccountNumber().equals("C0"));
	}
	@Test
	public void testGetCustomerLogin() {
		list= db.getCustomerLoginInfo();
		assertTrue(list.size()==3);
		assertTrue(list.get(0).);
	}
	@Test
	public void testGetEmployeeLogin() {
		
	}
}
