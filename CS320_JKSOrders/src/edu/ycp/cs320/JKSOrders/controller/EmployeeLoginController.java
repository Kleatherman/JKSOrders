package edu.ycp.cs320.JKSOrders.controller;

import edu.ycp.cs320.JKSOrders.classes.LoginInfo;

public class EmployeeLoginController {
	private LoginInfo model;

	public LoginInfo getModel() {
		return model;
	}

	public void setModel(LoginInfo model) {
		this.model = model;
	}

	public void setUserName(String userName) {

		model.setUserName(userName);

	}
	
	public void setPassword(String password) {
		model.setPassword(password);
	}

}
