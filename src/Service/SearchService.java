/*
 * @author Developer
 * @version 2
 */

package Service;

public class SearchService {
	InventoryService inventory;

	//Constructor
	public SearchService(InventoryService inventory) {
		this.inventory = inventory;
	}
	
	//Display all the available rooms for guests
	public void displayAvailableRooms() {
		System.out.println("Available Rooms:");
		for(String type:inventory.roomCount.keySet()) {
			int count=inventory.roomCount.get(type);
			if(count>0) {
				double price=inventory.roomPrice.get(type);
				String amenities=inventory.roomAmenities.get(type);
				System.out.println(type+" | Price: "+price+" | Available: "+count+" | Amenities; "+amenities);
			}
		}
	}
	
	//Display the specific room for the guest
	public void SearchRoom(String type) {
		if(!inventory.roomCount.containsKey(type)) {
			System.out.println("Room not found");
		}
		else {
		int count=inventory.roomCount.get(type);
		if(count==0) {
			System.out.println("No Rooms Available");
		}
		if(count>0) {
		double price=inventory.roomPrice.get(type);
		String amenity=inventory.roomAmenities.get(type);
		System.out.println("Room Found!");
		System.out.println("Type: "+type);
		System.out.println("price: "+price);
		System.out.println("Available: "+count);
		System.out.println("Amenities: "+amenity);
		}
	}
	}
}
