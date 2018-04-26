package containers;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;

public class Movie_info extends Utilities{
	public int id;
	public String movieName;
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
	public Movie_info (int movieId,String movieName,String desc,int rating,
			int age,String genre,String cast,String director,String producer,String trailerVideo,String trailerPicture, int status) {
		this.id =movieId;
		this.movieName = movieName;
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
		ResultSet r = s.executeQuery("SELECT * from m_info WHERE id="+l+movieID+l);
		r.next();
		this.id =r.getInt(1);
		this.desc=r.getString(2);
		this.rating=r.getInt(3);
		this.age=r.getInt(4);
		this.genre=r.getString(5);
		this.cast=r.getString(6);
		this.director=r.getString(7);
		this.producer=r.getString(8);
		this.trailerVideo=r.getString(9);
		this.trailerPicture=r.getString(10);
		this.status=r.getInt(11);
		}
		catch (SQLException e ) {
		System.out.println("getMOvie movie_info "+ e);
		}
	
		
	}
	
	void browse(){
		//tbi
	}
	

	
	
	public void remove(Statement s) {
		try {
			s.executeUpdate("DELETE from m_info WHERE id="+l+this.id+l );
		} catch (SQLException e) {
			System.out.println("remove "+ e);
		}
		
	}
	
	public void editMoive_info(Statement s, String field, String info,int n) {
		try {
			if (n == 0) {
				s.executeUpdate("Update m_info "+ 
					"SET "+field+"="+l+info+l + 
					"WHERE id="  +l+this.id+l); 
			}
			else {
				s.executeUpdate("Update m_info "+ 
					"SET "+field+"="+l+ Integer.parseInt(info)+l + 
					"WHERE id="  +l+this.id+l) ;
			}
			}
			catch (SQLException e) {
				System.out.println("Change Movie_info INfo "+ e);
			}
		
	}
}
