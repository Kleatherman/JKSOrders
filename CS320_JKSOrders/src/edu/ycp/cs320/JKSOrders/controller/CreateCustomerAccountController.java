package edu.ycp.cs320.JKSOrders.controller;





import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.model.CreateCustomerAccount;



public class CreateCustomerAccountController {
	private CreateCustomerAccount model;
	
		
	
		public void setModel( CreateCustomerAccount model) {
			this.model = model;
		}
		
	

		public void setLogin(String password, String userName ) {
			LoginInfo login = new LoginInfo();
			login.setUserName(userName);
			login.setPassword(password);
			model.getAccount().setLogin(login);
		}
	}
	