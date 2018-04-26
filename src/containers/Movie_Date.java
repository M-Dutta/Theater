package containers;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;

import com.mysql.jdbc.Statement;

public class Movie_Date extends Utilities {
	public String l = "'";
	public String L = "', '";
	public int id;
	public Date date;
	public Time time;
	public double price;
	public int capacity;
	public String promo_code;
	
	public Movie_Date() {}

	
	public Movie_Date(int id, Date date, Time time, double price, int capacity, String promo_code) {
		this.id = id;
		this.date = date;
		this.time = time;
		this.price = price;
		this.capacity = capacity;
		this.promo_code = promo_code;
	}
	public void addM_info(Statement s, Movie_Date m) {
		try {
			s.executeUpdate("Insert into m_info value("+l+m.id+L+m.date+L+m.time+L+m.price+L+m.capacity+L+m.promo_code+l+")");
		} catch (SQLException e) {

			System.out.println("addM_info "+e);
		}
	}
	
	public void getMovie_Date(Statement s, int id) {
		try {
			s.executeQuery("SELECT * from movie_date WHERE id="+l+id+l);
		} catch (SQLException e) {
			System.out.println("getMovie_Date-Info "+e);
		}	
	}
	
	public void removeMovie_Date(Statement s, Movie_Date m) {
		try {
			s.executeQuery("delete from m_info WHERE id="+l+m.id+l);
		} catch (SQLException e) {
			System.out.println("get Movie_Date-Info "+e);
		}	
	}
	
	public void editMovie_Date(Statement s, String field, String info, int n  ) {
		try {
			if (n == 5) {
				try {
					s.executeUpdate("Update movie_date "+ "SET "+field+"="+l+Utilities.DateConverter(info)+l + "WHERE id="  +l+this.id+l);
				} catch (ParseException e) {
				
					System.out.println("edit Movie_Date-Info Date "+e);
				} 
			}
			
			if (n == 10) {
				try {
					s.executeUpdate("Update movie_date "+ "SET "+field+"="+l+Utilities.TimeConverter(info)+l + "WHERE id="  +l+this.id+l);
				} catch (ParseException e) {
				
					System.out.println("editM-Info Time "+e);
				} 
			}
		} catch (SQLException e) {
			System.out.println("editMovie_date-Info "+e);
		}	
	}
	
}
