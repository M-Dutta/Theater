package beanies;
import containers.Movie_info; 
import containers.Utilities;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.Format;
import java.text.SimpleDateFormat;
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
			
			//get length
			PreparedStatement stmt4 = Utilities.con.prepareStatement("SELECT runtim from Movie WHERE movie_name=?");
			stmt4.setString(1, movie);
			ResultSet lenRs = stmt4.executeQuery();
			Time length = null;
			if (lenRs.next())
			{
				length = lenRs.getTime(1);
			}
			
			//get movie id 
			PreparedStatement stmt5 = Utilities.con.prepareStatement("SELECT movie_id from Movie WHERE movie_name=?");
			stmt5.setString(1, movie);
			ResultSet idRs = stmt5.executeQuery();
			int id = 0;
			if(idRs.next())
			{
				id = idRs.getInt(1);
			}
			
			//get picture
			PreparedStatement stmt6 = Utilities.con.prepareStatement("SELECT trailer_picture from m_info WHERE id =?");
			stmt6.setInt(1, id);
			ResultSet picRs = stmt6.executeQuery();
			String pic = null;
			if(picRs.next())
			{
				pic = picRs.getString(1);
			}
			
			//get description
			PreparedStatement stmt7 = Utilities.con.prepareStatement("SELECT description from m_info WHERE id=?");
			stmt7.setInt(1, id);
			ResultSet desRs = stmt7.executeQuery();
			String des = null;
			if(desRs.next())
			{
				des = desRs.getString(1);
			}
			
			
			//get genre
			PreparedStatement stmt8 = Utilities.con.prepareStatement("SELECT genre from m_info WHERE id=?");
			stmt8.setInt(1, id);
			ResultSet genRs = stmt8.executeQuery();
			String gen = null;
			if (genRs.next())
			{
				gen = genRs.getString(1);
			}
			
			//get rating
			PreparedStatement stmt9 = Utilities.con.prepareStatement("SELECT rating from m_info WHERE id =?");
			stmt9.setInt(1, id);
			ResultSet ratRs = stmt9.executeQuery();
			int rat = 0;
			if(ratRs.next())
			{
				rat = ratRs.getInt(1);
			}
			
			//get date/time list	
			PreparedStatement stmt10 = Utilities.con.prepareStatement("SELECT date,time from movie_date WHERE id =?");
			stmt10.setInt(1, id);
			ResultSet showRs = stmt10.executeQuery();
			ArrayList<String> showtimeList = new ArrayList<String>();
			Format dateFormat = new SimpleDateFormat("YYYY-MM-dd");
			Format timeFormat = new SimpleDateFormat("HH:mm:ss");
			while(showRs.next())
			{
				String show = dateFormat.format(showRs.getDate(1)) + " " + timeFormat.format(showRs.getTime(2));
				showtimeList.add(show);
			}
			
			//add movie object to list 
			Movie mov = new Movie();
			mov.setMovieName(movie);
			mov.setLength(length);
			mov.setPic(pic);
			mov.setId(id);
			mov.setDescription(des);
			mov.setGenre(gen);
			mov.setRating(rat);
			mov.setShowtimeList(showtimeList);
			System.out.println(mov.movie_name);
			MovieList.add(mov);
		}
		
		return MovieList;
	}
	
	
}