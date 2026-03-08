/*
 * @author Develloper
 * @version 5
 */

package model;

public class Services {
	private String name;
	private double price;
	
	//Constructor
	public Services(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
	
	//Returning the services with price
	public String toString() {
		return name+" - Rs."+price;
	}
	
}
