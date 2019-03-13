package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Inventory;

public class InventoryTest {
	Inventory inventory;
	
	@Before
	public void setUp() {
		inventory = new Inventory();
	}
	
	@Test
	public void testReturnGreaterOrLess() {
		int x = 0;
		ArrayList<String> greater = null;
		ArrayList<String> less = null;
		assertEquals(null,inventory.returnGreaterorLess(x, greater, less));
		
	}
	
	public void testsetQuanityMap() {
		Map<String, Integer> quanityMap = null;
		inventory.setQuanityMap(quanityMap);
		assertEquals(quanityMap,inventory.getQuanityMap());
		
	}
}
