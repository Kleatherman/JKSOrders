package edu.ycp.cs320.JKSOrders.model;

import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;

public class ProfilePage {
	
	private EmployeeAccount eaccount =new EmployeeAccount();
	private CustomerAccount caccount = new CustomerAccount();
	
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

}
