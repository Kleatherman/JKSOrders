package edu.ycp.cs320.JKSOrders.classes;

public class CreditCard {
	private String accountNumber;
	private String CVC;
	private String nameOnCard;
	private String expirationDate;
	
	public CreditCard() {
		super();
	}

	/**
	 * @return account number associated with account
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber Credit Card accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return CVC associated with creditcard
	 */
	public String getCVC() {
		return CVC;
	}

	/**
	 * @param cVC CVC to cet
	 */
	public void setCVC(String cVC) {
		CVC = cVC;
	}

	/**
	 * @return Name on card
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * @param nameOnCard name on card to set
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	/**
	 * @return expiration date of credit card
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate expiration date to set
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
