package containers;
import java.sql.Date; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;

public class Movie extends Utilities{
	String l = "'";
	String L = "','";
	public int id;
	public String movie_name;
	public String desc;
	public int rating;
	public int age;
	public String genre;
	public String cast;
	public String director; 
	public String producer;
	public String trailer;
	public String trailerPicture;
	public Time runTime ;
	public Date releaseDate;
	public int status;
	
	public Movie() {}
	public Movie(int id, String movie_name,
	String desc,
	int rating,
	int age,
	String genre,
	String cast,
	String director, 
	String producer,
	String trailer,
	String trailerPicture,
	Time runTime,
	Date releaseDate, int status) {
		 this.id = id;
		 this.movie_name = movie_name; //r
		 this.desc = desc;
		 this.rating = rating;
		 this.age = age;
		 this.genre = genre;
		 this.cast = cast;
		 this.director = director;
		 this.producer = producer;
		 this.trailer = trailer;
		 this.trailerPicture =trailerPicture;
		 this.runTime =runTime; //r
		 this.releaseDate=releaseDate; //r
		 this.status=status;
	}
	
	public void getMovie(Statement s, int movieID) {
		try {
			ResultSet r =s.executeQuery("SELECT * from Movie WHERE movie_id="+l+movieID+l);
			r.next();
			this.movie_name = r.getString(2); //r
			this.runTime =r.getTime(3); //r
			this.releaseDate=r.getDate(4); //r
			this.id = r.getInt(1);
			ResultSet r2=s.executeQuery("SELECT * from m_info WHERE id="+l+movieID+l);
			r2.next();
			this.desc = r2.getString(2);
			this.rating = r2.getInt(3);
			this.age = r2.getInt(4);
			this.genre = r2.getString(5);
			this.cast = r2.getString(6);
			this.director = r2.getString(7);
			this.producer = r2.getString(8);
			this.trailer = r2.getString(9);;
			this.trailerPicture =r2.getString(10);
			this.status=r2.getInt(11);
			
		} catch (SQLException e) {
			System.out.println("getMovie "+e);
			e.printStackTrace();
		}
	}
	
	public void add(Statement s) {
		try {
		System.out.println(this.id+" "+this.movie_name+" "+this.runTime+" "+this.releaseDate);
		s.executeUpdate("insert into movie value("
		+l+this.id+L+this.movie_name+L+
				this.runTime+L+this.releaseDate+l+")"  );
		
		s.executeUpdate("INSERT into m_info VALUES("+l+this.id+L+this.desc+L+this.rating+L+
				this.age+L+this.genre+L+this.cast+L+this.director+L+this.producer+L+
				this.trailer+L+this.trailerPicture+L+this.status+l+")"  );
		}
		catch (SQLException e) {
			System.out.println("add "+ e);
			}
	}
	
	
	public void remove(Statement s) {
		try {
			s.executeUpdate("DELETE from m_info WHERE id="+l+this.id+l );
			s.executeUpdate("DELETE from movie_date WHERE id="+l+this.id+l );
			s.executeUpdate("DELETE from movie WHERE movie_id="+l+this.id+l );
			
		} catch (SQLException e) {
			System.out.println("remove "+ e);
		}
		
	}
	
	public void edit(Statement s, String field, String info,int n) {
		try {
			if (n == 0) {
				s.executeUpdate("Update movie "+ 
					"SET "+field+"="+l+info+l + 
					"WHERE movie_id="  +l+this.id+l); 
			}
			if (n == 5) {
				try {
					s.executeUpdate("Update movie "+ 
						"SET "+field+"="+l+Utilities.DateConverter(info)+l + 
						"WHERE movie_id="  +l+this.id+l);
				} catch (ParseException e) {
					System.out.println("Movie info");
				} 
			}
			
			if (n == 10) {
				try {
					s.executeUpdate("Update movie "+ 
						"SET "+field+"="+l+Utilities.TimeConverter(info)+l + 
						"WHERE movie_id="  +l+this.id+l);
				} catch (ParseException e) {
					System.out.println("Movie  info");
				} 
			}
			
			
			if (n ==1) {  /////////////////////////// n = 1 for integer Values
				s.executeUpdate("Update movie "+ 
					"SET "+field+"="+l+ Integer.parseInt(info)+l + 
					"WHERE movie_id="  +l+this.id+l) ;
			}
			}
			catch (SQLException e) {
				System.out.println("Change Info "+ e);
			}
		
	}
}

