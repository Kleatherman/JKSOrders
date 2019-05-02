package edu.ycp.cs320.JKSOrders.controller;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.Order;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.model.FulfillOrderModel;

public class FulfillOrderController {
	private FulfillOrderModel model;
	Database db;
	
	public FulfillOrderController(Database bd) {
		db = bd;
	}
	
	public void setModel(FulfillOrderModel model) {
		this.model = model;
	}
	
	public void setOrder(String orderNumber) {
		model.setOrder(db.getOrder(orderNumber));
	}
	
	public void setModelName(String orderNumber) {
		ArrayList<Order> orders= db.getOrders();
		for(Order order : orders) {
			if(order.getOrderType().equals(model.getOrder().getOrderType())) {
				model.setCustomerName(db.getCustomerAccount(order.getAccountNum()));
			}
		}
	}
}
