package edu.ycp.cs320.JKSOrders.controller;

import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.model.CreateCustomerAccount;

public class CreateCustomerAccountController {
	private CreateCustomerAccount model;

	public void setModel(CreateCustomerAccount model) {
		this.model = model;
	}

	public void setLogin(String password, String userName) {
		LoginInfo login = new LoginInfo();
		login.setUserName(userName);
		login.setPassword(password);
		model.getAccount().setLogin(login);
	}

	public void setAccountNumber(Database dbase) {
		model.getAccount().setAccountNumber(dbase.getLastCustomerAccountNumber().substring(0, 1)
				+ Integer.parseInt(dbase.getLastCustomerAccountNumber()) + 1);

	}

	public void setName(String firstName) {

		model.getAccount().setFirstName(firstName);
	}

	public void setPhoneNumber(String phoneNumber) {

		model.getAccount().setPhoneNumber(phoneNumber);
	}

	public void setNullValues() {
		model.getAccount().setEmail(" ");
		model.getAccount().setLastName(" ");
		model.getAccount().setPhoneNumber(" ");
		model.getAccount().getCreditCard().setCVC(" ");
		model.getAccount().getPickUpInfo().getCar().setBrand(" ");
		model.getAccount().getPickUpInfo().getCar().setColor(" ");
		model.getAccount().getPickUpInfo().getCar().setType(" ");
		model.getAccount().getPickUpInfo().getCar().setYear(0);

	}

	public void addAccount(Database dbase) {
		dbase.addCustomerAccount(model.getAccount());

	}
}
