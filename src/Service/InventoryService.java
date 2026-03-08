/*
 * @author Developer
 * @version 4
 */

package Service;

import java.util.HashMap;

public class InventoryService {
	HashMap<String,Integer> roomCount=new HashMap<>();
	HashMap<String,Double> roomPrice=new HashMap<>();
	HashMap<String,String> roomAmenities=new HashMap<>();
	
	//Add Rooms
	public void addRoom(String roomType,int count,double price,String amenities) {
		roomCount.put(roomType, count);
		roomPrice.put(roomType, price);
		roomAmenities.put(roomType,amenities);
		System.out.println("Room added Successfully");
	}
	
	//Update Room count
	public void updateCount(String roomType,int newcount) {
		if(roomCount.containsKey(roomType)) {
			roomCount.put(roomType,newcount);
			System.out.println("Room count updated.");
		}
		else {
			System.out.println("Room type not found");
		}
		
	}
	
	//Update price
	public void updatePrice(String roomType,double price) {
		if(roomPrice.containsKey(roomType)) {
			roomPrice.put(roomType,price);
			System.out.println("Room price updated.");
		}
		else {
			System.out.println("Room type not found");
		}
		
	}
	
	//Check Room Availability
	public int checkAvailability(String roomType) {
		return roomCount.getOrDefault(roomType, 0);
	}
	
	//Display Inventory
	public void displayInventory() {
		System.out.println("Room Inventory:");
		for(String type:roomCount.keySet()) {
			int count=roomCount.get(type);
			double price=roomPrice.get(type);
			System.out.println(type+" | Available: "+count+" | Price: "+price);
		}
	}
	
	//Decrement Room After Booking
	public void decrementRoom(String type) {
		if(roomCount.containsKey(type)) {
			int count=roomCount.get(type);
			if(count>0) {
				roomCount.put(type, count-1);
			}
		}
	}
	
}
