package sda;

public class Seat {
	
	String Gname;
	Boolean Reserved;
	int num;
	
	public Seat(int seatnum, String f) 
	{
		num = seatnum;
		Gname = f;
	}
	
	public boolean CheckSeat(int seatnum)
	{
		if (Reserved)
			return true;
		else
			return false;
	}
	
	public void ReserveSeat ()
	{
		Reserved = true; 
	}
	
	public int getseatnum ()
	{
		return num;
	}
	

}
