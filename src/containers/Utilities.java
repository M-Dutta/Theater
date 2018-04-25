package containers;
import java.sql.Connection;   
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Utilities {


/**
 * Server Information
 * Note that localhost:8000/ value will vary depending on your MySQL local server 
 */
public final  static String user = "root";
public final static String pswd = "root"; 
public final  static String DBname = "movie_theater?useSSL=false"; 
public final  static String Driver ="com.mysql.jdbc.Driver";
public final static  String connectionURL ="jdbc:mysql://localhost:3306/";
public  static Statement stmt = null;
public  static Connection con = null;

public Utilities() {

try
{
	Class.forName(Driver);
} catch (ClassNotFoundException e) {
	System.out.println(e);
}
try 
{
	con = DriverManager.getConnection(connectionURL+
			DBname,user,pswd);
	stmt=con.createStatement();
	System.out.println("connected to:" + con); 
	System.out.println("COnnected");
} 
catch (SQLException e) {
	System.out.println(e);
}
}

public static  Date DateConverter (String date) throws ParseException {
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date utilDate = formatter.parse(date);
java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
return sqlDate;
}
public static String hasher (String st) {
	String f = "";
	for (int i = 0; i <st.length(); i++) {
		f += (st.charAt(i)*7)*17;
	}
	return f;
}

public static Time TimeConverter (String time) throws ParseException {
SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
java.sql.Time t_val =  new java.sql.Time(formatter.parse(time).getTime());
return t_val;
}



/**
 * Loader txt file information 
 * Paste the location for flight_data.text  <- the file that landon updated  
 
public static String fileLoc ="'C:/Users/Mishuk/Documents/SQL Printout/Flights.txt'";	
public static String Loader = "LOAD DATA LOCAL INFILE "+fileLoc
+" into table Flights columns terminated by ' '";
*/
}