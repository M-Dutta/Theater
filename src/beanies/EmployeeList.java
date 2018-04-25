package beanies;
import containers.Utilities;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeList extends Utilities implements Serializable {

	ArrayList<Employee> EmployeeList = new ArrayList<Employee>();
	
	public EmployeeList() throws ClassNotFoundException, SQLException
	{
		
	}
	
	public ArrayList<Employee> getEmployeeList() throws SQLException
	{
		PreparedStatement stmt = Utilities.con.prepareStatement("SELECT id from employee");
		ResultSet idRs = stmt.executeQuery();
		
		while(idRs.next())
		{
			//get id
			int id = idRs.getInt(1);
			
			//get first name
			PreparedStatement stmt2 = Utilities.con.prepareStatement("SELECT fname from employee WHERE id=?");
			stmt2.setInt(1, id);
			ResultSet fNameRs = stmt2.executeQuery();
			String fName = "";
			if (fNameRs.next())
			{
				fName = fNameRs.getString(1);
			}
			
			//get last name
			PreparedStatement stmt3 = Utilities.con.prepareStatement("SELECT lname from employee WHERE id=?");
			stmt3.setInt(1, id);
			ResultSet lNameRs = stmt3.executeQuery();
			String lName = "";
			if (lNameRs.next())
			{
				lName = lNameRs.getString(1);
			}
			
			
			Employee employee = new Employee();
			employee.setId(id);
			employee.setFirstName(fName);
			employee.setLastName(lName);
			
			EmployeeList.add(employee);
		}
		
		return EmployeeList;
	}
}
