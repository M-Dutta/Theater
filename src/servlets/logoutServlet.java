package servlets;
import containers.*;
import java.io.IOException; 
import java.text.ParseException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logoutServlet extends HttpServlet {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
	
	if (request.getParameter("logout") != null)
	{	
		try {
			signInServlet.globaluser.logout(Utilities.stmt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("LogoutServlet");
		}
		response.sendRedirect("logout.html");	
	}

}
}
