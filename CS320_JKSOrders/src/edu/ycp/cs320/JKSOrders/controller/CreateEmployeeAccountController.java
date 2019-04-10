package edu.ycp.cs320.JKSOrders.controller;



import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.model.CreateEmployeeAccount;



public class CreateEmployeeAccountController {
	private CreateEmployeeAccount model;
			
	
		public void setModel( CreateEmployeeAccount model) {
			this.model = model;
		}
		

		public void setLogin(String password, String userName ) {
			LoginInfo login = new LoginInfo();
			login.setUserName(userName);
			login.setPassword(password);
			model.getAccount().setLogin(login);
		}
		
		public void setAccountNumber(Database dbase) {
			model.getAccount().setAccountNumber(dbase.getLastEmployeeAccountNumber().substring(0, 1) + Integer.parseInt(dbase.getLastEmployeeAccountNumber())+1);
			
		}
		
		}

	
		
