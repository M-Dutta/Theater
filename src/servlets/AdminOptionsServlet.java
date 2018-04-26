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

public class AdminOptionsServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
	
	if (request.getParameter("movie") != null)
	{
		response.sendRedirect("adminDisplayMovies.jsp");	
	}
	if (request.getParameter("user") != null)
	{	
		response.sendRedirect("adminUserDetails.jsp");	
	}
	if (request.getParameter("employee") != null)
	{
		response.sendRedirect("adminEmployeeInfo.jsp");	
	}
	if (request.getParameter("promo") != null)
	{
		response.sendRedirect("adminPromoDetails.jsp");	
	}
	if (request.getParameter("reports") != null)
	{
		response.sendRedirect("adminReports.jsp");	
	}
	
}
}

