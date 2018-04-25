package servlets;
import containers.*;
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ManagerLoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	 response.setContentType("text/html; charset=UTF-8");
	 int id = Integer.parseInt(request.getParameter("ManagerID") );
 	 String password = request.getParameter("password");
 	 System.out.println(id+"  "+ password);
 	 Manager m= new Manager();
 	 m.getManager(Utilities.stmt, id);
 	 if (m.managerPassword.equals(password)) {
 		  m.managerlogin(m.managerId, m.managerPassword);
 		 response.sendRedirect("adminOptions.html");
 	 }
 	 else {
 		response.sendRedirect("ManagerLogin.html");
 	 }
	

	}
}	
