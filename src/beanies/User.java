package beanies;
import containers.Utilities;
import containers.CreditCardInfo;
import java.sql.Date; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class User extends Utilities {
	public String email;
	public String Password;
	public String fName;
	public String lName;
	public String phone;
	public Date birthDate;
	public int emailPref;
	public int status;
	public String street;
	public String city;
	public String state;
	public int zip;
	
	String l= "'"; //Use these to make life easier while formatting
	String L = "','";
	
	
	public User() 
	{
		// TODO Auto-generated constructor stub
	}
	
	// Create user 
	public User( String email,String Password, String fName,
	String lName,String phone,Date birthDate ,int emailPref, int status,
	String street, String city, String state,int zip)	
	{
			this.email= email;
	        this.Password = Password;
	        this.fName =  fName;
	        this.lName=  lName;
	        this.phone = phone;
	        this.birthDate = birthDate;
	        this.emailPref= emailPref;
	        this.status = status;
	        this.street =  street;
	        this.city=  city;
	        this.state = state;
	        this.zip=   zip;
	}
	
	//Selecting user ---- Only use if user is registered
	public void getUser(Statement s, String email)
	{
		try 
		{
			
			ResultSet r = s.executeQuery("SELECT * from user WHERE email="+l+email+l);
			r.next();
	        this.email= r.getString(1);
	        this.phone = r.getString(2);
	        this.fName =  r.getString(3);
	        this.lName=  r.getString(4);
	        this.Password = r.getString(5);
	        this.birthDate = r.getDate(6);
	        this.emailPref= r.getInt(7);
	        this.status = r.getInt(8);
	        this.street =  r.getString(9);
	        this.city=  r.getString(10);
	        this.state = r.getString(11);
	        this.zip=   r.getInt(12);
		}
	
		catch (SQLException e) 
		{
			System.out.println("Getuser "+ e);
		}
		
		
	}
	
	public void setEmail(String string)
	{
		this.email = string;
	}
	
	public void setFirstName(String string)
	{
		this.fName = string;
	}
	
	public void setLastName(String string)
	{
		this.lName = string;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getFirstName()
	{
		return this.fName;
	}
	
	public String getLastName()
	{
		return this.lName;
	}
	
	//Create user then call user.register(s)
	public void register(Statement s)
	{
		try 
		{
		s.executeUpdate("Insert into user values("+l+email+L+fName+L+lName+L+phone+L+Password+L+birthDate+L+emailPref+
				L+status+L+street+L+city+L+state+L+zip+l+")");
		}
		
		catch (SQLException e) 
		{
			System.out.println("register "+ e);
		}
	}
	
	
	public void login(Statement s, String  email, String password) 
	{
		User u = new User();
		u.getUser( s,  email);
		if (u.status > 0) 
		{
			if (u.Password.equals(Utilities.hasher(password))) 
			{
				u.changeInfo(Utilities.stmt, "status","2", 1); //Status 2 = logged In // 1 = verified
				System.out.println("Logged In");
			}
			else 
			{
				System.out.println("NOPE");
			}
		}
		else 
		{
			System.out.println("Unverified Email");
		}
	}
	
	
	public void logout(Statement s) 
	{
		this.changeInfo(s, "status", "1", 1);
		System.out.println("Set User Status " + this.email  +  " " +this.status+" "  );
		
	}
	
	//user.changeInfo(s, field,info, n)
	public void changeInfo(Statement s, String field, String info,int n ) 
	{
		try 
		{
			if (n == 0) 
			{
				s.executeUpdate("Update user "+ "SET "+field+"="+l+info+l + "WHERE email="  +l+email+l); 
			}
			else 
			{
				s.executeUpdate("Update user "+ "SET "+field+"="+l+Integer.parseInt(info)+l + "WHERE email="  +l+email+l) ;
				System.out.println("Print Info "+ info);
			}
		}
		catch (SQLException e) 
		{
			System.out.println("Change INfo "+ e);
		}
	}
	
	//user.ChangePassword(s, passwd)
	public void changePassword(Statement s, String passwd) 
	{
		try 
		{
			s.executeUpdate("Update user SET password ="+l+passwd+l+" WHERE email="+l+email+l);								
		}
		catch (SQLException e) 
		{
			System.out.println("savePayment "+ e);
		}
	}
	
	public void changeEmail(Statement s, String emailAddr) 
	{
		try 
		{
			s.executeUpdate("Update user SET email="+l+emailAddr+l+" WHERE email="+l+email+l);
		}
		catch (SQLException e) 
		{
			System.out.println("savePayment "+ e);
		}
	}
	
	//should we be saving the security codes? === NOPE. Will fix that in the DB
	public void savePayment(Statement s, CreditCardInfo c ) {
		try {
	s.executeUpdate("insert into payment_info" + 
			" values("+ l+c.email_id+L+c.cardName +L+c.cardNumber +L+c.cardHolderName+
			L+c.expDate+L+c.street+L+c.city+L+c.state+L+c.zip+"')" );
	}
	catch (SQLException e) {
		System.out.println("savePayment "+ e);
		}
	}
	//Get PAyment Method
	public CreditCardInfo getPayment(Statement s, String cardName, int cardNumber) {	
		CreditCardInfo c= new CreditCardInfo();
		c.getCreditCardInfo(s, this.email,  cardName,  cardNumber);
		return c;
	
	} 
	
	public void viewPurchase(Statement s) {
		try {
		ResultSet r = s.executeQuery("Select t.ticket_id, m.movie_name, t.movie_id,t.date, t.time "+
					     "FROM ticket as t, registered_tickets as rt,movie as m "+
					     "WHERE rt.user_email="+l+email+l);
		String h = " ";
		while (r.next()) {
			System.out.print(r.getInt(1)+h+r.getString(2)+h+r.getDate(3)+h+ r.getTime(4) );
			}
		}
		catch (SQLException e) {
		System.out.println("savePayment "+ e);
	}
	}
	
	public void RegistrationEmail(Statement s)	
	{
		 // Recipient's email ID needs to be mentioned.
		   String to =  this.email;
		   System.out.println("this is Sent to :"+ to);
		   int key =0;
		   try 
		   {
			   s.executeUpdate("Insert into verify(email) values("+l+email+l+")");
		   } 
		   catch (SQLException e) 
		   {
			// TODO Auto-generated catch block
			   e.printStackTrace();
		   }
		 try 
		 {
			ResultSet r = s.executeQuery("Select * from verify as v where v.email="+l+email+l);
			r.next();
			key = r.getInt(2);
			
		 } 
		 catch (SQLException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 } 
		   
		   
		 // Sender's email ID needs to be mentioned
		 String from = "theater_3@outlook.com";

		 // Assuming you are sending email from localhost
		 String host = "localhost";

		 // Get system properties
		 Properties properties = System.getProperties();

		 properties.setProperty("mail.user", "theater_3@outlook.com");
		 properties.setProperty("mail.password", "securePassword");
		   
		 // Setup mail server
		 properties.setProperty("mail.smtp.host", host);

		 // Get the default Session object.
		 Session session = Session.getDefaultInstance(properties);

		 try 
		 {
		      // Create a default MimeMessage object.
		      MimeMessage message = new MimeMessage(session);

		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress(from));

		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		      // Set Subject: header field
		      message.setSubject("Register Confirmation");

		      // Now set the actual message
		      message.setText("This is your registration verification Code to confirm registration: "+ key);

		      // Send message
		      Transport.send(message);
		      System.out.println("Sent message successfully....");
		   } 
		 catch (MessagingException mex) 
		 {
		      mex.printStackTrace();
		  }
	}

	public void ResetPasswordEmail(Statement s, String email) 
	{
			User u = new User();
			u.getUser(s, email);
			// Recipient's email ID needs to be mentioned.
			String to =  u.email ;//"theater_3@outlook.com";
			System.out.println("this is sent To :"+ to);
			int key = 0;
			try 
			{
				s.executeUpdate("Insert into resets(email) values("+l+email+l+")");
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try 
			{
				ResultSet r = s.executeQuery("Select * from resets as r where r.email="+l+email+l);
				r.next();
				key = r.getInt(2);
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		   

			// Sender's email ID needs to be mentioned
			String from = "theater_3@outlook.com";

			// Assuming you are sending email from localhost
			String host = "localhost";

			// Get system properties
			Properties properties = System.getProperties();

			properties.setProperty("mail.user", "theater_3@outlook.com");
			properties.setProperty("mail.password", "securePassword");
		   
			// Setup mail server
			properties.setProperty("mail.smtp.host", host);
		   
			// Get the default Session object.
			Session session = Session.getDefaultInstance(properties);

			try
			{
				// Create a default MimeMessage object.
				MimeMessage message = new MimeMessage(session);

				// Set From: header field of the header.
				message.setFrom(new InternetAddress(from));

				// Set To: header field of the header.
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

				// Set Subject: header field
				message.setSubject("Password Reset");
		      
				// Now set the actual message
				message.setText("This is your Verification number :"+ key);
		      
				// Send message
				Transport.send(message);
				System.out.println("Sent message successfully....");
			} 
			catch (MessagingException mex) 
			{
		      mex.printStackTrace();
			}
	}
	
	
		
	

}
