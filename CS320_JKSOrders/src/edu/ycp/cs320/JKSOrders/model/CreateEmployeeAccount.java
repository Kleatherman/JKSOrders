package edu.ycp.cs320.JKSOrders.model;

import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;

public class CreateEmployeeAccount {
	
	private EmployeeAccount account;
	
	public CreateEmployeeAccount() {
		account= new EmployeeAccount();
	}

	public EmployeeAccount getAccount() {
		return account; 
	}

	public void setAccount(EmployeeAccount account) {
		
		this.account = account;
	}

}
