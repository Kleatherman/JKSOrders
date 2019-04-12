package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;
import java.util.Map;

public class Order {
	private ArrayList<Item> Itemlist;
	private double totalPrice;
	private Map<String, Integer> QuantityMap;
	private boolean pickupOrder;
	private Account account;
	private String orderType;
	/**
	 * @return ArrayList of items in order
	 */
	public ArrayList<Item> getItemlist() {
		return Itemlist;
	}
	/**
	 * @param itemlist ArrayList of items in order to set
	 */
	public void setItemlist(ArrayList<Item> itemlist) {
		Itemlist = itemlist;
	}
	/**
	 * @return total price of order
	 */
	public double getTotalPrice() {
		return totalPrice;
	}
	/**
	 * @param totalPrice total price of order to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	/**
	 * @return quantity map of items in order
	 */
	public Map<String, Integer> getQuantityMap() {
		return QuantityMap;
	}
	/**
	 * @param quantityMap  quantity map of items in order to set 
	 */
	public void setQuantityMap(Map<String, Integer> quantityMap) {
		QuantityMap = quantityMap;
	}
	/**
	 * @return whether the order is a pickup order or an inventory order t/f
	 */
	public boolean isPickupOrder() {
		return pickupOrder;
	}
	/**
	 * @param pickupOrder sets whether item is a pickup order or inventory order
	 */
	public void setPickupOrder(boolean pickupOrder) {
		this.pickupOrder = pickupOrder;
	}
	/**
	 * @return returns pickup info for order
	 */
	public PickUpInfo getPickUpInfo() {
		return account.getPickUpInfo();
	}
	/**
	 * @return get name on account associated with order
	 */
	public String getName() {
		return account.getFirstName();
		//add lastname
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	
	
}
