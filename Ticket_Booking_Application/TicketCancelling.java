package Ticket_Booking_Application;
import java.util.*;

public class TicketCancelling extends TicketBooking {
	
	private static char preferenceTracker = '\0';
	private static int CancelledSeatNo = 0;
	
	private static Map<Integer, Character> SeatNumberwithBerth = new HashMap<>();
	
	public static String cancelTicket(int id) {
		for(Passenger p : confirmedList) {
			if(id == p.getId()) {
				cancel(p);
				return "Ticket is cancelled";
			}
		}
		for(Passenger p : rac_list) {
			if(id == p.getId()) {
				cancel(p);
				return "Ticket is cancelled";
			}
		}
		for(Passenger p : waiting_list) {
			if(id == p.getId()) {
				cancel(p);
				return "Ticket is cancelled";
			}
		}
		return "Invalid id";
	}
	private static void cancel(Passenger p) {
		if(p.getTicketType() == "Berth") {
			
			preferenceTracker = p.getPreference();
			CancelledSeatNo = p.getSeatNo();
			
			SeatNumberwithBerth.put(CancelledSeatNo, preferenceTracker);
			
			deleteFromAllList(p);
			addRacToBerth(rac_list.poll());
			addWaitingToRac(waiting_list.poll());
		}
		else if(p.getTicketType() == "rac") {
			rac_list.remove(p);			
			addWaitingToRac(waiting_list.poll());
		}
		else if(p.getTicketType() == "waiting") {
			waiting_list.remove(p);
		}
	}
	private static void addWaitingToRac(Passenger p) {
		if(p != null) {
			p.setTicketType("rac");
			rac_list.add(p);
		}
		
	}
	private static void addRacToBerth(Passenger p) {
		if(p != null) {
			p.setPreference(preferenceTracker);
			p.setSeatNo(CancelledSeatNo);
			
			if(preferenceTracker == 'U') {
				upper.add(p);
			}
			else if(preferenceTracker == 'M') {
				middle.add(p);
			} 
			else if(preferenceTracker == 'L') {
				lower.add(p);
			}
		}
		confirmedList.add(p);
		SeatNumberwithBerth.remove(CancelledSeatNo);
		preferenceTracker = '\0';
		CancelledSeatNo = 0;
	}
	private static void deleteFromAllList(Passenger p) {
		confirmedList.remove(p);
		upper.remove(p);
		middle.remove(p);
		lower.remove(p);
	}
	public static Map<Integer, Character> getNumberwithSeat(){
		return SeatNumberwithBerth;
	}
}
