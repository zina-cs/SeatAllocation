package sda;

import java.util.ArrayList;

public class Table {

	ArrayList <Seat> Table;
	
	public Table () {Table = new ArrayList<Seat>();}
	
	public void InsertSeat (Seat s)
	{
		Table.add(s);
	}
	
	public boolean checkSeat (Seat s)
	{
		if (Table.contains(s))
			return true;
		else
			return false;			

	}

}
