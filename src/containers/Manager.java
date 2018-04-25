package containers;
import java.sql.ResultSet;   
import java.sql.SQLException;
import java.sql.Statement;

public class Manager extends Utilities{

	public int managerId;
	public String designation;
	public String managerEmail;
	public String managerPassword;
	public int managerStatus;
	String l = "'";
	String L = "','";
	
	public Manager() {}
	
	public Manager(int  managerId, String designation, String managerEmail, String managerPassword,int managerStatus) {
		this.managerId = managerId;
		this.designation =designation;
		this.managerEmail = managerEmail;
		this.managerPassword = managerPassword;
		this.managerStatus = managerStatus;
	}
	
	public void getManager(Statement s, int id) {
		try {
			System.out.println(id);
			ResultSet r = s.executeQuery("SELECT * from movie_theater.manager where manager_id="+id);
			r.next();
			this.managerId = r.getInt(1);
			this.designation = r.getString(2);
			this.managerEmail = r.getString(3);
			this.managerPassword = r.getString(4);
			this.managerStatus = r.getInt(5);	
		}
		catch(SQLException e) {
			System.out.println("getManager "+ e);
			e.printStackTrace();
			
		}
	}
	
	public void managerlogin(int id, String password) {
		Manager m = new Manager();
		m.getManager(Utilities.stmt, id);
		if (m.managerPassword.equals(password) ) {
			try {
				Utilities.stmt.executeUpdate("Update manager SET status = 2 WHERE manager_id="+ managerId);
			} catch (SQLException e) {
				System.out.println("ManagerLogin "+ e);
			}	
			
		}
	}
	
	
	public void logout(Statement s) {		
		try {
			s.executeUpdate("Update Manager SET status = 1 WHERE manager_id="+ managerId);
		} catch (SQLException e) {
			System.out.println("ManagerLogout "+ e);
		}	
	}
	
	
	public void changePassword(Statement s, String passwd) {
		try {
			s.executeUpdate("Update Users SET password ="+l+passwd+l+" WHERE manager_id="+l+managerId+l);								
			}
			catch (SQLException e) {
			System.out.println("savePayment "+ e);
		}
		
	}
	
	public void addUser(Statement s,User registeredUser) {
		registeredUser.register(s);
	}
	
	
	public void addEmployee(Statement s, Employee employee){
		try {
			s.executeUpdate("Insert into users values("+l+employee.id+L+employee.ssn+L+employee.fName+L+employee.lName+
					L+employee.street+L+employee.city+L+employee.state+L+employee.zip+
					L+employee.stat+L+employee.designation+l+")");
			}
			
			catch (SQLException e) {
			System.out.println("savePayment "+ e);
			}
	}
	
	public void changeUserInfo(Statement s,String userEmail,String field,String info, int n) {
		User u = new User();
		u.getUser(s,userEmail);
		u.changeInfo(s, field, info, n);
		
		
	}

	public void changeEmployeeInfo(Statement s,int id,String field,String info, int n) {
		Employee emp = new Employee();
		emp.getEmployee(s,id);
		emp.changeInfo(s, field, info, n);
	}
	
	public void changeMovieInfo(Movie_info movie){
		
	}
	
}
