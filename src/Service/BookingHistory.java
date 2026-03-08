/*
 * @author Developer
 * @version 6
 */

package Service;

import java.util.ArrayList;
import java.util.List;

import model.Reservation;

public class BookingHistory {
	List<Reservation> bookingHistory=new ArrayList<>();
	
	//Adding reservation to the history
	public void addReservation(Reservation reservation) {
		bookingHistory.add(reservation);
		System.out.println("Reservation added to History");
	}
	
	//View all the reservations from the history
	public void viewAllReservations() {
		if(bookingHistory.isEmpty()) {
			System.out.println("No Bookings yet.");
			return;
		}
		for(Reservation r:bookingHistory) {
			System.out.println(r);
		}
	}
	
	//Generating report
	public void generaterereport() {
		System.out.println("Total Booking: "+bookingHistory.size());
	}
}
