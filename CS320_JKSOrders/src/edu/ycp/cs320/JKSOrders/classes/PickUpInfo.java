package edu.ycp.cs320.JKSOrders.classes;

public class PickUpInfo {
	private double time;
	private String StoreID;
	private Car car;
	
	public PickUpInfo(){
		
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String getStoreID() {
		return StoreID;
	}

	public void setStoreID(String storeID) {
		StoreID = storeID;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
