package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;
	import java.util.Map;

	public class Inventory {
	private Map<String, Integer> quantityMap;

	public Inventory() {
		quantityMap = new Map<String, Integer>();
	}
	public Map<String, Integer> getQuanityMap() {
		return quantityMap;
	}

	public void setQuanityMap(Map<String, Integer> quanityMap) {
		this.quantityMap = quanityMap;
	}

	public void setItemQuantity(String item, Integer i) {
		quantityMap.put(item, i);
	}
	
	public ArrayList<String> returnGreaterorLess(int x, ArrayList<String> greater, ArrayList<String> less) {
		return null;
	}
}
