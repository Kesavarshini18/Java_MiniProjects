package Ticket_Booking_Application;

import java.util.*;

public class TicketBooking {

	private static int birthLimit = 3/3;
	private static int rac = 1;
	private static int waiting = 2;

	private static int upperSeatNo = 1;
	private static int middleSeatNo = 2;
	private static int lowerSeatNo = 3;

	static List<Passenger> confirmedList = new ArrayList<>();
	static List<Passenger> upper = new ArrayList<>();
	static List<Passenger> middle = new ArrayList<>();
	static List<Passenger> lower = new ArrayList<>();

	static Queue<Passenger> rac_list = new LinkedList<>();
	static Queue<Passenger>  waiting_list = new LinkedList<>();

	public static void bookTickets(Passenger p) {
		if (upper.size() == birthLimit && middle.size() == birthLimit && lower.size() == birthLimit) {
			if (UpdateRacQueue(p)) {
				System.out.println("Added to RAC\n Your Ticket id is" + p.getId());
			} else if (UpdateWaitingQueue(p)) {
				System.out.println("Added to Waiting List\n Your Ticket id is" + p.getId());
			} else {
				// setID
				p.setId(p.getId() - 1);
				System.out.println("Tickets are not available");
			}
		} else if (checkAvailability(p)) {
			System.out.println("Your ticket is confirmed\nYour ticket id is " + p.getId());
			p.setTicketType("Berth");
			confirmedList.add(p);
		} else {
			System.out.println(p.getPreference() + " is not available");
			p.setId(p.getId() - 1);
			availableList();
		}
	}

	private static void availableList() {
		System.out.println("Check out the number of seats available");
		System.out.println("Upper Berth count " + (birthLimit - upper.size()));
		System.out.println("Middle Berth count " + (birthLimit - middle.size()));
		System.out.println("Lower Berth count " + (birthLimit - lower.size()));
	}

	private static boolean checkAvailability(Passenger p) {
		Map<Integer, Character> map = TicketCancelling.getNumberwithSeat();
		if (p.getPreference() == 'U') {
			if (upper.size() < birthLimit) {
				if (!map.isEmpty() && getSeatDetails(map, p)) {

				} else {
					p.setSeatNo(upperSeatNo);
					upperSeatNo += 3;
				}

				upper.add(p);
				return true;
			}
		} else if (p.getPreference() == 'M') {
			if (middle.size() < birthLimit) {
				if (!map.isEmpty() && getSeatDetails(map, p)) {

				} else {
					p.setSeatNo(middleSeatNo);
					middleSeatNo += 3;
				}
				middle.add(p);
				return true;
			}
		} else if (p.getPreference() == 'L') {
			if (lower.size() < birthLimit) {
				if (!map.isEmpty() && getSeatDetails(map, p)) {
				} else {
					p.setSeatNo(lowerSeatNo);
					lowerSeatNo += 3;
				}
				lower.add(p);
				return true;
			}
		}
		return false;
	}

	private static boolean getSeatDetails(Map<Integer, Character> map, Passenger p) {
		int SeatNumber = checkForPreference(map, p.getPreference());
		if (SeatNumber != -1) {
			p.setSeatNo(SeatNumber);
			map.remove(SeatNumber);
			return true;
		}
		return false;
	}

	private static int checkForPreference(Map<Integer, Character> map, char preference) {
		for (Map.Entry<Integer, Character> entry : map.entrySet()) {
			if (entry.getValue() == preference) {
				return entry.getKey();
			}
		}
		return -1;

	}

	private static boolean UpdateWaitingQueue(Passenger p) {
		if (waiting > waiting_list.size()) {
			waiting_list.add(p);
			p.setTicketType("Waiting");
			return true;
		}
		return false;
	}

	private static boolean UpdateRacQueue(Passenger p) {
		if (rac_list.size() < rac) {
			rac_list.add(p);
			p.setTicketType("rac");
			return true;
		}
		return false;
	}

	public void getDetails() {
		for (Passenger p : confirmedList) {
			System.out.println("Name :" + p.getName() + "\nAge: " + p.getAge() + "\nTicketId: " + p.getId()
					+ "\nSeat Number" + p.getSeatNo());
			;
		}
	}

	public void getRACList() {
		for (Passenger p : rac_list) {
			System.out.println("Name :" + p.getName() + "\nAge: " + p.getAge() + "\nTicketId: " + p.getId()
					+ "\nSeat Number" + p.getSeatNo());
			;
		}
	}

	public void getWaitingList() {
		for (Passenger p : waiting_list) {
			System.out.println("Name :" + p.getName() + "\nAge: " + p.getAge() + "\nTicketId: " + p.getId()
					+ "\nSeat Number" + p.getSeatNo());
			;
		}
	}
}
