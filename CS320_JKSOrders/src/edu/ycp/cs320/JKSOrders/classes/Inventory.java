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
	 * @return map of item quantities with their upcs as keys 
	 */
	public Map<String, Integer> getQuanityMap() {
		return quantityMap;
	}

	/**
	 * @param quanityMap quantityMap (map of item quantities with their upcs as keys) to set
	 */
	public void setQuanityMap(Map<String, Integer> quanityMap) {
		this.quantityMap = quanityMap;
	}

	/**
	 * @param item item to set
	 * @param i quantity to set
	 */
	public void setItemQuantity(String item, Integer i) {
		quantityMap.put(item, i);
	}
	
	/**
	 * @param less < x < greater
	 * @param greater items where the quantity is greater than x
	 * @param less	 items where the quantity is less than x		
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
