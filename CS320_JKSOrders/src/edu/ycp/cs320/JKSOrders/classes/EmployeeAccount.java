package edu.ycp.cs320.JKSOrders.classes;

public class EmployeeAccount extends Account{
	private boolean manager;
	private Stats stats;
	
	public EmployeeAccount() {
		super();
	}

	public boolean isManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

	public Stats getStats() {
		return stats;
	}

	public void setStats(Stats stats) {
		this.stats = stats;
	}
	
	
}
