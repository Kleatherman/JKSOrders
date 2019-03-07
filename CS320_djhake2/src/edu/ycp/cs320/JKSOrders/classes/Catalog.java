package edu.ycp.cs320.JKSOrders.classes;

import java.util.Map;

public class Catalog {
	private Item item; 
	private String UPC;
	private Map<String, Item> ItemMap;

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

	public Map<String, Item> getItemMap() {
		return ItemMap;
	}

	public void setItemMap(Map<String, Item> itemMap) {
		ItemMap = itemMap;
	}
	
	public void setItemKey(Item item) {
		ItemMap.put(item.getUPC(), item);
	}
}
