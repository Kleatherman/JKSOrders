package edu.ycp.cs320.JKSOrders.classes;

/* The Stats class contains data pertaining to employee efficiency
 * It is accessed
 */
public class Stats {
	private double timeTaken;
	private int numitemsProcessed;
	private double itemsperMin;
	
	
	/**
	 * @return
	 */
	public double getTimeTaken() {
		return timeTaken;
	}
	/**
	 * @param timeTaken
	 */
	public void setTimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}
	/**
	 * @return
	 */
	public int getNumitemsProcessed() {
		return numitemsProcessed;
	}
	/**
	 * @param numitemsProcessed
	 */
	public void setNumitemsProcessed(int numitemsProcessed) {
		this.numitemsProcessed = numitemsProcessed;
	}
	/**
	 * @return
	 */
	public double getItemsperMin() {
		return itemsperMin;
	}
	/**
	 * @param itemsperMin
	 */
	public void setItemsperMin(double itemsperMin) {
		this.itemsperMin = itemsperMin;
	}
	
}
