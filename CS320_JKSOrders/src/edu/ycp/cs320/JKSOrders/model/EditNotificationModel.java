package edu.ycp.cs320.JKSOrders.model;

import java.util.ArrayList;

import edu.ycp.cs320.JKSOrders.classes.Notification;

public class EditNotificationModel {
	private Notification notify;
	private ArrayList<String> destinationNames;
	private String errorMessage;
	private ArrayList<String> allNames;
	
	public EditNotificationModel() {
		notify = new Notification();
		destinationNames = new ArrayList<String>();
		allNames = new ArrayList<String>();		
	}
	
	public void setNotification(Notification notify) {
		this.notify = notify;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public void setDestinationNames(ArrayList<String> names) {
		this.destinationNames = names;
	}
	
	public Notification getNotify() {
		return notify;
	}
	
	public ArrayList<String> getDestinationNames() {
		return destinationNames;
	}

	public ArrayList<String> getAllNames() {
		return allNames;
	}

	public void setAllNames(ArrayList<String> allNames) {
		this.allNames = allNames;
	}
	
	
}
