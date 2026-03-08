/*
 * @author Developer
 * @version 5
 */

package Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Services;

public class AddOnServiceManager {
	Map<String,List<Services>> reservationServices = new HashMap<>();
	
	//Adding the services
	public void addService(String reservationId,Services service) {
		reservationServices.computeIfAbsent(reservationId, k -> new ArrayList<>()).add(service);
		System.out.println("Service added to reservation "+reservationId);
	}
	
	//View Services
	public void viewServices(String reservationId) {
		List<Services> services=reservationServices.get(reservationId);
		if(services==null || services.isEmpty()) {
			System.out.println("No service added");
			return;
		}for(Services s: services) {
			System.out.println(s);
		}
	}
	
	//Calculating the total cost for services
	public double calculateTotalCost(String reservationId) {
		List<Services> services=reservationServices.get(reservationId);
		if(services==null) {
			return 0;
		}
		double total=0;
		for(Services s: services) {
			total+=s.getPrice();
		}
		return total;
	}
}
