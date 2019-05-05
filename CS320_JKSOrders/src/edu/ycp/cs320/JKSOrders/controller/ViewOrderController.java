package edu.ycp.cs320.JKSOrders.controller;


import edu.ycp.cs320.JKSOrders.model.ViewOrder;

public class ViewOrderController {
	private ViewOrder model;
	
	public ViewOrderController(ViewOrder model) {
		this.model=model;
	}

	public ViewOrder getModel() {
		return model;
	}

	public void setModel(ViewOrder model) {
		this.model = model;
	}
	
}
