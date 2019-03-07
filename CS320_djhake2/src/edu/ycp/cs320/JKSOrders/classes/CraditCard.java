package edu.ycp.cs320.JKSOrders.classes;

public class CraditCard {
	private String accountNumber;
	private String CVC;
	private String nameOnCard;
	private String expirationgDate;
	
	public CraditCard() {
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

	public String getExpirationgDate() {
		return expirationgDate;
	}

	public void setExpirationgDate(String expirationgDate) {
		this.expirationgDate = expirationgDate;
	}
	
	
}
