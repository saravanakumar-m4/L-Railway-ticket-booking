package Railway_Booking_System;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		TicketSystem ticketSystem = new TicketSystem();
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\nRailway Booking System");
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. View Confirmed Ticket");
			System.out.println("4. View Available Ticket");
			System.out.println("5. View RAC Ticket");
			System.out.println("6. View Waiting List Ticket");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter name: ");
				String name = sc.nextLine();
				System.out.print("Enter age: ");
				int age = sc.nextInt();
				System.out.print("Enter Gender (Male / Female): ");
				String gender = sc.next().toUpperCase();
				sc.nextLine();
				System.out.print("Enter a birth preferences (LOWER / MIDDLE / UPPER): ");
				String berthPreference = sc.nextLine().toUpperCase();
				ticketSystem.bookTicket(name, age, gender, berthPreference);
				break;
			case 2:
				System.out.print("Enter Ticket ID to Cancel: ");
				String ticketId = sc.nextLine();
				ticketSystem.cancelTicket(ticketId);
				break;
			case 3:
				ticketSystem.printBookedTickets();
				break;
			case 4:
				ticketSystem.printAvailableTickets();
				break;
			case 5:
				ticketSystem.viewRacTickets();
				break;
			case 6:
				ticketSystem.viewWaitingListTickets();
				break;
			case 7:
				System.out.println("Exiting...");
				System.exit(0);
			}
		}

	}

}
