package edu.ycp.cs320.JKSOrders.controller;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.Account;
import edu.ycp.cs320.JKSOrders.classes.Notification;
import edu.ycp.cs320.JKSOrders.database.Database;
import edu.ycp.cs320.JKSOrders.database.InitDatabase;
import edu.ycp.cs320.JKSOrders.model.EditNotificationModel;

public class EditNotificationController {
	EditNotificationModel model;
	
	public EditNotificationController(){
		model = new EditNotificationModel();
	}
	
	public void setModelNotification(Notification notify) {
		model.setNotification(notify);
	}
	
	public void setDestinationNames(Database db) {
		ArrayList<String> names = new ArrayList<String>();
		for(String accountNumber : model.getNotify().getDestination()) {
			Account account = db.getAccount(accountNumber);
			names.add(account.getFirstName()+" "+account.getLastName());
		}
		model.setDestinationNames(names);
	}
	
	public void setErrorMessage(String message) {
		model.setErrorMessage(message);
	}

	public void setModel(EditNotificationModel editModel) {
		this.model = editModel;
	}
	
	public void setModelAllNames(ArrayList<String> allNames) {
		model.setAllNames(allNames);
	}
}
