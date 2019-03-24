package edu.ycp.cs320.JKSOrders.classes;

public class EmployeeAccount extends Account{
	private boolean manager;
	private Stats stats;
	
	public EmployeeAccount() {
		super();
	}

	/**
	 * @return true if the employee is a manager
	 */
	public boolean isManager() {
		return manager;
	}

	/**
	 * @param manager employee is manager t/f
	 */
	public void setManager(boolean manager) {
		this.manager = manager;
	}

	/**
	 * @return employee Stats 
	 */
	public Stats getStats() {
		return stats;
	}

	/**
	 * @param stats employee Stats to set
	 * 	 */
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	
}
