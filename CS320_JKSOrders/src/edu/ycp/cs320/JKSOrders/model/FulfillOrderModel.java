package edu.ycp.cs320.JKSOrders.model;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;
import edu.ycp.cs320.JKSOrders.classes.Order;

public class FulfillOrderModel {
	private Order order;
	private CustomerAccount customer;
	private Car car;
	private String errorMessage;
	
	public FulfillOrderModel() {
		this.order = new Order();
		customer = new CustomerAccount();
		this.car = new Car();
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public CustomerAccount getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerAccount customerName) {
		customer = customerName;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public ArrayList<Item> getItemList(){
		return order.getItemList();
	}
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
