package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.classes.PickUpInfo;
import edu.ycp.cs320.JKSOrders.classes.Stats;

public class EmployeeAccountTest {
	EmployeeAccount employeeAccount;
	
		@Before
		public void setUp() {
			employeeAccount = new EmployeeAccount();
		}
		
		@Test
		public void testSetPickupInfo() {
			PickUpInfo pickUpInfo = null;
			employeeAccount.setPickUpInfo(pickUpInfo);
			assertEquals(pickUpInfo, employeeAccount.getPickUpInfo());
		}
		@Test
		public void testSetAccountNumber() {
			employeeAccount.setAccountNumber("accountNumber");
			assertEquals("accountNumber", employeeAccount.getAccountNumber());
		}
		
		@Test
		public void testSetName() {
			employeeAccount.setName("Name");
			assertEquals("Name", employeeAccount.getFirstName());
		}
		
		@Test
		public void testSetLogin() {
			LoginInfo login = null;
			employeeAccount.setLogin(login);;
			assertEquals(login, employeeAccount.getLogin());
		}
		
		
		@Test
		public void testSetOrder() {
			ArrayList<Order> orders = null;
			employeeAccount.setOrders(orders);
			assertEquals(orders, employeeAccount.getOrders());
		}
		
		
		public void testRemoveOrder() {
			Order order0 = new Order();
			Order order1 = new Order();
			Order order2 = new Order();
			employeeAccount.addOrder(order0);
			employeeAccount.addOrder(order1);
			employeeAccount.addOrder(order2);
			employeeAccount.removeOrder(0);
			assertEquals(2, employeeAccount.getOrders().size());
		}
		
		
		public void testaddOrder() {
			Order order0 = new Order();
			Order order1 = new Order();
			Order order2 = new Order();
			employeeAccount.addOrder(order0);
			employeeAccount.addOrder(order1);
			employeeAccount.addOrder(order2);
			assertEquals(order0, employeeAccount.getOrder(0));
			assertEquals(order1, employeeAccount.getOrder(1));
			assertEquals(order2, employeeAccount.getOrder(2));
		}
		
		@Test
		public void testSetManager() {
			employeeAccount.setManager(true);
			assertTrue(employeeAccount.isManager());
		}
		
		@Test
		public void testSetStats() {
			Stats stats = null;
			employeeAccount.setStats(stats);
			assertEquals(stats, employeeAccount.getStats());
		}
	}
