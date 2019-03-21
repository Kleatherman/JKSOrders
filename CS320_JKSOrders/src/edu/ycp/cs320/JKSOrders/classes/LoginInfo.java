package edu.ycp.cs320.JKSOrders.classes;

public class LoginInfo{
	private String userName;
	private String password;
	
	public LoginInfo() {
		
	}

	/**
	 * @return username associated with login info
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName username to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return password associated with login info
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	/**
	 * This method is used to check the password & login accuracy
	 * @param obj object being tested against
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginInfo other = (LoginInfo) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}
	
	
	
}
