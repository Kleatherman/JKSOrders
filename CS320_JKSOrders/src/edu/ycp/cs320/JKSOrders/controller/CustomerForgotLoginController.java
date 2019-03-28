package edu.ycp.cs320.JKSOrders.controller;

import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.model.CustomerForgotLogin;

public class CustomerForgotLoginController {
	
	private CustomerForgotLogin model = new CustomerForgotLogin();
	
	public void setModel(CustomerForgotLogin model) {
		this.model=model;
	}
	
	public void getPassword(Database dbase) {
		model.setPassword(dbase.getPasswordForCustomerAccount(model.getAccount()));
	}

}
