package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;

public abstract class Account {
	private String name;
	private String accountNumber;
	private LoginInfo login;
	private PickUpInfo pickUpInfo;
	private ArrayList<Order> orders;
	
	public Account() {
	
	}
	
	public ArrayList<Order> getOrders() {
		return orders;
	}

	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	public Order getOrder(int i) {
		return orders.get(i);
	}
	
	public void removeOrder(int i) {
		orders.remove(i);
	}
	
	public void addOrder(Order order) {
		orders.add(order);
	}

	public void createOrder() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LoginInfo getLogin() {
		return login;
	}

	public void setLogin(LoginInfo login) {
		this.login = login;
	}

	public PickUpInfo getPickUpInfo() {
		return pickUpInfo;
	}

	public void setPickUpInfo(PickUpInfo pickUpInfo) {
		this.pickUpInfo = pickUpInfo;
	}
	

}
