package containers;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

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
			System.out.println("addPromoCode"+e);
		}
	}
		public void getPromoCode(Statement s, String promo_code) {
			try {
				ResultSet r =s.executeQuery("Select * from promo_code where promo_code = '"+promo_code+"'" );
				r.next();
				this.promo_code = r.getString(1);
				this.discount_percent = r.getDouble(2);
				this.exp_date = Utilities.DateConverter(r.getString(3));
			} catch (SQLException | ParseException e) {
				System.out.println("getPromoCode   "+e);
			}	
		}
			public void removePromoCode(Statement s) {	
				try {
					s.executeUpdate("Delete from promo_code where promo_code = '"+this.promo_code+"'" );
				} catch (SQLException e) {
					System.out.println("deletePromo"+e);
					e.printStackTrace();
				}
	}
			public void changePromoCode(Statement s, PromoCode p) {
				try {
					s.executeUpdate("Update promo_code set discount_percent ="+l+
							this.discount_percent+"',exp_date='"+this.exp_date+"' where promo_code ='"+p.promo_code+"'");
				} catch (SQLException e) {
					System.out.println("changePromoCode"+e);
				}	

			}
}

