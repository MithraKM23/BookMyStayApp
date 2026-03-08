/*
 * @author Developer
 * @version 4
 */

package Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import model.Reservation;

public class BookingAllocation {
	Set<String> bookedRoomIds=new HashSet<>();
	HashMap<String,Set<String>> roomAssignments = new HashMap<>();
	
	InventoryService inventory;
	
	//Constructor
	public BookingAllocation(InventoryService inventory) {
		this.inventory=inventory;
	}
	
	//Confirming the reservation from the queue
	public void confirmReservation(Reservation request) {
		String roomType=request.getRoomType();
		int available=inventory.roomCount.get(roomType);
		if(available<=0) {
			System.out.println("No rooms available for "+roomType);
			return;
		}
		String roomId=generateRoomId(roomType);
		bookedRoomIds.add(roomId);
		roomAssignments.computeIfAbsent(roomType, k->new HashSet<>()).add(roomId);
		inventory.decrementRoom(roomType);
		System.out.println("Booking Confirmed");
		System.out.println("Guest: "+request.getGuestName());
		System.out.println("Room Id: "+roomId);
	}
	
	//Generating the room Id after reservation
	private String generateRoomId(String roomType) {
		int number=bookedRoomIds.size()+1;
		return roomType.substring(0,1).toUpperCase()+number;
	}
}
