package servlets;
import containers.*; 
import java.io.IOException; 

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class signInServlet extends HttpServlet {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static User globaluser = new User();
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	//Check if Signin is clicked
	if (request.getParameter("sign") != null) {
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	User nU = new User();
	nU.getUser(Utilities.stmt, email);
	if (nU.status == 0) {
		response.sendRedirect("verifyEmail.html");
	}
	else {
	nU.login(Utilities.stmt, email, password);
	globaluser = nU;
	System.out.println("Sign-In");
	response.sendRedirect("homepage.html"); ////////THIS <======
	}
	
	}	
	if (request.getParameter("forgot") != null) {
		String email = request.getParameter("email");
		User nU = new User();
		nU.ResetPasswordEmail(Utilities.stmt, email);
		System.out.println("Forgot Password");
		response.sendRedirect("resetPassword.html");  ////////THIS <======
		}
	//Check if register is clicked
	
	if (request.getParameter("register") != null) {
		System.out.println("Register");
		response.sendRedirect("register.html");  ////////THIS <======
		}	
	
	
	}
}	
