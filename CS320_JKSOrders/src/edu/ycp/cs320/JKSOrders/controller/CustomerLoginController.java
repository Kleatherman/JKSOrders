package edu.ycp.cs320.JKSOrders.controller;


import edu.ycp.cs320.JKSOrders.model.Login;

public class CustomerLoginController {
	private Login model;

	public void setModel(Login model) {
		this.model = model;
	}

	public void setUserName(String userName) {

		model.setUserName(userName);

	}

	public void setPassword(String password) {
		model.setPassword(password);
	}
}
