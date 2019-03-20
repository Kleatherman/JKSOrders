package edu.ycp.cs320.JKSOrders.classes;

public class CustomerAccount extends Account{
	private String phoneNumber;
	private String email;
	private CreditCard creditCard;
	
	public CustomerAccount() {
		super();
	}
	
	/**
	 * @return Customers Phone Number
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
	 * @return email associated with account
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return Customers creditCard
	 */
	public CreditCard getCreditCard() {
		return creditCard;
	}
	
	/**
	 * @param creditCard CreditCard to set
	 */
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

}
