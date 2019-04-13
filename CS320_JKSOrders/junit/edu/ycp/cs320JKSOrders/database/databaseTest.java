package edu.ycp.cs320JKSOrders.database;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;

public class databaseTest {
	Database db;
	@Before
	public void setUp() {
		db = InitDatabase.init();
	}
	@Test
	public void deleteNotificationTest() {
		Notification notify = db.getNotifications("M0").get(0);
		db.deleteNotification(notify.getNotificationID());
		assertTrue(db.getNotification(notify.getNotificationID())==null);
	}

}
