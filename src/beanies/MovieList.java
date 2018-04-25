package beanies;
import containers.Utilities;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MovieList extends Utilities implements Serializable {

	ArrayList<Movie> MovieList = new ArrayList<Movie>();
	
	public MovieList() throws ClassNotFoundException, SQLException
	{
		
	}
	
	public ArrayList<Movie> getMovieList() throws SQLException
	{
		PreparedStatement stmt = Utilities.con.prepareStatement("SELECT movie_name from Movie");
		ResultSet movieRs = stmt.executeQuery();
		
		while(movieRs.next())
		{
			//get movie name
			String movie = movieRs.getString(1);
			
			//get date
			PreparedStatement stmt3 = Utilities.con.prepareStatement("SELECT releas from Movie WHERE movie_name=?");
			stmt3.setString(1, movie);
			ResultSet dateRs = stmt3.executeQuery();
			Date date = null;
			if (dateRs.next())
			{
				date = dateRs.getDate(1);
			}
			
			//get time
			PreparedStatement stmt4 = Utilities.con.prepareStatement("SELECT runtim from Movie WHERE movie_name=?");
			stmt3.setString(1, movie);
			ResultSet timeRs = stmt4.executeQuery();
			Time time = null;
			if (timeRs.next())
			{
				time = timeRs.getTime(1);
			}
			
			
			Movie mov = new Movie();
			mov.setMovieName(movie);
			mov.setDate(date);
			mov.setTime(time);
		
			
			MovieList.add(mov);
		}
		
		return MovieList;
	}
}