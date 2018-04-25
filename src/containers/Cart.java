package containers;
import java.sql.Statement;

public class Cart extends Utilities {
	public Tickets tickets;
	public Theater theater;
	public PromoCode promoCodes;
	public Discount discount;
	public double finalCost;
	
	public void leaveCart(Statement s) {
		
	}
	
	public void continueShopping(Statement s) {
		
	}
	
	public void editItems(Statement s) {
		
	}
	
	public PromoCode applyPromoCode(Statement s) {
		return promoCodes;
	}

	public double calculate(Statement s, Theater theater, PromoCode promo, Discount disc) {
		return finalCost;
	}
	
	public double displayPrice(Statement s) {
		return finalCost;
	}
	
	public void checkout(Statement s) {
		
	}
}
