package edu.ycp.cs320.JKSOrders.model;


import edu.ycp.cs320.JKSOrders.classes.EmployeeAccount;

public class EmployeeForgotLogin {
	private EmployeeAccount account = new EmployeeAccount();
	
	public EmployeeForgotLogin() {
		
	}
	
	public String getPassword() {
		return account.getLogin().getPassword();
	}
	
	public void setUsername(String Username) {
		
	}
	public void setPhoneNumber(String Phone) {
		
	}

}
