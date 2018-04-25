package containers;
import java.sql.SQLException;
import java.sql.Statement;

public class RegularEmployee extends Utilities {
	
	public int regularId;
	public String diesignation;
	
	public void login(String id, String password) {
		
	}
	
	public void logout() {
		
	}
	
	public void changePassword(Statement s) {
		//NAN place Holder
	}
	
	public void addUser(Statement s,User registeredUser) {
		registeredUser.register(s);
	}
	
	public void changeUserInfo(Statement s,String userEmail,String field,String info, int n) {
		User u = new User();
		u.getUser(s,userEmail);
		u.changeInfo(s, field, info, n);
	}
	
	public Tickets modifyTickets(Tickets ticket) {
		return ticket;
	}
}
