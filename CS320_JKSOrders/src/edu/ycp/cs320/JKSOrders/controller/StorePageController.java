package edu.ycp.cs320.JKSOrders.controller;

import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.model.StorePage;

public class StorePageController {
	
	private StorePage model = new StorePage();
	
	public void setModel( StorePage model) {
		this.model= model;
	}
	
	public void loadUpCustomerAccount(Database dbase, String accountid) {
		model.setCustomerAccount(dbase.getCustomerAccount(accountid));
	}
	public void loadUpEmployeeAccount(Database dbase, String accountid) {
		model.setEmployeeAccount(dbase.getEmployeeAccount(accountid));
	}
}
