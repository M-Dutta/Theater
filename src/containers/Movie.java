package containers;
import java.sql.Date; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class Movie extends Utilities{
	String l = "'";
	String L = "','";
	int id;
	String movie_name;
	String desc;
	int rating;
	int age;
	String genre;
	String cast;
	String director; 
	String producer;
	String trailer;
	String trailerPicture;
	Time runTime ;
	Date releaseDate;
	int status;
	
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
			ResultSet r =s.executeQuery("SELECT * from Movie WHERE movie_id="+l+movieID+l+")");
			ResultSet r2=s.executeQuery("SELECT * from m_info WHERE id="+l+movieID+l+")");
			r.next();
			r2.next();
			this.id = r.getInt(1);
			this.movie_name = r.getString(2); //r
			this.desc = r2.getString(2);
			this.rating = r2.getInt(3);
			this.age = r2.getInt(4);
			this.genre = r2.getString(5);
			this.cast = r2.getString(6);
			this.director = r2.getString(7);
			this.producer = r2.getString(8);
			this.trailer = r2.getString(9);;
			this.trailerPicture =r2.getString(10);
			this.runTime =r.getTime(3); //r
			this.releaseDate=r.getDate(4); //r
			this.status=r2.getInt(11);
		} catch (SQLException e) {
			System.out.println("getMovie "+e);
			e.printStackTrace();
		}
	}
	
	public void add(Statement s) {
		try {
		System.out.println(this.id+" "+this.movie_name+" "+this.runTime+" "+this.releaseDate);
		//s.executeUpdate("insert into movie value("
		//+Integer.toString(this.id)+L+this.movie_name+L+
		//		this.runTime+L+this.releaseDate+l+")"  );
		s.executeUpdate("insert into movie value(11,'movie','04:02:22','2008-12-12')");
		//s.executeUpdate("INSERT into m_info VALUES("+l+this.id+L+this.desc+L+this.rating+L+
			//	this.age+L+this.genre+L+this.cast+L+this.director+L+this.producer+L+
				//this.trailer+L+this.trailerPicture+L+this.status+l+")"  );
		}
		catch (SQLException e) {
			System.out.println("add "+ e);
			}
	}
	
	
	public void remove(Statement s) {
		try {
			s.executeUpdate("DELETE from m_info WHERE id="+l+this.id+l );
			s.executeUpdate("DELETE from Movie WHERE movie_id="+l+this.id+l );
		} catch (SQLException e) {
			System.out.println("remove "+ e);
		}
		
	}
	
	public void edit(Statement s, String field, String info,int n) {
		try {
			if (n == 0) {
				s.executeUpdate("Update m_info "+ 
					"SET "+field+"="+l+info+l + 
					"WHERE id="  +l+this.id+l); 
			}
			else {  /////////////////////////// n = 1 for integer Values
				s.executeUpdate("Update m_info "+ 
					"SET "+field+"="+l+ Integer.parseInt(info)+l + 
					"WHERE id="  +l+this.id+l) ;
			}
			}
			catch (SQLException e) {
				System.out.println("Change Info "+ e);
			}
		
	}
}

