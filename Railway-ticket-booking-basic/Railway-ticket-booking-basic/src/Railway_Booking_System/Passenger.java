package Railway_Booking_System;

public class Passenger {

	String name;
	int age;
	String gender;
	String berthPreference; // Lower, Upper, Middle
	String allottedBerth;
	String ticketId; // important for cancelling tickets

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + ", berthPreference="
				+ berthPreference + ", allottedBerth=" + allottedBerth + ", ticketId=" + ticketId + "]";
	}

	public Passenger(String name, int age, String gender, String berthPreference, String allottedBerth,
			String ticketId) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.berthPreference = berthPreference;
		this.allottedBerth = allottedBerth;
		this.ticketId = ticketId;
	}

}
