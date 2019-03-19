package edu.ycp.cs320.JKSOrders.classes;

public class EmployeeAccount extends Account{
	private boolean manager;
	private Stats stats;
	
	public EmployeeAccount() {
		super();
	}

	/**
	 * @return
	 */
	public boolean isManager() {
		return manager;
	}

	/**
	 * @param manager
	 */
	public void setManager(boolean manager) {
		this.manager = manager;
	}

	/**
	 * @return
	 */
	public Stats getStats() {
		return stats;
	}

	/**
	 * @param stats
	 */
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	
}
