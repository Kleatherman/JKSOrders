package edu.ycp.cs320.JKSOrders.classes;

public class CustomerAccount extends Account{
	private String phoneNumber;
	private String email;
	private CraditCard creditCard;
	
	public CustomerAccount() {
		super();
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public CraditCard getCreditCard() {
		return creditCard;
	}
	
	public void setCreditCard(CraditCard creditCard) {
		this.creditCard = creditCard;
	}

}
