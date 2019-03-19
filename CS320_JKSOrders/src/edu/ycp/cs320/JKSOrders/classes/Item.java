package edu.ycp.cs320.JKSOrders.classes;

public class Item {
	private String itemName;
	private String UPC;
	private double price;
	private String description;
	private String location;
	private String Photo;
	private boolean visable;
	
	/**
	 * @return
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return
	 */
	public String getUPC() {
		return UPC;
	}
	/**
	 * @param uPC
	 */
	public void setUPC(String uPC) {
		UPC = uPC;
	}
	/**
	 * @return
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return
	 */
	public String getPhoto() {
		return Photo;
	}
	/**
	 * @param photo
	 */
	public void setPhoto(String photo) {
		Photo = photo;
	}
	/**
	 * @return
	 */
	public boolean isVisable() {
		return visable;
	}
	/**
	 * @param visable
	 */
	public void setVisable(boolean visable) {
		this.visable = visable;
	}
	
	
}
