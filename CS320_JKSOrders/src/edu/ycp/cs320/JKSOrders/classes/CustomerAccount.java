package edu.ycp.cs320.JKSOrders.classes;

public class CustomerAccount extends Account{
	private String phoneNumber;
	private String email;
	private CreditCard creditCard;
	
	public CustomerAccount() {
		super();
	}
	
	/**
	 * @return
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	/**
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return
	 */
	public CreditCard getCreditCard() {
		return creditCard;
	}
	
	/**
	 * @param creditCard
	 */
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

}
