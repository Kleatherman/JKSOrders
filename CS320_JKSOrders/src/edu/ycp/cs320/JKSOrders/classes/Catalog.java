package edu.ycp.cs320.JKSOrders.classes;

import java.util.Map;
import java.util.TreeMap;

public class Catalog {
	private Map<String, Item> ItemMap;

	public Catalog() {
		ItemMap = new TreeMap<String, Item>();
	}
	/**
	 * @param upc
	 * @return
	 */
	public Item getItem(String upc) {
		if(ItemMap.containsKey(upc)) {
			return ItemMap.get(upc);
		}
		return null;
	}

	/**
	 * @param item
	 */
	public void setItem(Item item) {
		ItemMap.put(item.getUPC(), item);
	}

	/**
	 * @return
	 */
	public Map<String, Item> getItemMap() {
		return ItemMap;
	}

	/**
	 * @param itemMap
	 */
	public void setItemMap(Map<String, Item> itemMap) {
		ItemMap = itemMap;
	}
	
	/**
	 * @param item
	 */
	public void setItemKey(Item item) {
		ItemMap.put(item.getUPC(), item);
	}
}
