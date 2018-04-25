package beanies;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {
	public int id;
	public int ssn;
	public String fName;
	public String lName;
	public String street;
	public String city;
	public String state;
	public int zip;
	public int stat;
	public String designation;
	String l= "'"; //Use these to make life easier while formatting
	String L = "','";
	
	
	public Employee() {}
	
	public Employee(int id, int ssn, String fName, String lName, String street, String city, String state, int zip, int stat, String designation) {
		this.id = id;
		this.ssn = ssn;
		this.fName = fName;
		this.lName = lName;
		this.street = street;
		this.city =city;
		this.state = state;
		this.zip = zip;
		this.stat = stat;
		this.designation = designation;
	}

	
	
	public void setFirstName(String string)
	{
		this.fName = string;
	}
	
	public void setLastName(String string)
	{
		this.lName = string;
	}
	
	
	public void setId(int num)
	{
		this.id = num;
	}
	
	public String getFirstName()
	{
		return this.fName;
	}
	
	public String getLastName()
	{
		return this.lName;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public void getEmployee(Statement s, int id) {
		try {
			ResultSet r = s.executeQuery("SELECT * from users WHERE id="+l+id+l);
			
		        this.id= r.getInt(1);
		        this.ssn = r.getInt(2);
		        this.fName =  r.getString(3);
		        this.lName=  r.getString(4);
		        this.street = r.getString(5);
		        this.city = r.getString(6);
		        this.state = r.getString(7);
		        this.zip=   r.getInt(8);
		        this.stat = r.getInt(9);
		        this.designation = r.getString(10);
			}
		
			catch (SQLException e) {
			System.out.println("savePayment "+ e);
			}
			
			
	}
	
	
	public void login(String emailAddr, String Password) {
		
	}
	
	public void logout() {
		
	}
	
	public void changeInfo(Statement s, String field, String info,int n ) {
		try {
		if (n == 0) 
			{
			s.executeUpdate("Update employee "+ 
				"SET "+field+"="+l+info+l + 
				"WHERE id="  +l+id+l); 
			}
		else 
			{
			s.executeUpdate("Update Users "+ 
				"SET "+field+"="+l+info+l + 
				"WHERE id="  +l+id+l) ;
			}
		}
		catch (SQLException e) 
		{
			System.out.println("savePayment "+ e);
		}
	}
		
	public void changePassword(Statement s, String passwd) {
		try {
		s.executeUpdate("Update Users SET password ="+l+passwd+l+" WHERE id="+l+id+l);								
		}
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	}		
}
