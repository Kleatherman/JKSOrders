package edu.ycp.cs320.JKSOrders.model;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.Order;

public class CartModel {
	private ArrayList<Item> items;
	private float price;
	CustomerAccount account;
	Order order;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public CartModel(ArrayList<Item> items, float price) {
		this.items = items;
		this.price = price;
	}

	public CartModel() {
		items = new ArrayList<Item>();
		price = 0;
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public CustomerAccount getAccount() {
		return account;
	}

	public void setAccount(CustomerAccount account) {
		this.account = account;
	}

	public Item getItem(int i) {
		return items.get(i);
	}
	
	
}
