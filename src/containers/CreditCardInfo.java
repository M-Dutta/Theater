package containers;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreditCardInfo extends Utilities {
	public String email_id;
	public String cardName;
	public int cardNumber;
	public String cardHolderName;
	public String expDate;
	public String street;
	public String city;
	public String state;
	public int zip;
	String l="'";
	String L= "',";
	String x ="' and ";
	
	public CreditCardInfo(Statement s, CreditCardInfo c) {
		
	}
	
	public CreditCardInfo(String cardName, User u, int cardNumber,String cardHolderName,String expDate,String street,
						String city,String state,int zip) 
	{
		this.email_id = u.email;
		this.cardName = cardName;
		this.cardNumber =cardNumber;
		this.cardHolderName= cardHolderName;
		this.expDate=expDate;
		this.street=expDate;
		this.city=city;
		this.state=state;
		this.zip=zip;
	}
	public CreditCardInfo() {}
	
	public void getCreditCardInfo( Statement s, String email, String cardName, int cardNumber)
	{
		try {
			ResultSet r =s.executeQuery("Select * FROM  payment_info WHERE email_id="+l+email+x+"card_name="+l+cardName+x+"card_number="+l+cardNumber+l);
			this.email_id = r.getString(1);
			this.cardName = r.getString(2);
			this.cardNumber =r.getInt(3);
			this.cardHolderName= r.getString(4);
			this.expDate=r.getString(5);
			this.street=r.getString(6);
			this.city=r.getString(7);
			this.state=r.getString(8);
			this.zip=r.getInt(9);
		}
		catch (SQLException e) {
			System.out.println("savePayment "+ e);
		}
			
	}

}

