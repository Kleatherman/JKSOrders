package edu.ycp.cs320.JKSOrders.model;
import edu.ycp.cs320.JKSOrders.classes.Item;

public class EditItemModel {
	private Item item;
	boolean newItem;
	public EditItemModel() {
		item = new Item();	
		newItem = true;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public boolean isNewItem() {
		return newItem;
	}

	public void setNewItem(boolean newItem) {
		this.newItem = newItem;
	}
	
	
}
