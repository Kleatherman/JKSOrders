package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;
import java.util.Map;

public class Order {
	private ArrayList<Item> Itemlist;
	private double totalPrice;
	private Map<String, Integer> QuantityMap;
	private boolean pickupOrder;
	private Account account;
	/**
	 * @return
	 */
	public ArrayList<Item> getItemlist() {
		return Itemlist;
	}
	/**
	 * @param itemlist
	 */
	public void setItemlist(ArrayList<Item> itemlist) {
		Itemlist = itemlist;
	}
	/**
	 * @return
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * @return
	 */
	public Map<String, Integer> getQuantityMap() {
		return QuantityMap;
	}
	/**
	 * @param quantityMap
	 */
	public void setQuantityMap(Map<String, Integer> quantityMap) {
		QuantityMap = quantityMap;
	}
	/**
	 * @return
	 */
	public boolean isPickupOrder() {
		return pickupOrder;
	}
	/**
	 * @param pickupOrder
	 */
	public void setPickupOrder(boolean pickupOrder) {
		this.pickupOrder = pickupOrder;
	}
	/**
	 * @return
	 */
	public PickUpInfo getPickUpInfo() {
		return account.getPickUpInfo();
	}
	/**
	 * @return
	 */
	public String getName() {
		return account.getName();
	}
	
	
}
