package edu.ycp.cs320.JKSOrders.classes;

public class Item {
	private String itemName;
	private String UPC;
	private double price;
	private String description;
	private String location;
	private String Photo;
	private boolean visable;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getUPC() {
		return UPC;
	}
	public void setUPC(String uPC) {
		UPC = uPC;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public boolean isVisable() {
		return visable;
	}
	public void setVisable(boolean visable) {
		this.visable = visable;
	}
	
	
}
