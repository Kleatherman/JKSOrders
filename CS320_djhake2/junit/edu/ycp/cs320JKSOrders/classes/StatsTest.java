package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Stats;


public class StatsTest {
	Stats stats;
	
	@Before
	public void setUp() {
		stats = new Stats();
	}
	
	@Test
	public void testSetTimeTaken() {
		stats.setTimeTaken(5.5);
		assertTrue(5.5==stats.getTimeTaken());
	}
	
	@Test
	public void testSetBrand() {
		stats.setItemsperMin(5.5);
		assertTrue(5.5==stats.getItemsperMin());
	}
	
	@Test
	public void testSetNumItemsProcessed() {
		stats.setNumitemsProcessed(5);
		assertEquals(5, stats.getNumitemsProcessed());
	}
	
	
}
