package edu.ycp.cs320.JKSOrders.classes;

import java.util.Map;

public class Catalog {
	private Item item; 
	private String UPC;
	private Map ItemMap;

	public Item getItem() {
	return item;
}

	public void setItem(Item item) {
	this.item = item;
}

	public String getUPC() {
	return UPC;
}

	public void setUPC(String uPC) {
	UPC = uPC;
}

	public Map getItemMap() {
	return ItemMap;
}

	public void setItemMap(Map itemMap) {
	ItemMap = itemMap;
}
 
}
