package edu.ycp.cs320.JKSOrders.classes;

public class CreditCard {
	private String accountNumber;
	private String CVC;
	private String nameOnCard;
	private String expirationDate;
	
	public CreditCard() {
		super();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCVC() {
		return CVC;
	}

	public void setCVC(String cVC) {
		CVC = cVC;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
