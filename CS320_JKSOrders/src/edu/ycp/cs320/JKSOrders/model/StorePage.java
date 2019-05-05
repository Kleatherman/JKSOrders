package edu.ycp.cs320.JKSOrders.model;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.Item;

public class StorePage {
	private EmployeeAccount eaccount =new EmployeeAccount();
	private CustomerAccount caccount = new CustomerAccount();
	private ArrayList<Item> items = new ArrayList<Item>();
	String errorMessage;
	
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
	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
}
