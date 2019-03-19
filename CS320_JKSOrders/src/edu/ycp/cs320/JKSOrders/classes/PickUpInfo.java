package edu.ycp.cs320.JKSOrders.classes;

public class PickUpInfo {
	private double time;
	private String StoreID;
	private Car car;
	
	/**
	 * 
	 */
	public PickUpInfo(){
		
	}

	/**
	 * @return
	 */
	public double getTime() {
		return time;
	}

	/**
	 * @param time
	 */
	public void setTime(double time) {
		this.time = time;
	}

	/**
	 * @return
	 */
	public String getStoreID() {
		return StoreID;
	}

	/**
	 * @param storeID
	 */
	public void setStoreID(String storeID) {
		StoreID = storeID;
	}

	/**
	 * @return
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car
	 */
	public void setCar(Car car) {
		this.car = car;
	}
}
