package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Inventory;

public class InventoryTest {
	Inventory inventory;
	ArrayList<String> greater;
	ArrayList<String> less;
	
	@Before
	public void setUp() {
		inventory = new Inventory();
	}
	
	// Need to implement this method
	public void testReturnGreaterOrLess() {
	
		
	}
	
	@Test
	public void testsetQuanityMap() {
		Map<String, Integer> quanityMap = null;
		inventory.setQuanityMap(quanityMap);
		assertEquals(quanityMap,inventory.getQuanityMap());
		
	}
}
