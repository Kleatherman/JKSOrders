package edu.ycp.cs320.JKSOrders.classes;

public abstract class Account {
	private String name;
	private String accountNumber;
	private LoginInfo login;
	private PickUpInfo pickUpInfo;
	
	public Account() {
	
	}
	
	public void createOrder() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public LoginInfo getLogin() {
		return login;
	}

	public void setLogin(LoginInfo login) {
		this.login = login;
	}

	public PickUpInfo getPickUpInfo() {
		return pickUpInfo;
	}

	public void setPickUpInfo(PickUpInfo pickUpInfo) {
		this.pickUpInfo = pickUpInfo;
	}
	

}
