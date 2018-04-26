package servlets;

import java.io.IOException;
import java.sql.Statement;
import java.text.ParseException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import containers.Admin;
import containers.Employee;
import containers.Utilities;

public class AdminEmployeeServlet extends HttpServlet {
 

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
		int id = Integer.parseInt(request.getParameter("edit"));
		//RequestDispatcher dispatcher = request.getRequestDispatcher("editEmployeeDetails.jsp");
		Employee e = new Employee();
		System.out.println(e.id);
		e.getEmployee(Utilities.stmt, id);
		request.setAttribute("id", e.id);
		request.setAttribute("fname", e.fName);
		request.setAttribute("lname", e.lName);
		request.setAttribute("designation", e.designation);
		request.getRequestDispatcher("editEmployeeDetails.jsp").forward(request, response);
	
	}
	if (request.getParameter("remove") != null)
	{	
		int id = Integer.parseInt(request.getParameter("remove"));
		Employee e = new Employee();
		e.getEmployee(Utilities.stmt, id);
		Admin a = new Admin(0,"","","", 0);
		a.RemoveEmployee(Utilities.stmt, e);
		response.sendRedirect("adminEmployeeInfo.jsp");	
	}
	if (request.getParameter("add") != null)
	{
		response.sendRedirect("addEmployee.html");	
	}
	if (request.getParameter("options") != null)
	{
		response.sendRedirect("adminOptions.html");	
	}
	
}
}
