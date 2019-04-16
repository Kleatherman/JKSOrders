package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Car;

public class CarTest {
	Car car;
	
	@Before
	public void setUp() {
		car = new Car();
	}
	
	@Test
	public void testSetYear() {
		car.setYear(2004);
		assertEquals(2004,car.getYear());
		assertNotEquals(2000,car.getYear());
		car.setYear(2000);
		assertNotEquals(2004,car.getYear());
		assertEquals(2000,car.getYear());
	}
	
	@Test
	public void testSetBrand() {
		car.setBrand("Subaru");
		assertEquals("Subaru", car.getBrand());
		assertNotEquals("Ford", car.getBrand());
		car.setBrand("Ford");
		assertEquals("Ford", car.getBrand());
		assertNotEquals("Subaru", car.getBrand());
	}
	
	@Test
	public void testSetColor() {
		car.setColor("Silver");
		assertEquals("Silver", car.getColor());
		assertNotEquals("Red", car.getColor());
		car.setColor("Red");
		assertNotEquals("Silver", car.getColor());
		assertEquals("Red", car.getColor());
	}
	
	@Test
	public void testSetType() {
		car.setType("Forester");
		assertEquals("Forester", car.getType());
		assertNotEquals("Outback", car.getType());
		car.setType("Outback");
		assertNotEquals("Forester", car.getType());
		assertEquals("Outback", car.getType());
	}
	
}
