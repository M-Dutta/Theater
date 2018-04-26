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
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EditUserServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
	String originalEmail = request.getParameter("Email");
	User u = new User();
	u.getUser(Utilities.stmt,originalEmail);
	if (request.getParameter("save") != null)
	{
		String id = request.getParameter("id");
		String email = request.getParameter("Email");
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String date = request.getParameter("Date");
		try {
			u.changeInfo(Utilities.stmt,"fname" , FirstName, 0);
			u.changeInfo(Utilities.stmt,"lname" , LastName, 0);
			u.changeInfo(Utilities.stmt,"email" , email, 0); // 1 means INT value
			u.changeInfo(Utilities.stmt,"birthdate" , date, 5); // 5 means Date
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("adminUserDetails.jsp");
	}
	
	if (request.getParameter("back") != null)
	{
		response.sendRedirect("adminUserDetails.jsp");	
	}
	
	if (request.getParameter("saveNew") != null)
	{
		String email = request.getParameter("Email");
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String Password = request.getParameter("Password");
		String date = request.getParameter("Date");
	
		try {
			User nU = new User( email, Password, FirstName, LastName, "phone",Utilities.DateConverter(date) ,0, 0, "Blank", "Blank","Blank",0);
			nU.register(Utilities.stmt);
			System.out.println("Email: "+nU.email); 
			response.sendRedirect("adminUserDetails.jsp");
			} 
		catch (ParseException e)
			{
			System.out.println("edit user servlet add new");
			e.printStackTrace();
			}
		
	}
	
	
	
}
}
