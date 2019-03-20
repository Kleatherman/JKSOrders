package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

	public class Inventory {
	private Map<String, Integer> quantityMap;

	public Inventory() {
		quantityMap = new TreeMap<String, Integer>();
	}
	/**
	 * @return
	 */
	public Map<String, Integer> getQuanityMap() {
		return quantityMap;
	}

	/**
	 * @param quanityMap
	 */
	public void setQuanityMap(Map<String, Integer> quanityMap) {
		this.quantityMap = quanityMap;
	}

	/**
	 * @param item
	 * @param i
	 */
	public void setItemQuantity(String item, Integer i) {
		quantityMap.put(item, i);
	}
	
	/**
	 * @param x
	 * @param greater
	 * @param less
	 */
	public void returnGreaterorLess(int x, ArrayList<String> greater, ArrayList<String> less) {
		Set upcs = quantityMap.keySet();
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
