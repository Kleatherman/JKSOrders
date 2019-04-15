package edu.ycp.cs320.JKSOrders.classes;

public class CustomerAccount extends Account{
	
	private CreditCard creditCard;
	
	public CustomerAccount() {
		super();
		creditCard = new CreditCard();
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
