package servlets;
import containers.*;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResetServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
    response.setContentType("text/html; charset=UTF-8");
    
      String email = request.getParameter("email");
  	  int resetID = Integer.parseInt(request.getParameter("verification"));
  	  String newPassword = request.getParameter("newPassword");
  	  String confirmPassword = request.getParameter("confirmPassword");
    
  	  if (newPassword.equals(confirmPassword)) 
  	  {
    	newPassword = Utilities.hasher(newPassword);    
    	User u = new User();
    	u.getUser(Utilities.stmt, email);
    	try {
    		ResultSet r = Utilities.stmt.executeQuery("select * from resets where resetID="+ resetID);
    		r.next();
    		if (email.equals(r.getString(1) ) && resetID == r.getInt(2) ) {
    			u.getUser(Utilities.stmt, email);
    			u.changePassword(Utilities.stmt, newPassword);
    			response.sendRedirect("homepage.html");
    			System.out.println("Password Reset");
    			Utilities.stmt.executeUpdate("DELETE from resets where resetID="+ resetID);
    			
    		}
    	} catch (SQLException e) {
		e.printStackTrace();
    	}
    }
	
	
    
  //  dispatcher.forward(request, response);
	}
}	


