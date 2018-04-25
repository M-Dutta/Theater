package containers;
import java.sql.Statement;

public class UnregisteredUser extends Utilities {
	public String emailAddr;
	public String fName;
	public String lName;
	public int emailPrefs;
	public CreditCardInfo payinfo;
	
	public void register(Statement s, String email) {
		
	}
}
