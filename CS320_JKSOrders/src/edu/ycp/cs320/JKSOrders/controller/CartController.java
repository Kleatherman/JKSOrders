package edu.ycp.cs320.JKSOrders.controller;

import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.model.CartModel;

public class CartController {
	private CartModel model;
	
	public CartController(CartModel model) {
		this.model=model;
	}

	public CartModel getModel() {
		return model;
	}

	public void setModel(CartModel model) {
		this.model = model;
	}
	
}
