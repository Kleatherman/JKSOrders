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
	 * @return
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return
	 */
	public String getCVC() {
		return CVC;
	}

	/**
	 * @param cVC
	 */
	public void setCVC(String cVC) {
		CVC = cVC;
	}

	/**
	 * @return
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/**
	 * @param nameOnCard
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	/**
	 * @return
	 */
	public String getExpirationDate() {
		return expirationDate;
	}

	/**
	 * @param expirationDate
	 */
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	
}
