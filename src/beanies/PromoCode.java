package beanies;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class PromoCode {
	public String promo_code;
	public double discount_percent;
	public Date exp_date;
	String l = "'";
	String L = "','";

	public PromoCode() {}
	
	public PromoCode(String promo_code, double discount_percent, Date exp_date ) 
	{
		this.promo_code = promo_code;
		this.discount_percent = discount_percent;
		this.exp_date = exp_date;
	}
	
	public void addPromoCode(Statement s, PromoCode p) 
	{
		try 
		{
			s.executeUpdate("INSERT into promo_code values=("+l+promo_code+L+discount_percent+L+exp_date+l+")");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void setPromo(String string)
	{
		this.promo_code = string;
	}
	
	public void setDiscount(double num)
	{
		this.discount_percent = num;
	}
	
	public void setDate(Date date)
	{
		this.exp_date = date;
	}
	
	public String getPromo()
	{
		return this.promo_code;
	}
	
	public double getDiscount()
	{
		return this.discount_percent;
	}
	
	public Date getDate()
	{
		return this.exp_date;
	}
}

