package servlets;
import containers.*;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditPromoServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
	
	if (request.getParameter("save") != null)
	{
		String promo = request.getParameter("promo");
		String discount = request.getParameter("discount");
		String exp = request.getParameter("exp");
		PromoCode p;
		try {
			p = new PromoCode(promo,Double.parseDouble(discount),Utilities.DateConverter(exp));
			p.changePromoCode(Utilities.stmt, p);
			
		} catch (NumberFormatException | ParseException e) {
			System.out.println("Edit Promo Servlet Save"+e);
		}
		
	}
	
	if (request.getParameter("back") != null)
	{
		response.sendRedirect("adminPromoDetails.jsp");	
	}
	
	if (request.getParameter("saveNew") != null)
	{
		response.sendRedirect("adminPromoDetails.jsp");
		String Code = request.getParameter("Code");
		String Discount = request.getParameter("Discount");
		String exp = request.getParameter("ExpirationDate");
		Date d;
		try {
			PromoCode p = new PromoCode(Code, Double.parseDouble(Discount), Utilities.DateConverter(exp));
			p.addPromoCode(Utilities.stmt);
		} catch (NumberFormatException | ParseException e) {
			System.out.println(e);
			System.out.println("EditPromoCodeServlet");
		}
        
	}
	
}
}