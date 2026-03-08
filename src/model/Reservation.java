/*
 * @authore Developer
 * @version 3
 */


//Reservation class for booking the reservation
package model;

public class Reservation {
	 String guestName;
	 String roomType;
	 int nights;
	 
	 //Constructor
	 public Reservation(String name, String roomType, int nights) {
		this.guestName = name;
		this.roomType = roomType;
		this.nights = nights;
	 }
	 
	 public String getGuestName() {
		return guestName;
	}

	 public String getRoomType() {
		 return roomType;
	 }

	 public int getNights() {
		 return nights;
	 }

	 //Returning the Guest Details in a readable format
	 public String toString() {
		 return "Guest: "+guestName+" | Room: "+roomType+" | Nights: "+nights;
	 }
	 
}
