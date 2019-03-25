package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

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
		itemMap = new TreeMap<String, Item>();
		item.setUPC("0000");
		
		
	}
	
	@Test
	public void testSetItem() {
		catalog.setItem(item);
		assertEquals(item,catalog.getItem("0000"));
	}
	
	
	@Test
	public void testSetItemMap() {
		catalog.setItemMap(itemMap);;
		assertEquals(itemMap, catalog.getItemMap());
	}
	

}
