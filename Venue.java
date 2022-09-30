package sda;

public class Venue 
{
	String choice;
	int capacity;
	
	public Venue()
	{choice = "";
	capacity = 0;
	}
	
	public String DisplayVenues()
	{
		return "Available Venue Choices: Hotel X, Ballroom 3, Center 5";
	}

	public int bookVenue(String venue)
	{
		choice = venue; 
		if (choice.equals("Hotel X"))
		{
			return 16;
		}
		else if (choice.equals("Ballroom 3"))
		{
			return 25;
		}
		else
		{
			return 16;
		}
	}
	
}
