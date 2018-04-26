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

public class EditEmployeeServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
	String OriginalID = request.getParameter("id");
	Employee e = new Employee();
	e.getEmployee(Utilities.stmt, Integer.parseInt(OriginalID));
	if (request.getParameter("save") != null)
	{	
		String id = request.getParameter("id");
		String FirstName = request.getParameter("fname");
		String LastName = request.getParameter("lname");
		String designation = request.getParameter("designation");
		e.changeInfo(Utilities.stmt, "id", id, 1);
		e.changeInfo(Utilities.stmt, "fname", FirstName, 0);
		e.changeInfo(Utilities.stmt, "lname", LastName, 0);
		e.changeInfo(Utilities.stmt, "designation", designation, 0);
		response.sendRedirect("adminEmployeeInfo.jsp");
	}
	
	if (request.getParameter("back") != null)
	{
		response.sendRedirect("adminEmployeeInfo.jsp");	
	}
	
	if (request.getParameter("saveNew") != null)
	{
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String SSN = request.getParameter("SSN");
		String Street = request.getParameter("Street");
		String City = request.getParameter("City");
		String State = request.getParameter("State");
		String zip = request.getParameter("zip");
		String Status = request.getParameter("Status");
		String Designation = request.getParameter("Designation");
		Employee e2 = new Employee(0,Integer.parseInt(SSN),FirstName,LastName,Street,City,State,
				Integer.parseInt(zip),Integer.parseInt(Status),Designation);
		Admin a = new Admin(0,"","","",0);
		a.addEmployee(Utilities.stmt,e2);
		
		
	}
	
	
}
}