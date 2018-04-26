package servlets;
import containers.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerifyEmailServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
    response.setContentType("text/html; charset=UTF-8");
    
      String email = request.getParameter("email");
  	  int verifID = Integer.parseInt(request.getParameter("verification"));
  	User u = new User();
	u.getUser(Utilities.stmt, email);
    try 
    {
    	ResultSet r = Utilities.stmt.executeQuery("select * from verify as v where v.verifyID="+ verifID);
    		r.next();
    		if (email.equals(r.getString(1) ) && verifID == r.getInt(2) ) {
    			u.getUser(Utilities.stmt, email);
    			Admin a = new Admin(0,"","","",0);
    			u.changeInfo(Utilities.stmt, "status", "1", 1);
    			u.changeInfo(Utilities.stmt, "id",u.fName+Integer.toString(verifID) , 0);
    			System.out.println("Confirmed");
    			u.RegistrationConfirmation(Utilities.stmt,u.fName+Integer.toString(verifID));
    			Utilities.stmt.executeUpdate("DELETE from verify where email= '"+ email+"'");
    			
    			response.sendRedirect("accountConfirmation.html");
    		}
    		else {
    			response.sendRedirect("verifyEmail.html");
    		}
    		
    	} catch (SQLException e) {
		e.printStackTrace();
    	} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
    
  //  dispatcher.forward(request, response);
}
	


