package edu.ycp.cs320.JKSOrders.model;

import edu.ycp.cs320.JKSOrders.classes.Car;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.Order;

public class FulfillOrderModel {
	private Order order;
	private CustomerAccount customer;
	private Car car;
	
	
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
	public CustomerAccount getCustomerName() {
		return customer;
	}
	public void setCustomerName(CustomerAccount customerName) {
		customer = customerName;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
}
