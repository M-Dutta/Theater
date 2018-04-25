package containers;
import java.sql.ResultSet; 
import java.sql.SQLException;
import java.sql.Statement;

public class Admin extends Utilities{
	public int adminId;
	public String designation;
	public String adminEmail;
	public String adminPassword;
	public int adminstatus;
	String l = "'";
	String L = "','";
	
	public Admin(int adminId, String designation, String adminEmail, String adminPassword,int adminStatus) {
		this.adminId = adminId;
		this.designation =designation;
		this.adminEmail = adminEmail;
		this.adminPassword = adminPassword;
		this.adminstatus = adminStatus;
	}
	public Admin() {}
	
	public void getAdmin(Statement s, int id) {
	try {
		ResultSet r = s.executeQuery("SELECT * from admin WHERE admin_id="+l+id+l);
		r.next();
		this.adminId = r.getInt(1);
		this.designation = r.getString(2);
		this.adminEmail = r.getString(3);
		this.adminPassword = r.getString(4);
		this.adminstatus = r.getInt(5);
	}
		
	catch (SQLException e) {
		System.out.println("getAdmin "+ e);
		}
	}
	
	public void Adminlogin(int id, String password) {
	Admin a = new Admin();
	a.getAdmin(Utilities.stmt, id);
	if (a.adminPassword.equals(password) ) {
		try {
			Utilities.stmt.executeUpdate("Update Admin SET status = 2 WHERE admin_id="+ adminId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	}
	
	public void Adminlogout(Statement s){
		try {
			Utilities.stmt.executeUpdate("Update Admin SET status = 1 WHERE admin_id="+ adminId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

	public void changePassword(Statement s, String passwd) {
		try {
		s.executeUpdate("Update Admin SET admin_password ="+l+passwd+l+" WHERE admin_id="+ adminId);						
		}
		catch (SQLException e) {
		System.out.println("AdminChangePassword "+ e);
	}
		
	}

	public void changeUserInfo(Statement s,String userEmail,String field,String info, int n) {
		User u = new User();
		u.getUser(s,userEmail);
		u.changeInfo(s, field, info, n);
		
		
	}

	//idk what the parameters are supposed to be
	public void forceResetPassword(Statement s, int n, Object obj) {

			if (n ==0) {
				User u = new User();
				u.getUser(s, (String) obj);
				//Send password link
			}
			else  {
				Employee emp = new Employee();
				emp.getEmployee(s, (int) obj);
				//Send Password Link		
			}
	}
		
 
	
	public void changeEmployeeInfo(Statement s,int id,String field,String info, int n) {
		Employee emp = new Employee();
		emp.getEmployee(s,id);
		emp.changeInfo(s, field, info, n);
	}
	
	public void addUser(Statement s,User registeredUser) {
		registeredUser.register(s);
	}
	
	public void addEmployee(Statement s, Employee employee){
		try {
			
			s.executeUpdate("insert into employee(ssn,fname,lname,street,city,state,zip,stat,designation)"
					+ "values ("+l+employee.ssn+L+employee.fName+L+employee.lName+L+employee.street+L+employee.city+L+employee.state
					+L+employee.zip+L+employee.stat+L+employee.designation+l+")");
			}
			
			catch (SQLException e) {
			System.out.println("addEmployee "+ e);
			}
	}
	
	public void addManager(Statement s,Manager manager){
		try {
			s.executeUpdate("Insert into manager values("+l+manager.managerId+L+manager.designation+L+manager.managerEmail+
					L+manager.managerPassword+l+")");
			}
			
			catch (SQLException e) {
			System.out.println("addManager "+ e);
			}
		
		
	}
	
	public void addMovie(Statement s,Movie_info movie){
		movie.add(s);
	
	}
	
	public void changeMovieInfo(Statement s, Movie_info m,String field, String info,int n ) {
		m.edit( s, field, info, n);
	}
	
	public void removeMovie(Statement s,Movie_info movie) {
		movie.remove(s);
	}
	
	public void removeUser(Statement s,User registeredUser) {
		try {
			s.executeUpdate("DELETE from user WHERE id email="+l+registeredUser.email+l );
			}
			
			catch (SQLException e) {
			System.out.println("remove user "+ e);
			}
		
		
	}
	
	public void RemoveEmployee(Statement s,Employee employee){
		try {
			s.executeUpdate("DELETE from employee WHERE id ="+l+employee.id+l );
			}
			
			catch (SQLException e) {
			System.out.println("remove employee "+ e);
			}
		
	}
	
	public void removeManager(Statement s, Manager manager) {
		try {
			s.executeUpdate("DELETE from manager WHERE manager_id ="+l+manager.managerId+l );
			}
			
			catch (SQLException e) {
			System.out.println("remove manager "+ e);
			}
	}
	
	public void addPromoCode(PromoCode code) {
		
		
	}
	
	public void removePromoCode(Statement s, PromoCode code) {
		try {
			s.executeUpdate("DELETE from promo_code WHERE promocode ="+l+code.promo_code+l );
			}
			
			catch (SQLException e) {
			System.out.println(" removePromoCode "+ e);
			}
	
		
	}
	
}
