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

public class ReportList extends Utilities implements Serializable {

	ArrayList<Tickets> ReportList = new ArrayList<Tickets>();
	
	public ReportList() throws ClassNotFoundException, SQLException
	{
		
	}
	
	public ArrayList<Tickets> getReportList() throws SQLException
	{
		PreparedStatement stmt = Utilities.con.prepareStatement("SELECT ticket_id from ticket");
		ResultSet idRs = stmt.executeQuery();
		
		while(idRs.next())
		{
			//get id
			int id = idRs.getInt(1);
			
			//get movie id
			PreparedStatement stmt2 = Utilities.con.prepareStatement("SELECT movie_id from ticket WHERE id=?");
			stmt2.setInt(1, id);
			ResultSet movieRs = stmt2.executeQuery();
			int movie = 0;
			if (movieRs.next())
			{
				movie = movieRs.getInt(1);
			}
			
			//get date
			PreparedStatement stmt3 = Utilities.con.prepareStatement("SELECT date from ticket WHERE id=?");
			stmt3.setInt(1, id);
			ResultSet dateRs = stmt3.executeQuery();
			Date date = null;
			if (dateRs.next())
			{
				date = dateRs.getDate(1);
			}
			
			//get time
			PreparedStatement stmt4 = Utilities.con.prepareStatement("SELECT time from ticket WHERE id=?");
			stmt3.setInt(1, id);
			ResultSet timeRs = stmt4.executeQuery();
			Time time = null;
			if (timeRs.next())
			{
				time = timeRs.getTime(1);
			}
			
			Tickets ticket = new Tickets();
			ticket.setId(id);
			ticket.setMovieId(movie);
			ticket.setDate(date);
			ticket.setTime(time);
			
			ReportList.add(ticket);
			
		}
		
		return ReportList;
	}
}