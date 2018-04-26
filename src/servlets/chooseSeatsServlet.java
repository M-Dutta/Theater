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

public class chooseSeatsServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
	
	if (request.getParameter("browse") != null)
	{
		response.sendRedirect("homepage.html");	
	}
	if (request.getParameter("checkout") != null)
	{
		String movieName = request.getParameter("checkout");
		String seatNum = request.getParameter("seat");
		String seatType = request.getParameter("seatType");
		request.setAttribute("name", movieName);
		request.setAttribute("seat", seatNum);
		request.setAttribute("type", seatType);
		request.getRequestDispatcher("checkout.jsp").forward(request, response);
	}
}
}
