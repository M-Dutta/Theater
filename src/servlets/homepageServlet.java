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

public class homepageServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
	
	if (request.getParameter("viewDetails") != null)
	{
		String movieName = request.getParameter("viewDetails");
		request.setAttribute("name", movieName);
		request.getRequestDispatcher("viewDetails.jsp").forward(request, response);
		
	
	}
	if (request.getParameter("bookTickets") != null)
	{
		String movieName = request.getParameter("viewDetails");
		request.setAttribute("name", movieName);
		request.getRequestDispatcher("bookTickets.jsp").forward(request, response);
		
	}
}
}