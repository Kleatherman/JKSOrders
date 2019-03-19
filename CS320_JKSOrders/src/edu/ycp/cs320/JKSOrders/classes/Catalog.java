package edu.ycp.cs320.JKSOrders.classes;

import java.util.Map;
import java.util.TreeMap;

public class Catalog {
	private Map<String, Item> ItemMap;

	public Catalog() {
		ItemMap = new TreeMap<String, Item>();
	}
	/**
	 * @param upc key assigned to i
	 * @return item with given upc
	 */
	public Item getItem(String upc) {
		if(ItemMap.containsKey(upc)) {
			return ItemMap.get(upc);
		}
		return null;
	}

	/**
	 * @param item item to set
	 */
	public void setItem(Item item) {
		ItemMap.put(item.getUPC(), item);
	}

	/**
	 * @return A Map of Items, with a upc as each item key
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
