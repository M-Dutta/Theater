package servlets;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import containers.Admin;
import containers.User;
import containers.Utilities;

public class AdminUserServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
	
	if (request.getParameter("edit") != null)
	{
		String email = request.getParameter("edit");
		User u = new User();
		u.getUser(Utilities.stmt, email); 
		//response.sendRedirect("editUserDetails.html?Email="+email);	
		//RequestDispatcher dispatcher = request.getRequestDispatcher("editUserDetails.jsp");
		request.setAttribute("Email", u.email);
		request.setAttribute("FirstName", u.fName);
		request.setAttribute("LastName", u.lName);
		request.setAttribute("Date", u.birthDate);
		request.getRequestDispatcher("editUserDetails.jsp").forward(request, response);
		
	}
	if (request.getParameter("remove") != null)
	{	
		String email = request.getParameter("remove");
		System.out.println("EMAIL:  "+email);
		Admin a = new Admin(0,"","","", 0);
		User u = new User();
		u.getUser(Utilities.stmt, email);
		System.out.println(u.email);
		System.out.println(u.fName);
		try {
			Utilities.stmt.executeUpdate("DELETE from verify where email= '"+ email+"'");
			Utilities.stmt.executeUpdate("DELETE from resets where email= '"+ email+"'");
			a.removeUser(Utilities.stmt, u);
		} catch (SQLException e) {
			System.out.println("Admin User Servlet Remove");
		}
		response.sendRedirect("adminUserDetails.jsp");
		
	}
	if (request.getParameter("add") != null)
	{
		response.sendRedirect("addUser.html");	
	}
	if (request.getParameter("options") != null)
	{
		response.sendRedirect("adminOptions.html");	
	}
	
}
}
