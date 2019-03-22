package edu.ycp.cs320.JKSOrders.classes;

/* The Stats class contains data pertaining to employee efficiency
 * It is accessed
 */
public class Stats {
	private double timeTaken;
	private int numitemsProcessed;
	private double itemsperMin;
	
	
	/**
	 * @return time taken to process a task
	 */
	public double getTimeTaken() {
		return timeTaken;
	}
	/**
	 * @param timeTaken time taken to process task to set
	 */
	public void setTimeTaken(double timeTaken) {
		this.timeTaken = timeTaken;
	}
	/**
	 * @return number of items processed 
	 */
	public int getNumitemsProcessed() {
		return numitemsProcessed;
	}
	/**
	 * @param numitemsProcessed number of items processed to set
	 */
	public void setNumitemsProcessed(int numitemsProcessed) {
		this.numitemsProcessed = numitemsProcessed;
	}
	/**
	 * @return items processed per minute
	 */
	public double getItemsperMin() {
		return itemsperMin;
	}
	/**
	 * @param itemsperMin items processed per minute to set
	 */
	public void setItemsperMin(double itemsperMin) {
		this.itemsperMin = itemsperMin;
	}
	
}
