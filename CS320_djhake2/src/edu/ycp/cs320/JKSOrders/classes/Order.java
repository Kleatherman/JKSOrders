package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;
import java.util.Map;

public class Order {
	private ArrayList<Item> Itemlist;
	private double totalPrice;
	private Map<String, Integer> QuantityMap;
	private boolean pickupOrder;
	private Account account;
	public ArrayList<Item> getItemlist() {
		return Itemlist;
	}
	public void setItemlist(ArrayList<Item> itemlist) {
		Itemlist = itemlist;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Map<String, Integer> getQuantityMap() {
		return QuantityMap;
	}
	public void setQuantityMap(Map<String, Integer> quantityMap) {
		QuantityMap = quantityMap;
	}
	public boolean isPickupOrder() {
		return pickupOrder;
	}
	public void setPickupOrder(boolean pickupOrder) {
		this.pickupOrder = pickupOrder;
	}
	public PickUpInfo getPickUpInfo() {
		return account.getPickUpInfo();
	}
	public String getName() {
		return account.getName();
	}
	
	
}
