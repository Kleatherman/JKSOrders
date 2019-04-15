package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
	 *	Sets the item key
	 * @param item
	 */
	public void setItemKey(Item item) {
		ItemMap.put(item.getUPC(), item);
	}
	
	public void returnGreaterorLess(int x, ArrayList<String> greater, ArrayList<String> less) {
		Set<String> upcs = quantityMap.keySet();
		Iterator<String> i = upcs.iterator();
		while(i.hasNext()){
			String item = i.next();
			if(quantityMap.get(item)<x) {
				less.add(item);
			}
			else
				greater.add(item);
		}

}

}