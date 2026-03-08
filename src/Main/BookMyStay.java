/*
 * @author Developer
 * @version 3
 */

package Main;

import java.util.Scanner;

import Service.BookingService;
import Service.InventoryService;
import Service.SearchService;

public class BookMyStay {
	static BookingService booking=new BookingService();
	
	//Main method
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		InventoryService inventory=new InventoryService();
		SearchService search=new SearchService(inventory);
		
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
			System.out.println("8. exit");
			
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
				booking.processNextRequest();
				break;
			case 8:
				System.out.println("Exiting System");
				break;
			default:
				System.out.println("Invalid choice");
				
			}
		}while(choice!=6);
	}
	
	//Guest Operations
	public static void guestmenu(Scanner sc,SearchService search) {
		int choice;
		do {
			System.out.println("===Guest Menu===");
			System.out.println("1. View Available Rooms");
			System.out.println("2. Search Rooms");
			System.out.println("3. Request Booking");
			System.out.println("4. Back");
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
				System.out.println("Exiting...");
			default:
				break;
			}
			}while(choice!=3);
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
