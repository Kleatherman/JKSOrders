package edu.ycp.cs320.JKSOrders.controller;

import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.model.WorkPage;

public class WorkPageController {
	
	WorkPage model= new WorkPage();
	
	public void setModel(WorkPage model) {
		this.model=model;
	}
	public void loadUpCustomerAccount(Database dbase, String accountid) {
		model.setCustomerAccount(dbase.getCustomerAccount(accountid));
	}
	public void loadUpEmployeeAccount(Database dbase, String accountid) {
		model.setEmployeeAccount(dbase.getEmployeeAccount(accountid));
	}
}
