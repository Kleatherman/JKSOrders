package edu.ycp.cs320.JKSOrders.controller;

import java.util.ArrayList;

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
	
	public void setDestinationNames() {
		ArrayList<String> names = new ArrayList<String>();
		Database db = InitDatabase.init();
		for(String accountNumber : model.getNotify().getDestination()) {
			names.add(db.getAccount(accountNumber).getName());
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
