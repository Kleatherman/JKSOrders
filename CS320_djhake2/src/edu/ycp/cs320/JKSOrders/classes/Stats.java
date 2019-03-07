package edu.ycp.cs320.JKSOrders.classes;

/* The Stats class contains data pertaining to employee efficiency
 * It is accessed
 */
public class Stats {
	private double timeTaken;
	private int numitemsProcessed;
	private double itemsperMin;
	
	
	public double getTimeTaken() {
		return timeTaken;
	}
	public void setTimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}
	public int getNumitemsProcessed() {
		return numitemsProcessed;
	}
	public void setNumitemsProcessed(int numitemsProcessed) {
		this.numitemsProcessed = numitemsProcessed;
	}
	public double getItemsperMin() {
		return itemsperMin;
	}
	public void setItemsperMin(double itemsperMin) {
		this.itemsperMin = itemsperMin;
	}
	
}
