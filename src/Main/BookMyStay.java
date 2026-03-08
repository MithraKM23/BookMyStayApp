/*
 * @author Developer
 * @version 6
 */

package Main;

import java.util.Scanner;

import Service.AddOnServiceManager;
import Service.BookingAllocation;
import Service.BookingHistory;
import Service.BookingService;
import Service.InventoryService;
import Service.SearchService;
import model.Services;

public class BookMyStay {
	static BookingService booking=new BookingService();
	static InventoryService inventory=new InventoryService();
	static SearchService search=new SearchService(inventory);
	static BookingHistory history=new BookingHistory();
	static BookingAllocation bookingallocation=new BookingAllocation(inventory,history);
	static AddOnServiceManager addOnService=new AddOnServiceManager();
	
	//Main method
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		//Getting input as manager or Guest
		int role;
		do {
			
			System.out.println("===bookMyStay System===");
			System.out.println("1.Manager");
			System.out.println("2. Guest");
			System.out.println("3. Exit");
			role=sc.nextInt();
			if(role==1) {
				managermenu(sc,inventory);
			}
			else if(role==2) {
				guestmenu(sc,search);
			}
		}while(role!=3);
}
	
	//Manager Operations
	public static void managermenu(Scanner sc,InventoryService inventory) {
		int choice;
		do {
			System.out.println("====BookMyStay Inventory Menu===");
			System.out.println("1. Add Room");
			System.out.println("2. Update Room count");
			System.out.println("3. Update Room Price");
			System.out.println("4. Check Room Availability");
			System.out.println("5. Display Inventory");
			System.out.println("6. View booking queue");
			System.out.println("7. Process Next Booking");
			System.out.println("8. View Booking History");
			System.out.println("9. Generate report");
			System.out.println("10. exit");
			
			System.out.print("Enter your Choice: ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Room type:");
				String roomType=sc.next();
				System.out.println("Enter room count:");
				int count=sc.nextInt();
				System.out.println("Enter room price:");
				double price=sc.nextDouble();
				System.out.println("Enter Amenities:");
				String amenity=sc.next();
				inventory.addRoom(roomType, count, price,amenity);
				break;
			case 2:
				System.out.println("Enter room type:");
				roomType=sc.next();
				System.out.println("Enter new count:");
				count=sc.nextInt();
				inventory.updateCount(roomType, count);
				break;
			case 3:
				System.out.println("Enter room type:");
				roomType=sc.next();
				System.out.println("Enter new price:");
				price=sc.nextDouble();
				inventory.updatePrice(roomType, price);
				break;
			case 4:
				System.out.println("Enter room type:");
				roomType=sc.next();
				inventory.checkAvailability(roomType);
				break;
			case 5:
				inventory.displayInventory();
				break;
			case 6:
				booking.viewqueue();
				break;
			case 7:
				booking.processNextRequest(bookingallocation);
				break;
			case 8:
				history.viewAllReservations();
				break;
			case 9:
				history.generaterereport();
				break;
			case 10:
				System.out.println("Exiting System");
				break;
			default:
				System.out.println("Invalid choice");
				
			}
		}while(choice!=10);
	}
	
	//Guest Operations
	public static void guestmenu(Scanner sc,SearchService search) {
		int choice;
		do {
			System.out.println("===Guest Menu===");
			System.out.println("1. View Available Rooms");
			System.out.println("2. Search Rooms");
			System.out.println("3. Request Booking");
			System.out.println("4. Add Services");
			System.out.println("5. View Sevices");
			System.out.println("6. Back");
			System.out.print("Enter your choice:");
			choice=sc.nextInt();
			switch(choice) {
			case 1 :
				search.displayAvailableRooms();
				break;
			case 2:
				System.out.println("Enter Room type: ");
				String roomtype=sc.next();
				search.SearchRoom(roomtype);
				break;
			case 3:
				requestBooking();
				break;
			case 4:
				System.out.println("Enter Reservation Id:");
				String id=sc.next();
				System.out.println("1. Breakfast");
				System.out.println("2. Spa");
				System.out.println("3. Pickup");
				int serviceChoice=sc.nextInt();
				if(serviceChoice==1) {
					addOnService.addService(id, new Services("Breakfast",500));
				}
				else if(serviceChoice==2) {
					addOnService.addService(id, new Services("Spa",2000));
				}
				else if(serviceChoice==3) {
					addOnService.addService(id, new Services("Pickup",1000));
				}
				break;
			case 5:
				System.out.println("Enter Reservation Id:");
				String id1=sc.next();
				addOnService.viewServices(id1);
				break;
			case 6:
				System.out.println("Exiting...");
			default:
				break;
			}
			}while(choice!=6);
	}
	
	//method for booking room
	public static void requestBooking() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Guest name:");
		String name=sc.next();
		System.out.println("Enter room type:");
		String type=sc.next();
		System.out.println("Enter nights:");
		int nights=sc.nextInt();
		booking.addBooking(name, type, nights);
		
	}

}
