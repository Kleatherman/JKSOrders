package edu.ycp.cs320.JKSOrders.classes;

public class Item {
	private String itemName;
	private Integer numInInventory;
	private String UPC;
	private double price;
	private String description;
	private String location;
	private String Photo;
	private boolean visable;
	
	/**
	 * @return name of item
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName item name to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return Items UPC
	 */
	public String getUPC() {
		return UPC;
	}
	/**
	 * @param uPC UPC to set
	 */
	public void setUPC(String uPC) {
		UPC = uPC;
	}
	/**
	 * @return items price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return item description to set
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description item description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return item location in store, we will need to work on this...
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location item location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return photo (file name) of item
	 */
	public String getPhoto() {
		return Photo;
	}
	/**
	 * @param photo photo file name to set
	 */
	public void setPhoto(String photo) {
		Photo = photo;
	}
	/**
	 * @return is the item visible in the online store?
	 */
	public boolean isVisable() {
		return visable;
	}
	/**
	 * @param visable sets whether the item is visible in the store or not
	 */
	public void setVisable(boolean visable) {
		this.visable = visable;
	}
	
	public Integer getNumInInventory() {
		return numInInventory;
	}
	public void setNumInInventory(Integer numInInventory) {
		this.numInInventory = numInInventory;
	}
	
	
}
