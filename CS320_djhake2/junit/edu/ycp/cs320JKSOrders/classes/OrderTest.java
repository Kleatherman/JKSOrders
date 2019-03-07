package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.PickUpInfo;

public class OrderTest {
	Car car;
	
	@Before
	public void setUp() {
		car = new Car();
	}
	
	@Test
	public void testSetYear() {
		car.setYear(2004);
		assertTrue(2004==car.getYear());
	}
	
	@Test
	public void testSetBrand() {
		car.setBrand("Subaru");
		assertEquals("Subaru", car.getBrand());
	}
	
	@Test
	public void testSetColor() {
		car.setColor("Silver");
		assertEquals("Silver", car.getColor());
	}
	
	@Test
	public void testSetType() {
		car.setType("Forester");
		assertEquals("Forester", car.getType());
	}
	
}
