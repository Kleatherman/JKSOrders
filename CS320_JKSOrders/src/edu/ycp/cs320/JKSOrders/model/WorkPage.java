package edu.ycp.cs320.JKSOrders.model;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Order;

public class WorkPage {
	
	private EmployeeAccount eaccount;
	private CustomerAccount caccount;
	private ArrayList<Order> orders;
	
	public WorkPage() {
		orders = new ArrayList<Order>();
		caccount = new CustomerAccount();
		eaccount =new EmployeeAccount();
	}
	public EmployeeAccount getEmployeeAccount() {
		return eaccount;
	}
	public void setEmployeeAccount(EmployeeAccount eaccount) {
		this.eaccount= eaccount;
	}
	public CustomerAccount getCustomerAccount() {
		return caccount;
	}
	public void setCustomerAccount(CustomerAccount caccount) {
		this.caccount= caccount;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
}
