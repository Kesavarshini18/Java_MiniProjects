package Ticket_Booking_Application;

public class Passenger {
	private static int idProvider = 0;
	private String name;
	private int age;
	private char preference;
	private int ticketId;
	private String ticketType;
	private int seatNo;
	
	public Passenger(String name, int age, char preference) {
		this.name = name;
		this.age = age;
		this.preference = preference;
		this.ticketId = ++idProvider;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getPreference() {
		return preference;
	}
	public void setPreference(char preference) {
		this.preference = preference;
	}
	public int getId() {
		return ticketId;
	}
	public void setId(int ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketType() {
		return ticketType;
	}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;		
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
}
