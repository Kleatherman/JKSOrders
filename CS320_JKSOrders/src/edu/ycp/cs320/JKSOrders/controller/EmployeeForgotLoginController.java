package edu.ycp.cs320.JKSOrders.controller;

import edu.ycp.cs320.JKSOrders.model.EmployeeForgotLogin;

public class EmployeeForgotLoginController {

	private EmployeeForgotLogin model= new EmployeeForgotLogin(); 
	
	public void setModel(EmployeeForgotLogin model) {
		this.model= model;
	}
	
	public void getPassword(SystemController scontrol) {
		model.setPassword(scontrol.getPasswordForEmployeeAccount(model.getAccount()));
	}
}
