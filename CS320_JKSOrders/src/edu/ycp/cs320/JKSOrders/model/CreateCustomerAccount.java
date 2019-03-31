package edu.ycp.cs320.JKSOrders.model;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.CustomerAccount;
import edu.ycp.cs320.JKSOrders.classes.LoginInfo;

public class CreateCustomerAccount {
	
	private CustomerAccount account= new CustomerAccount();
	
	public CreateCustomerAccount() {
		
	}
	
	public String getPassword() {
		return account.getLogin().getPassword();
	}
	public void setPassword(String password) {
		account.getLogin().setPassword(password);
		}
	
	public void setUsername(String Username) {
		LoginInfo login= new LoginInfo();
		login.setUserName(Username);
		account.setLogin(login);
	}
	public void setPhoneNumber(String Phone) {
		
	}
	public Account getAccount() {
		return account; 
	}

}
