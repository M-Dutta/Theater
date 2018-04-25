package beanies;
import containers.Utilities;
import java.sql.Date;
import java.sql.Statement;
import java.sql.Time;

public class Tickets extends Utilities{
	public int ticketId;
	public int movieId;
	public Date date;
	public Time time;
	String l = "'";
	String L = "','";
	
	
	public Tickets() {}
	
	
	public void selectTicket(Statement s) 
	{
		//To be implemented
	}
	
	public void changeAmount(Statement s) 
	{
		
	}
	
	public void setId(int num)
	{
		this.ticketId = num;
	}
	
	public void setMovieId(int num)
	{
		this.movieId = num;
	}
	
	public void setDate(Date date)
	{
		this.date = date;
	}
	
	public void setTime(Time time)
	{
		this.time  = time;
	}
	
	public int getId()
	{
		return this.ticketId;
	}
	
	public int getMovieId()
	{
		return this.movieId;
	}
	
	public Date getDate()
	{
		return this.date;
	}
	
	public Time getTime()
	{
		return this.time;
	}
}
