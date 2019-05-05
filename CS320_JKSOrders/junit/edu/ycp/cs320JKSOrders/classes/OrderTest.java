package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.classes.PickUpInfo;

public class OrderTest {
	Order order;
	
	@Before
	public void setUp() {
		order = new Order();
	}
	
	@Test
	public void testSetItemList() {
		ArrayList<Item> itemlist = null;
		order.setItemList(itemlist);
		assertEquals(itemlist,order.getItemList());
	}
	
	@Test
	public void testSetQuantityMap() {
		Map<String, Integer> quantityMap = null;
		order.setQuantityMap(quantityMap);
		assertEquals(quantityMap,order.getQuantityMap());
	}
	
	
}
