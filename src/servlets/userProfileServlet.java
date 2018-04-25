package servlets;
import java.io.IOException; 
import java.text.ParseException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class userProfileServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
		
	if (request.getParameter("update") != null)
	{	
		response.sendRedirect("editUserProfile.html");	
	}
	
	if (request.getParameter("email") != null)
	{	
		response.sendRedirect("editEmailPreferences.html");	
	}
	
	if (request.getParameter("history") != null)
	{	
		response.sendRedirect("purchaseHistory.html");	
	}
	
	if (request.getParameter("saveUpdate") != null)
	{	
		response.sendRedirect("userProfile.html");	
	}
	
	if (request.getParameter("saveEmail") != null)
	{	
		response.sendRedirect("userProfile.html");	
	}
	
	if (request.getParameter("back") != null)
	{	
		response.sendRedirect("userProfile.html");	
	}
	
	
	

}
}
