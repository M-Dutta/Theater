package beanies;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class Movie {
	String l = "'";
	String L = "','";
	String movie_id;
	String movie_name;
	Time runtim;
	Date releas;
	
	public Movie() {}
	
	public Movie(String movie_id, String movie_name,Time runtim, Date releas) 
	{
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.runtim = runtim;
		this.releas = releas;
	}
	
	public void getMovie(Statement s, int movieID) 
	{
		try 
		{
			ResultSet r =s.executeQuery("SELECT * from movie WHERE movie_id="+l+movie_id+l+")");
			r.next();
			this.movie_id = r.getString(1);
			this.movie_name = r.getString(2);
			this.runtim = r.getTime(3);
			this.releas = r.getDate(4);
		} 
		catch (SQLException e) 
		{
			System.out.println("getMovie "+e);
			e.printStackTrace();
		}
	}
	
	public void setMovieName(String string)
	{
		this.movie_name = string;
	}
	
	public void setDate(Date date)
	{
		this.releas = date;
	}
	
	public void setTime(Time time)
	{
		this.runtim = time;
	}
	
	public String getMovieName()
	{
		return this.movie_name;
	}
	
	public Date getDate()
	{
		return this.releas;
	}
	
	public Time getTime()
	{
		return this.runtim;
	}
	
	public void add(Statement s) 
	{
		try 
		{
			s.executeUpdate("INSERT into movie VALUES "+l+movie_id+L+movie_name+L+runtim+L+releas+l+")"  );
		}
		catch (SQLException e) 
		{
			System.out.println("add "+ e);
		}
	}
	
	
	public void remove(Statement s) 
	{
		try 
		{
			s.executeUpdate("DELETE from movie WHERE movie_id="+l+movie_id+l );
		} 
		catch (SQLException e) 
		{
			System.out.println("remove "+ e);
		}
		
	}
	
	public void edit(Statement s, String field, String info,int n) 
	{
		try 
		{
			if (n == 0) 
			{
				s.executeUpdate("Update movie "+ "SET "+field+"="+l+info+l + "WHERE movie_id="  +l+movie_id+l); 
			}
			else 
			{
				s.executeUpdate("Update Users "+ 
					"SET "+field+"="+l+ Integer.parseInt(info)+l + 
					"WHERE movie_id="  +l+movie_id+l) ;
			}
		}
		catch (SQLException e) 
		{
				System.out.println("Change Info "+ e);
		}
		
	}
}

