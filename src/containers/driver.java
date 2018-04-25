package containers; 
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.text.ParseException;

public class driver extends Utilities  {
	public static void main (String [] args) throws InterruptedException, ParseException {
	
	  /*   
		try {
			ResultSet r = Utilities.stmt.executeQuery("select * from admin where admin_id='1'");
			r.next();
			System.out.println(r.getInt(1)+r.getString(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/	
		try {
			Utilities.stmt.executeUpdate("insert into movie value('1','movie','04:02:22','2008-12-12');");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
	
	
	
	
}