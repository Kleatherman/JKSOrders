package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.PickUpInfo;

public class PickUpInfoTest {
	PickUpInfo pickUp;
	
	@Before
	public void setUp() {
		pickUp = new PickUpInfo();
	}
	
	@Test
	public void testSetTime() {
		pickUp.setTime(1.2);
		assertTrue(1.2==pickUp.getTime());
	}
	
	@Test
	public void testSetStoreID() {
		pickUp.setStoreID("AG395JD");
		assertTrue(pickUp.getStoreID().equals("AG395JD"));
	}
	
	@Test
	public void testSetCar() {
		Car car = new Car();
		car.setBrand("Ford");
		car.setColor("Red");
		car.setType("Escort");
		car.setYear(1998);
		
		pickUp.setCar(car);
		assertTrue(car.getBrand().equals(pickUp.getCar().getBrand()));
		assertTrue(car.getColor().equals(pickUp.getCar().getColor()));
		assertTrue(car.getType().equals(pickUp.getCar().getType()));
		assertTrue(car.getYear()==pickUp.getCar().getYear());
	}
}
