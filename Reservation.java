package sda;

public class Reservation {
	User x;
	Venue v;
	String Date;

	public Reservation(User user, Venue place, String date) 
	{
		x = user;
		v = place;
		Date = date;
	}
	
	public void ConfirmReservation()
	{
		System.out.println("Your Reservation has been booked as the following: On "+ Date +" Under the name of "+ x.Name + ", Venue "+ v.choice + "has been booked");
	}

}
