package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;


public class Notification {
	private String message;
	private ArrayList<String> destinationNames;
	private Boolean urgency;
	private String notificationID;
	private String sourceAccountNumber;
	
	public Notification() {
		destinationNames = new ArrayList<String>();
	}

	/**
	 * @return Notification message 
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message Notification message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	public String getSourceAccountNumber() {
		return sourceAccountNumber;
	}

	public void setSourceAccountNumber(String sourceAccountNumber) {
		this.sourceAccountNumber = sourceAccountNumber;
	}

	/**
	 * @return An ArrrayList of item destinations
	 */
	public ArrayList<String> getDestination() {
		return destinationNames;
	}

	/**
	 * @param destination ArrayList of Destinations to set
	 */
	public void setDestination(ArrayList<String> destination) {
		this.destinationNames = destination;
	}

	/**
	 * @return urgency of the notification
	 */
	public Boolean getUrgency() {
		if (urgency != null) {
		return urgency;
		
		}
		
		else {
		char[] number = this.getNotificationID().toCharArray();
		if(number[0]=='U') {
			return true;
		}
		else
			return false;
	}
		}

	/**
	 * @param urgency urgency to set
	 */
	public void setUrgency(Boolean urgency) {
		this.urgency = urgency;
	}
	
	/**
	 * @param name destination name to remove
	 */
	public void removeDestinationName(String name) {
		destinationNames.remove(name);
	}
	
	/**
	 * @param name destination name to add
	 */
	public void addDestinationName(String name) {
		destinationNames.add(name);
	}

	public String getNotificationID() {
		return notificationID;
	}

	public void setNotificationID(String notificationID) {
		this.notificationID = notificationID;
	}
}
