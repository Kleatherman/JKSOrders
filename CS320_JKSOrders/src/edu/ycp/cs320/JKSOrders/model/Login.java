package edu.ycp.cs320.JKSOrders.model;

import edu.ycp.cs320.JKSOrders.classes.LoginInfo;

public class Login {
	
	private LoginInfo loginInfo = new LoginInfo();
	
	
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	
	public Login() {
		
	}
	
	public String getPassword() {
		return loginInfo.getPassword();
	}
	
	public String getUserName() {
		return loginInfo.getUserName();
	}
	
	public void setPassword(String password) {
		loginInfo.setPassword(password);
		}
	
	public void setUserName(String Username) {
		loginInfo.setUserName(Username);
	
	}

}