package edu.ycp.cs320JKSOrders.database;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.database.Database;

public class DerbyTest {
	Database db;
	ArrayList<EmployeeAccount> 
	
	@Before
	public void setUp() {
		db= new DerbyDatabase();
		
	}
	@Test 
	public void testGetEmployeeAccounts() {
		db.getEmployeeAccounts()
	}
}
