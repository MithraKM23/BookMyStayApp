/*
 * @author Developer
 * @version 1
 */

package model;

public class Room {
	private String roomType;
	private int count;
	private double price;
	
	//Constructor for the fields
	public Room(String roomType, int count, double price) {
		this.roomType = roomType;
		this.count = count;
		this.price = price;
	}
	
	//Getter methods
	public String getRoomType() {
		return roomType;
	}
	public int getCount() {
		return count;
	}
	public double getPrice() {
		return price;
	}
	
	
}
