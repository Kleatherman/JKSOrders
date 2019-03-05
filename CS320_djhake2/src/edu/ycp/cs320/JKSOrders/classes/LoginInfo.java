package edu.ycp.cs320.JKSOrders.classes;

public class LoginInfo implements Comparable{
	private String userName;
	private String password;
	
	public LoginInfo() {
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int compareTo(LoginInfo login) {
		//TO-DO: Implement this
		return 0;
	}
	
	
}
