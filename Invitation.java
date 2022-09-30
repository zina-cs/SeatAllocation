package sda;

import java.util.ArrayList;

public class Invitation 
{
	Guest x;
	String Deadline;
	ArrayList <String> Prefs;
	
	public Invitation (Guest g, String Time)
	{
		Prefs = new ArrayList<String>();
		Deadline = Time;
		System.out.println("An Invitation has been sent to "+ g.Name + " at "+ g.Email + ". Final Response to be received at " + Deadline);
	}
	
	public void RecordPref (String p, String b, String c)
	{
		Prefs.add(p);
		Prefs.add(b);
		Prefs.add(c);
	}
	
	public String Preference1 ()
	{
		return Prefs.get(0);
	}

}
