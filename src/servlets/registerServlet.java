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

public class registerServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	ServletConfig config = this.getServletConfig();
	ServletContext ctx = config.getServletContext();
	RequestDispatcher dispatcher = ctx.getRequestDispatcher("/errMessage.html");
	
    // Set the response message's MIME type
    response.setContentType("text/html; charset=UTF-8");
    // Allocate a output writer to write the response message into the network socket
    //PrintWriter out = response.getWriter();
    
  	  String fName = request.getParameter("firstName");
  	  String lName = request.getParameter("lastName");
  	  String email = request.getParameter("email");
  	  String Password = request.getParameter("Password");
  	  String passConfirm = request.getParameter("passConfirm");
  	  String[] checkbox = request.getParameterValues("checkbox");
  	  String date = request.getParameter("date");
  	  int pref = 0;
  	  if (checkbox!=null) {
  		  pref = 1;
  	  }
  	
    System.out.println("Name " +fName);
    System.out.println("Lname " +lName);
    System.out.println("email " +email);
    System.out.println("pass " +Password);
    System.out.println("pass " +passConfirm);
    System.out.println("cb " +checkbox);
    
    if (Password.equals(passConfirm)) 
    {
  	  Password = Utilities.hasher(Password);  

   
	try {
		User nU = new User( email, Password,  fName, lName, "phone",Utilities.DateConverter(date) ,pref, 0, "Blank", "Blank","Blank",0);
		nU.register(Utilities.stmt);
		System.out.println("Email: "+nU.email);
		
		} 
	catch (ParseException e)
		{
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	response.sendRedirect("verifyEmail.html");
	
		
    }
	
	else
	{
		
	}
	
    
  //  dispatcher.forward(request, response);
	}
}	


