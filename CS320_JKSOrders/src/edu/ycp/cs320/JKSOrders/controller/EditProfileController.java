package edu.ycp.cs320.JKSOrders.controller;

import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.model.EditProfileModel;

public class EditProfileController {
	private EditProfileModel model;

	public void setModel(EditProfileModel model) {
		this.model = model;
	}
	public void setID(String id, boolean customer) {
		if(customer) {
		model.getCustomerAccount().setAccountNumber(id);
		}
		else {
			model.getEmployeeAccount().setAccountNumber(id);
			char[] accountArray = id.toCharArray();
			if(accountArray[0]=='C')	
				model.getEmployeeAccount().setManager(false);
			else
				model.getEmployeeAccount().setManager(true);
		}
	}

	public void setLogin(String password, String userName, boolean customer) {
		LoginInfo login = new LoginInfo();
		login.setUserName(userName);
		login.setPassword(password);
		if(customer==true) {
			model.getCustomerAccount().setLogin(login);
		}
		else {
			model.getEmployeeAccount().setLogin(login);
		}
		
	}


	public void setName(String firstName, boolean customer) {
		if(customer==false) {
			model.getEmployeeAccount().setFirstName(firstName);
		}
		else {
			model.getCustomerAccount().setFirstName(firstName);
		}
		
	}
	public void setLastName(String lastName, boolean customer) {
		if(customer==false) {
			model.getEmployeeAccount().setLastName(lastName);
		}
		else {
			model.getCustomerAccount().setLastName(lastName);
		}
		
	}

	public void setPhoneNumber(String phoneNumber, boolean customer) {
		if(customer== true) {
			model.getCustomerAccount().setPhoneNumber(phoneNumber);
		}
		else {
			model.getEmployeeAccount().setPhoneNumber(phoneNumber);
		}
			
	}
	
	public void setEmail(String email, boolean customer) {
		if(customer== true) {
			model.getCustomerAccount().setEmail(email);
		}
		else {
			model.getEmployeeAccount().setEmail(email);
		}
			
	}
	
	public void setCarMake(String make) {
			model.getCustomerAccount().getPickUpInfo().getCar().setBrand(make);
		
			
	}
	
	public void setCarModel(String cmodel) {
	
		model.getCustomerAccount().getPickUpInfo().getCar().setType(cmodel);
	
			
	}
	
	public void setCarColor(String color) {
		
		model.getCustomerAccount().getPickUpInfo().getCar().setColor(color);
	
			
	}
	public void setCarYear(int year) {
		
		model.getCustomerAccount().getPickUpInfo().getCar().setYear(year);;
	
			
	}


	public void editAccount(Database dbase, boolean customer) {
		if(customer==true) {
			dbase.updateCustomerAccount(model.getCustomerAccount());
		}
		else {
			dbase.updateEmployeeAccount(model.getEmployeeAccount());
		}
		

	}
}
