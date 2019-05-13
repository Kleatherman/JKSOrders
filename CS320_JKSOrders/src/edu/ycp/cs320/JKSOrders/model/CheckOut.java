package edu.ycp.cs320.JKSOrders.model;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.Order;

public class CheckOut{
	private CustomerAccount account;
	private Order order;
	private String errorMessage;
	boolean car;
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public float getPrice() {
		return (float)order.getTotalPrice();
	}

	public CustomerAccount getAccount() {
		return account;
	}
	
	public String getAccountNumber() {
		return account.getAccountNumber();
	}
	public void setAccount(CustomerAccount account) {
		this.account = account;
	}
	
	public ArrayList<Item> getItemArrayList() {
		return order.getItemList();
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public boolean isCar() {
		return car;
	}

	public void setCar(boolean car) {
		this.car = car;
	}

	
}
