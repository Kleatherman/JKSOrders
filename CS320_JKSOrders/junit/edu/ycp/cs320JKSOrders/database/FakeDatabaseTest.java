package edu.ycp.cs320JKSOrders.database;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.database.InitFakeDatabase;

public class FakeDatabaseTest {
	Database db;
	@Before
	public void setUp() {
		db = InitFakeDatabase.init();
	}
	@Test
	public void deleteNotificationTest() {
		Notification notify = db.getNotifications("M0").get(0);
		db.deleteNotification(notify.getNotificationID());
		assertTrue(db.getNotification(notify.getNotificationID())==null);
	}
	
	
	

}
