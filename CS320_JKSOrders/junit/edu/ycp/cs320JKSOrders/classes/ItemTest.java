package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Item;


public class ItemTest {
	 Item item;
	 
	 
	 @Before
	 public void setUp() {
		 item = new Item();
	 }
	@Test
	public void testSetItemName() {
		item.setItemName("Book");
		assertEquals("Book",item.getItemName());
	}
	
	public void testSetUPC() {
		item.setUPC("000000000000");
		assertEquals("000000000000",item.getUPC());
	}
	
	
	public void testSetPrice() {
		item.setPrice(50.99);
		assertEquals(50.99,item.getPrice(),.005);
	}
	
	public void testSetDescription() {
		item.setDescription("This is an item Description");
		assertEquals("This is an item Description",item.getDescription());
	}
	
	public void testSetLocation() {
		item.setLocation("This is an item Location");
		assertEquals("This is an item Location",item.getLocation());
	}
	
	public void testSetPhoto() {
		item.setPhoto("This is an item Photo");
		assertEquals("This is an item Photo",item.getPhoto());
	}
	
	public void testisVisible() {
		item.setVisable(true);
		assertTrue(item.isVisable());
	}
}
