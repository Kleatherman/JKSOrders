package edu.ycp.cs320.JKSOrders.model;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;

public class ProfilePage {
	
	private EmployeeAccount employeeAccount =new EmployeeAccount();
	private CustomerAccount customerAccount = new CustomerAccount();
	private boolean customer;
	private boolean employee;
	
	public EmployeeAccount getEmployeeAccount() {
		return employeeAccount;
	}
	public void setEmployeeAccount(EmployeeAccount employeeAccount) {
		this.employeeAccount= employeeAccount;
	}
	public CustomerAccount getCustomerAccount() {
		return customerAccount;
	}
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.customerAccount= customerAccount;
	}
	public boolean isCustomer() {
		return customer;
	}
	public void setCustomer(boolean customer) {
		this.customer = customer;
	}
	public boolean isEmployee() {
		return employee;
	}
	public void setEmployee(boolean employee) {
		this.employee = employee;
	}


}
