package containers;
import java.sql.Date; 
import java.sql.SQLException;
import java.sql.Statement;

public class PromoCode extends Utilities {
	public String promo_code;
	public double discount_percent;
	public Date exp_date;
	String l = "'";
	String L = "','";

	public PromoCode() {}
	
	public PromoCode(String promo_code,double discount_percent,Date exp_date) {
		this.promo_code = promo_code;
		this.discount_percent = discount_percent;
		this.exp_date = exp_date;
	}


	public void addPromoCode(Statement s) {
		try {
			System.out.println(this.promo_code);
			System.out.println(this.exp_date);
			System.out.println(this.discount_percent);
			s.executeUpdate("INSERT into promo_code values("+l+this.promo_code+L+this.discount_percent+L+this.exp_date+l+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

