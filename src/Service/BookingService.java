/*
 * @author Developer
 * @version 3
 */

package Service;

import java.util.LinkedList;
import java.util.Queue;

import model.Reservation;

public class BookingService {
	Queue<Reservation> bookingqueue=new LinkedList<>();
	
	//Adding the booking request to the queue
	public void addBooking(String guestName,String roomtype,int nights) {
		Reservation request=new Reservation(guestName,roomtype,nights);
		bookingqueue.offer(request);
		System.out.println("booking request added to the queue.");
	}
	
	//View queue
	public void viewqueue() {
		if(bookingqueue.isEmpty()) {
			System.out.println("No booking request");
			return;
		}
		System.out.println("\nBooking Queue:");
		for(Reservation r:bookingqueue) {
			System.out.println(r);
		}
	}
	
	//processing the next Request from the queue
	public void processNextRequest() {
		if(bookingqueue.isEmpty()) {
			System.out.println("No request to process.");
			return;
		}
		Reservation r=bookingqueue.poll();
		System.out.println("Processing booking for: ");
		System.out.println(r);
	}
}
