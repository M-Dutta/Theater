package beanies;
import containers.Utilities;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PromoList extends Utilities implements Serializable {

	ArrayList<PromoCode> PromoList = new ArrayList<PromoCode>();
	
	public PromoList() throws ClassNotFoundException, SQLException
	{
		
	}
	
	public ArrayList<PromoCode> getPromoList() throws SQLException
	{
		PreparedStatement stmt = Utilities.con.prepareStatement("SELECT promo_code from promo_code");
		ResultSet promoRs = stmt.executeQuery();
		
		while(promoRs.next())
		{
			//get id
			String promo = promoRs.getString(1);
			
			//get first name
			PreparedStatement stmt2 = Utilities.con.prepareStatement("SELECT discount_percent from promo_code WHERE promo_code=?");
			stmt2.setString(1, promo);
			ResultSet discountRs = stmt2.executeQuery();
			double discount = 0;
			if (discountRs.next())
			{
				discount = discountRs.getDouble(1);
			}
			
			//get last name
			PreparedStatement stmt3 = Utilities.con.prepareStatement("SELECT exp_date from promo_code WHERE promo_code=?");
			stmt3.setString(1, promo);
			ResultSet dateRs = stmt3.executeQuery();
			Date date = null;
			if (dateRs.next())
			{
				date = dateRs.getDate(1);
			}
			
			
			PromoCode promoCode = new PromoCode();
			promoCode.setPromo(promo);
			promoCode.setDiscount(discount);
			promoCode.setDate(date);
			
			PromoList.add(promoCode);
		}
		
		return PromoList;
	}
}
