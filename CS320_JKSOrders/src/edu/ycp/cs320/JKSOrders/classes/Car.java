package edu.ycp.cs320.JKSOrders.classes;

public class Car {
	private String color;
	private String brand;
	private String type;
	private int year;
	
	public Car() {
		
	}

	/**
	 * @return color of car
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color color of car to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return brand of car
	 * 
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand brand of car to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return type of car
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type type (of car) to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return year of car
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	
	
}
