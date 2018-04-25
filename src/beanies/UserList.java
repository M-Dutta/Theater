package beanies;
import containers.Utilities;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserList extends Utilities implements Serializable {
	
	ArrayList<User> UserList = new ArrayList<User>();
	
	public UserList() throws ClassNotFoundException, SQLException
	{
		
	}
	
	public ArrayList<User> getUserList() throws SQLException
	{
		
		//Utilities.stmt("SELECT email from user");
		PreparedStatement stmt = Utilities.con.prepareStatement("SELECT email from user");
		ResultSet emailRs = stmt.executeQuery();
		
		while(emailRs.next())
		{
			//get email
			String email = emailRs.getString(1);
			
			//get first name
			PreparedStatement stmt2 = Utilities.con.prepareStatement("SELECT fname from user WHERE email=?");
			stmt2.setString(1, email);
			ResultSet fNameRs = stmt2.executeQuery();
			String fName = "";
			if (fNameRs.next())
			{
				fName = fNameRs.getString(1);
			}
			
			//get last name
			PreparedStatement stmt3 = Utilities.con.prepareStatement("SELECT lname from user WHERE email=?");
			stmt3.setString(1, email);
			ResultSet lNameRs = stmt3.executeQuery();
			String lName = "";
			if (lNameRs.next())
			{
				lName = lNameRs.getString(1);
			}
			
			User user = new User();
			user.setEmail(email);
			user.setFirstName(fName);
			user.setLastName(lName);
			UserList.add(user);
			
		}//user list 
		
		return UserList;
	}

}
