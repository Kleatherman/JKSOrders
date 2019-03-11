package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import edu.ycp.cs320.JKSOrders.classes.Catalog;
import edu.ycp.cs320.JKSOrders.classes.Item;


public class CatalogTest {
	Catalog catalog;
	Item item;
	Map<String, Item> itemMap;
	
	@Before
	public void setUp() {
		catalog = new Catalog();
		item    = new Item();
		
		
	}
	
	@Test
	public void testSetItem() {
		catalog.setItem(item);
		assertEquals(item,catalog.getItem());
	}
	
	@Test
	public void testSetUPC() {
		catalog.setUPC("825005043653");
		assertEquals("825005043653", catalog.getUPC());
	}
	
	@Test
	public void testSetItemMap() {
		catalog.setItemMap(itemMap);;
		assertEquals(itemMap, catalog.getUPC());
	}
	

}
