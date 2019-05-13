package edu.ycp.cs320.JKSOrders.model;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;

public class EditProfileModel {
	
private CustomerAccount caccount= new CustomerAccount();
private EmployeeAccount eaccount= new EmployeeAccount();
private boolean customer = false;
	
	public EditProfileModel() {
		
	}

	public CustomerAccount getCustomerAccount() {
		return caccount; 
	}
	
	public void setCustomerAccount(CustomerAccount customerAccount) {
		this.caccount = customerAccount;
	}
	
	public EmployeeAccount getEmployeeAccount() {
		return eaccount; 
	}
	
	public void setEmployeeAccount(EmployeeAccount employeeAccount) {
		this.eaccount = employeeAccount;
	}

	public boolean isCustomer() {
		return customer;
	}

	public void setCustomer(boolean customer) {
		this.customer = customer;
	}

}
