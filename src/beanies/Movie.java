package beanies;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;

public class Movie {
	public String l = "'";
	public String L = "','";
	public String movie_name;
	public Time runtim;
	public String trailer_picture;
	public int id;
	public String movie_id;
	public String description;
	public String genre;
	public int rating;
	public ArrayList<String> showtimes = new ArrayList<String>();
	public Date releas;
	
	
	
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
	
	public void setLength(Time time)
	{
		this.runtim = time;
	}
	
	public void setPic(String pic)
	{
		this.trailer_picture = pic;
	}
	
	public void setId(int num)
	{
		this.id = num;
	}
	
	public void setDescription(String string)
	{
		this.description = string;
	}
	
	public void setGenre(String string)
	{
		this.genre = string;
	}
	
	public void setRating(int num)
	{
		this.rating = num;
	}
	
	public void setShowtimeList(ArrayList<String> list)
	{
		this.showtimes = list;
	}
	
	public String getMovieName()
	{
		return this.movie_name;
	}
	
	public Time getLength()
	{
		return this.runtim;
	}
	
	public String getPic()
	{
		return this.trailer_picture;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public String getGenre()
	{
		return this.genre;
	}
	
	public int getRating()
	{
		return this.rating;
	}
	
	public ArrayList<String> getShowtimeList()
	{
		return this.showtimes;
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
