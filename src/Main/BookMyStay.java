/*
 * @author Developer
 * @version 1
 */

package Main;

import java.util.Scanner;

import Service.InventoryService;

public class BookMyStay {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		InventoryService inventory=new InventoryService();
		int choice;
		
		//Getting the choice as input from the Manager
		do {
			System.out.println("====BookMyStay Inventory Menu===");
			System.out.println("1. Add Room");
			System.out.println("2. Update Room count");
			System.out.println("3. Update Room Price");
			System.out.println("4. Check Room Availability");
			System.out.println("5. Display Inventory");
			System.out.println("6. exit");
			
			System.out.print("Enter your Choice: ");
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Room type:");
				String roomType=sc.next();
				System.out.println("Enter room count:");
				int count=sc.nextInt();
				System.out.println("Enter room price");
				double price=sc.nextDouble();
				inventory.addRoom(roomType, count, price);
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
				System.out.println("Exiting System");
				break;
			default:
				System.out.println("Invalid choice");
				
			}
		}while(choice!=6);
	}
}
