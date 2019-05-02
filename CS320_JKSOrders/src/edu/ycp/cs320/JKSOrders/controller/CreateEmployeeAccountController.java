package edu.ycp.cs320.JKSOrders.controller;



import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.model.CreateEmployeeAccount;



public class CreateEmployeeAccountController {
	private CreateEmployeeAccount model = new CreateEmployeeAccount();
			
	
		public void setModel( CreateEmployeeAccount model) {
			this.model = model;
		}
		

		public void setLogin(String password, String userName ) {
			LoginInfo login = new LoginInfo();
			login.setUserName(userName);
			login.setPassword(password);
			model.getAccount().setLogin(login);
		}
		
		public void setName(String firstName) {
			
			model.getAccount().setFirstName(firstName);
		}
		public void setLastName(String lastName) {
			
			model.getAccount().setFirstName(lastName);
		}
		
		public void setPhoneNumber(String phoneNumber) {
		
			model.getAccount().setPhoneNumber(phoneNumber);
		}
		public void setEmail(String email) {
			
			model.getAccount().setEmail(email);
		}
		public void setManager(boolean status) {
			
			model.getAccount().setManager(status);
		}
	
		public void setAccountNumber(Database dbase) {
			model.getAccount().setAccountNumber(dbase.getLastEmployeeAccountNumber().substring(0, 1) + Integer.parseInt(dbase.getLastEmployeeAccountNumber())+1);
			
		}
		
		public void setNullValues() {
			model.getAccount().setEmail(" ");
			model.getAccount().setPhoneNumber(" ");
			
			
		}


		public void addAccount(Database dbase) {
			dbase.addEmployeeAccount(model.getAccount());
			
		}
		public void editAccount(Database dbase) {
			dbase.updateEmployeeAccount(model.getAccount());
			
		}
		
		
		}

	
		
