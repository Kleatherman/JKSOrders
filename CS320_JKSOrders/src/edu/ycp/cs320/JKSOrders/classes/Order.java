package edu.ycp.cs320.JKSOrders.classes;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Order {
	private ArrayList<Item> itemList;
	private double totalPrice;
	private Map<String, Integer> QuantityMap;
	private Account account;
	private String orderType;
	private String accountNum;
	private boolean complete;
	
	public Order(){
		account = new CustomerAccount();
		itemList= new ArrayList<Item>();
		QuantityMap= new TreeMap<String, Integer>();
		complete = false;
	}
	
	/**
	 * @return ArrayList of items in order
	 */
	public ArrayList<Item> getItemList() {
		return itemList;
	}
	/**
	 * @param itemlist ArrayList of items in order to set
	 */
	public void setItemList(ArrayList<Item> itemlist) {
		itemList = itemlist;
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
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public void addItem(Item item, int quantity) {
		itemList.add(item);
		QuantityMap.put(item.getUPC(), quantity);
	}
	
	public void setTotalPrice() {
		totalPrice = 0.0;
		for(Item item : itemList) {
			totalPrice += (item.getPrice()*QuantityMap.get(item.getUPC()));
		}
	}
	
	//This method is for setting the internal quantity integer of all the items prior to sending to cart page or check out page
	public void setItemQuantities() {
		for(Item item : itemList) {
				item.setNumInOrder(QuantityMap.get(item.getUPC()));
		}
		
	}

	public boolean isComplete() {
		return complete;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}
	
}
