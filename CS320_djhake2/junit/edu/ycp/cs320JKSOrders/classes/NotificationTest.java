package edu.ycp.cs320JKSOrders.classes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.classes.PickUpInfo;

public class NotificationTest {
	 Notification notification;
	
	@Before
	public void setUp() {
	notification = new Notification();
	}
	
	@Test
	public void testSetMessage() {
		notification.setMessage("Message");
		assertTrue("Message"==notification.getMessage());
	}
	
	@Test
	public void testSetDestination() {
		ArrayList<String> destinationNames = null;
		notification.setDestination(destinationNames);
		assertEquals(destinationNames, notification.getDestination());
	}
	
	@Test
	public void testSetUrgency() {
		notification.setUrgency(true);
		assertTrue(notification.getUrgency());
	}
	
	@Test
	public void testAddDestinationName() {
		notification.addDestinationName("name");
		assertEquals("name", notification.getDestination().get(0));
	}
	
	@Test
	public void testRemoveDestination() {
		notification.removeDestinationName("name");
		assertTrue(null==notification.getDestination().get(0));
	}
	
}
