package edu.ycp.cs320.JKSOrders.classes;

public class PickUpInfo {
	private double time;
	private String StoreID;
	private Car car;
	
	
	public PickUpInfo(){
		car = new Car();
	}

	/**
	 * @return time order is to be picked up
	 */
	public double getTime() {
		return time;
	}
	/**
	 * @param time set time order is to be picked up
	 */
	public void setTime(double time) {
		this.time = time;
	}

	/**
	 * @return store ID of store order is to be picked up at
	 */
	public String getStoreID() {
		return StoreID;
	}

	/**
	 * @param storeID store ID of store order is to be picked up at to set
	 */
	public void setStoreID(String storeID) {
		StoreID = storeID;
	}

	/**
	 * @return Car class describing customers car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car Car class describing customers car to set
	 */
	public void setCar(Car car) {
		this.car = car;
	}
}
