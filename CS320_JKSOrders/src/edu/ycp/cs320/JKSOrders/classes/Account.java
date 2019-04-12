	package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;

public abstract class Account {
	private String firstName;
	private String lastName;
	private String accountNumber;
	private LoginInfo login;
	private PickUpInfo pickUpInfo;
	private ArrayList<Order> orders;
	private String phoneNumber;
	private String email;
	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Account() {
	
	}
	
	
	public ArrayList<Order> getOrders() {
		return orders;
	}

	/**
	 * @param orders ArrayList of Orders to set
	 */
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
	/**
	 * @param i index of order to get
	 * @return the order at index i of the Orders ArrayList
	 */
	public Order getOrder(int i) {
		return orders.get(i);
	}
	
	/**
	 * @param i index of order, in Orders ArrayList to remove
	 */
	public void removeOrder(int i) {
		orders.remove(i);
	}
	
	/**
	 * @param order order to add to the Orders ArrayList
	 */
	public void addOrder(Order order) {
		orders.add(order);
	}

	/**
	 * Creates an order
	 */
	public void createOrder() {
		
	}

	/**
	 * @return name associated with the account
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param name name to set
	 */
	public void setFirstName(String name) {
		this.firstName = name;
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
	
	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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
