package servlets; 
import java.io.IOException;  
import java.text.ParseException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import containers.PromoCode;
import containers.Utilities;

public class AdminPromoServlet extends HttpServlet {
 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
@Override
public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
	
	response.setContentType("text/html; charset=UTF-8");
	
	if (request.getParameter("edit") != null)
	{
		String original = request.getParameter("edit");
		PromoCode p = new PromoCode();
		p.getPromoCode(Utilities.stmt, original);
		request.setAttribute("promo",p.promo_code);
		request.setAttribute("discount",p.discount_percent);
		request.setAttribute("exp",p.exp_date);
		request.getRequestDispatcher("editPromoCode.jsp").forward(request, response);
		
	}
	if (request.getParameter("remove") != null)
	{	
		String original = request.getParameter("remove");
		PromoCode p = new PromoCode();
		p.getPromoCode(Utilities.stmt, original);
		p.removePromoCode(Utilities.stmt);
		response.sendRedirect("adminPromoDetails.jsp");
	}
	if (request.getParameter("add") != null)
	{
		response.sendRedirect("addPromo.html");	
	}
	if (request.getParameter("options") != null)
	{
		response.sendRedirect("adminOptions.html");	
	}
	
}
}