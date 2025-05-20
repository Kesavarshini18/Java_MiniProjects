package Ticket_Booking_Application;
import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter options");
		System.out.println("1 : Ticket Booking");
		System.out.println("2 : Show Confirmed Passenger Details");
		System.out.println("3 : Show RAC List");
		System.out.println("4 : Show waiting List"); 
		System.out.println("5 : Ticket Cancelling"); 
		TicketBooking tb = new TicketBooking();
		
		for( ; ;) {
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Passenger details");
				System.out.println("Enter your Name");
				String name = sc.next();
				System.out.println("Enter age");
				int age = sc.nextInt();
				System.out.println("Enter Preferece(U/M/L): ");
				char preference = sc.next().charAt(0);
				if(preference == 'U' || preference == 'M' || preference == 'L') {
					TicketBooking.bookTickets(new Passenger(name, age, preference));
				}
				else {
					System.out.println("Invalid Berth");
				}
				break;
			case 2:
				tb.getDetails();
				break;
			case 3:
				tb.getRACList();
				break;
			case 4:
				tb.getWaitingList();
				break;
			case 5:
				int ticket = sc.nextInt();
			    System.out.println(TicketCancelling.cancelTicket(ticket));
			    break;
			case 6:
				return;
			}
		}
	}	
}
