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
	
	/**
	 * @return
	 */
	public ArrayList<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	/**
	 * @param i
	 * @return
	 */
	public Order getOrder(int i) {
		return orders.get(i);
	}
	
	/**
	 * @param i
	 */
	public void removeOrder(int i) {
		orders.remove(i);
	}
	
	/**
	 * @param order
	 */
	public void addOrder(Order order) {
		orders.add(order);
	}

	/**
	 * 
	 */
	public void createOrder() {
		
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return
	 */
	public LoginInfo getLogin() {
		return login;
	}

	/**
	 * @param login
	 */
	public void setLogin(LoginInfo login) {
		this.login = login;
	}

	/**
	 * @return
	 */
	public PickUpInfo getPickUpInfo() {
		return pickUpInfo;
	}

	/**
	 * @param pickUpInfo
	 */
	public void setPickUpInfo(PickUpInfo pickUpInfo) {
		this.pickUpInfo = pickUpInfo;
	}
	

}
