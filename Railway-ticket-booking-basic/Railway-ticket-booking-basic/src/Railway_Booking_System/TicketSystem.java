package Railway_Booking_System;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;

public class TicketSystem {
	
	private final Map<String, Integer> availableBerths = new HashMap<>();
	    private final Queue<Passenger> rac = new LinkedList<>();
	    private final Queue<Passenger> waitingList = new LinkedList<>();
	    private final List<Passenger> confirmedPassengers = new ArrayList<>();
	    private int ticketCounter = 1;

	    public TicketSystem() {
	        availableBerths.put("LOWER", 1);
	        availableBerths.put("MIDDLE", 2);
	        availableBerths.put("UPPER", 1);
	    }

	    public void bookTicket(String name, int age, String gender, String berthPreference) {
	        String ticketId = "T" + ticketCounter++;
	        Passenger passenger;

	        String allocatedBerth = allocateBerth(age, gender, berthPreference);
	        if (allocatedBerth != null) {
	            passenger = new Passenger(name, age, gender, berthPreference, allocatedBerth, ticketId);
	            confirmedPassengers.add(passenger);
	            availableBerths.put(allocatedBerth, availableBerths.get(allocatedBerth) - 1);
	            System.out.println("Ticket confirmed: " + passenger);
	        } else if (rac.size() <= 0) {
	            passenger = new Passenger(name, age, gender, berthPreference, "RAC", ticketId);
	            rac.add(passenger);
	            System.out.println("Ticket in RAC: " + passenger);
	        } else if (waitingList.size() <= 0) {
	            passenger = new Passenger(name, age, gender, berthPreference, "Waiting List", ticketId);
	            waitingList.add(passenger);
	            System.out.println("Ticket in Waiting List: " + passenger);
	        } else {
	            System.out.println("No tickets available");
	        }
	    }

	    private String allocateBerth(int age, String gender, String berthPreference) {
	        if ((age > 60 || gender.equalsIgnoreCase("female")) && availableBerths.get("LOWER") > 0) {
	            return "LOWER";
	        }
	        if (availableBerths.getOrDefault(berthPreference, 0) > 0) {
	            return berthPreference;
	        }
	        for (String berth : availableBerths.keySet()) {
	            if (availableBerths.get(berth) > 0) {
	                return berth;
	            }
	        }
	        return null; // No available berths
	    }

	    public void cancelTicket(String ticketId) {
	        Optional<Passenger> passengerOpt = confirmedPassengers.stream()
	                .filter(p -> p.ticketId.equals(ticketId))
	                .findFirst();

	        if (passengerOpt.isPresent()) {
	            Passenger passenger = passengerOpt.get();
	            confirmedPassengers.remove(passenger);

	            // Release the berth
	            String berth = passenger.allottedBerth;
	            availableBerths.put(berth, availableBerths.getOrDefault(berth, 0) + 1);

	            // Promote RAC to confirmed
	            if (!rac.isEmpty()) {
	                Passenger racPassenger = rac.poll();
	                String newBerth = allocateBerth(racPassenger.age, racPassenger.gender, racPassenger.berthPreference);
	                racPassenger.allottedBerth = newBerth;
	                confirmedPassengers.add(racPassenger);
	                availableBerths.put(newBerth, availableBerths.get(newBerth) - 1);
	                System.out.println("RAC passenger promoted to Confirmed: " + racPassenger);
	            }

	            // Promote Waiting to RAC
	            if (!waitingList.isEmpty()) {
	                Passenger wlPassenger = waitingList.poll();
	                wlPassenger.allottedBerth = "RAC";
	                rac.add(wlPassenger);
	                System.out.println("Waiting List passenger promoted to RAC: " + wlPassenger);
	            }
	            System.out.println("Ticket cancelled successfully for ID: " + ticketId);
	        } else {
	            System.out.println("No Ticket found with ID: " + ticketId);
	        }
	    }

	    public void printBookedTickets() {
	        if(confirmedPassengers.isEmpty()) {
	            System.out.println("No confirmed tickets");
	        }
	        else {
	            System.out.println("Confirmed Tickets");
	            for(Passenger passenger : confirmedPassengers) {
	                System.out.println(passenger);
	            }
	        }
	    }

	    public void printAvailableTickets() {
	        System.out.println("Available Berth: " + availableBerths.size());
	        System.out.println("Available RAC Tickets: " + (1 -  rac.size()));
	        System.out.println("Available Waiting List Tickets: " + (1 - waitingList.size()));
	    }

	    public void viewRacTickets() {
	        if (rac.isEmpty()) {
	            System.out.println("No RAC tickets");
	        }
	        else {
	            System.out.println("RAC tickets: ");
	            for(Passenger passenger : rac) {
	                System.out.println(passenger);
	            }
	        }
	    }

	    public void viewWaitingListTickets() {
	        if (waitingList.isEmpty()) {
	            System.out.println("No Waiting List tickets");
	        }
	        else {
	            System.out.println("Waiting List tickets: ");
	            for(Passenger passenger : waitingList) {
	                System.out.println(passenger);
	            }
	        }
	    }

}
