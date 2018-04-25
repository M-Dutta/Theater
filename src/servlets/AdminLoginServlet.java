package servlets;
import containers.*;
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminLoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	 response.setContentType("text/html; charset=UTF-8");
	 int id = Integer.parseInt(request.getParameter("AdminID") );
 	 String password = request.getParameter("password");
 	 Admin a = new Admin();
 	 a.getAdmin(Utilities.stmt, id);
 	 if (a.adminPassword.equals(password)) {
 		 a.Adminlogin(a.adminId, a.adminPassword);
 		 response.sendRedirect("adminOptions.html");
 	 }
 	 else {
 		response.sendRedirect("adminLogin.html");
 	 }
	

	}
}	
