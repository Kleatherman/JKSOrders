package edu.ycp.cs320.JKSOrders.controller;

import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.model.EmployeeForgotLogin;

public class EmployeeForgotLoginController {

	private EmployeeForgotLogin model= new EmployeeForgotLogin(); 
	
	public void setModel(EmployeeForgotLogin model) {
		this.model= model;
	}
	
	public void getPassword(Database dbase) {
		model.setPassword(dbase.getPasswordForEmployeeAccount(model.getAccount()));
	}
}
