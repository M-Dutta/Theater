package containers;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

public class Movie_info extends Utilities{
	public int movieId;
	public String movieName;
	public Time runtime;
	public Date release;
	public String desc;
	public int rating;
	public int age;
	public String genre;
	public String cast;
	public String director;
	public String producer;
	public String trailerVideo;
	public String trailerPicture;
	public int status;
	String l = "'";
	String L = "','";
	
	public Movie_info() {}
	public Movie_info (int movieId,String movieName,Time runtime,Date release,String desc,int rating,
			int age,String genre,String cast,String director,String producer,String trailerVideo,String trailerPicture, int status) {
		this.movieId =movieId;
		this.runtime= runtime;
		this.release=release;
		this.desc=desc;
		this.rating=rating;
		this.age=age;
		this.genre=genre;
		this.cast=cast;
		this.director=director;
		this.producer=producer;
		this.trailerVideo=trailerVideo;
		this.trailerPicture=trailerPicture;
		this.status=status;
	}
	public void getMovie(Statement s, int movieID) {
		try {
		ResultSet r = s.executeQuery("SELECT * from movie WHERE id="+l+movieID+l);
		this.movieId =r.getInt(1);
		this.runtime= r.getTime(2);
		this.release=r.getDate(3);
		this.desc=r.getString(4);
		this.rating=r.getInt(5);
		this.age=r.getInt(6);
		this.genre=r.getString(7);
		this.cast=r.getString(8);
		this.director=r.getString(9);
		this.producer=r.getString(10);
		this.trailerVideo=r.getString(11);
		this.trailerPicture=r.getString(12);
		this.status=r.getInt(13);
		}
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
		}
	
		
	}
	
	void browse(){
		//tbi
	}
	
	public void add(Statement s) {
		try {
		s.executeUpdate("INSERT into movie VALUES "+l+movieId+L+runtime+L+release+L+desc+L+rating+L+age+L+genre+L+
				cast+L+director+producer+L+trailerVideo+L+trailerPicture+L+status+l+")"  );
		}
		catch (SQLException e) {
			System.out.println("add "+ e);
			}
	}
	
	
	public void remove(Statement s) {
		try {
			s.executeUpdate("DELETE from movie WHERE id="+l+movieId+l );
		} catch (SQLException e) {
			System.out.println("remove "+ e);
		}
		
	}
	
	public void edit(Statement s, String field, String info,int n) {
		try {
			if (n == 0) {
				s.executeUpdate("Update movie "+ 
					"SET "+field+"="+l+info+l + 
					"WHERE id="  +l+movieId+l); 
			}
			else {
				s.executeUpdate("Update Users "+ 
					"SET "+field+"="+l+ Integer.parseInt(info)+l + 
					"WHERE id="  +l+movieId+l) ;
			}
			}
			catch (SQLException e) {
				System.out.println("Change INfo "+ e);
			}
		
	}
}
