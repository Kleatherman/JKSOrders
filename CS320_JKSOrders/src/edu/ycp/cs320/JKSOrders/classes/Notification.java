package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;

public class Notification {
	private String message;
	private ArrayList<String> destinationNames;
	private Boolean urgency;
	
	public Notification() {
		
	}

	/**
	 * @return
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return
	 */
	public ArrayList<String> getDestination() {
		return destinationNames;
	}

	/**
	 * @param destination
	 */
	public void setDestination(ArrayList<String> destination) {
		this.destinationNames = destination;
	}

	/**
	 * @return
	 */
	public Boolean getUrgency() {
		return urgency;
	}

	/**
	 * @param urgency
	 */
	public void setUrgency(Boolean urgency) {
		this.urgency = urgency;
	}
	
	/**
	 * @param name
	 */
	public void removeDestinationName(String name) {
		
	}
	
	/**
	 * @param name
	 */
	public void addDestinationName(String name) {
		destinationNames.add(name);
	}
}
