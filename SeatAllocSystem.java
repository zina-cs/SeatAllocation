package sda;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class SeatAllocSystem 
{

	public static void main(String[] args) throws IOException
	{
		Scanner s = new Scanner(System.in);
		
		System.out.println("Hello, Welcome to our Seat Allocation program!");
		System.out.println("Please Enter the following details: ");
		System.out.println("Your Name: ");
		String uname = s.next();
		User user = new User(uname);
		Venue venue = new Venue();
		System.out.println("Which Venue would you like to book? "+ venue.DisplayVenues());
		int capacity = venue.bookVenue(s.next());
		System.out.println("On which date would you like to book the venue?");
		String date = s.next();
		Reservation reservation = new Reservation(user, venue, date);
		reservation.ConfirmReservation();
		System.out.println("The guest list inputted previously in this system will be used: ");
		
		BufferedReader inFile = new BufferedReader(new FileReader("C:\\Users\\Z\\eclipse-workspace\\ANLP\\bin\\a\\sda\\src\\sda\\guests.txt"));

	        String schedule;

	        // create the queue of guests
	        ArrayList<Guest> queue = new ArrayList<Guest>();

	        // read in the tasks and populate the ready queue        
	        while ( (schedule = inFile.readLine()) != null) {
	            String[] params = schedule.split(",\\s*");
	            queue.add(new Guest(params[0], params[1]));
	            System.out.println(params[0] + " " + params[1]);
	        }
	        inFile.close();
	        
	        System.out.println("The digital invitations, using the template previously inputted, will be used. How many days should the system wait before taking Guests' preferences?");
	        String deadline = s.next();
	        int i = 0;
	        ArrayList<Invitation> invitations = new ArrayList<Invitation>();
			while (i != queue.size())
	        {
	        	invitations.add(new Invitation(queue.get(i), deadline));
	        	i++;
	        }
			System.out.println(deadline + " days has passed. Guest seat preferences have been recorded. The seat plan will now be generated.");
			BufferedReader File = new BufferedReader(new FileReader("C:\\Users\\Z\\eclipse-workspace\\ANLP\\bin\\a\\sda\\src\\sda\\prefs.txt"));
			      int j = 0;
	        while ( ((schedule = File.readLine()) != null) && (j<invitations.size())) {
	            String[] params = schedule.split(",\\s*");
	            invitations.get(j).RecordPref(params[0], params[1], params[2]);
	            j++;
	        }
	        File.close();
	        
	        ArrayList<Integer> Seatpref = new ArrayList<Integer>();
	        
	        int z = 0;
	        while (z< invitations.size())
	        {
	        	Seatpref.add(Integer.parseInt(invitations.get(z).Preference1()));
	        	z++;
	        }
	        
	        ArrayList<String> gname = new ArrayList<String>();
	        int y = 0;
	        while (y< invitations.size())
	        {
	        	gname.add(queue.get(y).Name);
	        	y++;
	        }
	        
				ArrayList <Seat> SeatList = new ArrayList<Seat>();
				int cap = 0;
				if (capacity > Seatpref.size())
					cap = Seatpref.size() - 1;
				
				for (int k = 0; k < cap; k++)
				{
					int seatpref1 = Seatpref.get(k);
					int r = 0;
					for (int f = 0; f < Seatpref.size(); f++)
					{
						if (seatpref1 == Seatpref.get(f))
							r++;
					}
					if (r == 1)
					{	
						SeatList.add(new Seat(seatpref1, gname.get(k)));
					}
					else if (r==2)
					{
						int currentp = Integer.parseInt(invitations.get(k).Prefs.get(1));
						SeatList.add(new Seat(currentp, gname.get(k)));
						Seatpref.remove(k);
					}
					
				}
				
				Table Table1 = new Table();
				System.out.println("The first table has the following seats, and guests: ");
				for (int w = 0; w < 5; w++)
				{
					for (int id = 0; id < SeatList.size(); id++)
					{
						if (SeatList.get(id).getseatnum() == w)
						{
							System.out.println("Seat: "+ w + " Guest: "+ gname.get(id));
							Table1.InsertSeat(SeatList.get(id));
						}
					}
					
				}
				Table Table2 = new Table();
				System.out.println("The second table has the following seats, and guests: ");
				for (int w = 5; w < 9; w++)
				{
					for (int id = 0; id < SeatList.size(); id++)
					{
						if (SeatList.get(id).getseatnum() == w)
						{
							System.out.println("Seat: "+ w + " Guest: "+ gname.get(id));
							Table2.InsertSeat(SeatList.get(id));
						}
					}
					
				}
				Table Table3 = new Table();
				System.out.println("The third table has the following seats, and guests: ");
				for (int w = 9; w < 12; w++)
				{
					for (int id = 0; id < SeatList.size(); id++)
					{
						if (SeatList.get(id).getseatnum() == w)
						{
							System.out.println("Seat: "+ w + " Guest: "+ gname.get(id));
							Table3.InsertSeat(SeatList.get(id));
						}
					}
					
				}
				Table Table4 = new Table();
				System.out.println("The four table has the following seats, and guests: ");
				for (int w = 12; w < 16; w++)
				{
					for (int id = 0; id < SeatList.size(); id++)
					{
						if (SeatList.get(id).getseatnum() == w)
						{
							System.out.println("Seat: "+ w + " Guest: "+ gname.get(id));
							Table4.InsertSeat(SeatList.get(id));
						}
					}
					
				}
				s.close();
			
	}

}
