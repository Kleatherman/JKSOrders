package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;

public class Notification {
	private String message;
	private ArrayList<String> destinationNames;
	private Boolean urgency;
	
	public Notification() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ArrayList<String> getDestination() {
		return destinationNames;
	}

	public void setDestination(ArrayList<String> destination) {
		this.destinationNames = destination;
	}

	public Boolean getUrgency() {
		return urgency;
	}

	public void setUrgency(Boolean urgency) {
		this.urgency = urgency;
	}
	
	public void removeDestinationName(String name) {
		
	}
	
	public void addDestinationName(String name) {
		destinationNames.add(name);
	}
}
