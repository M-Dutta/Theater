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
import containers.Movie;
import containers.Utilities;

public class EditMovieServlet extends HttpServlet {
 

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

	}
	
	if (request.getParameter("back") != null)
	{
		response.sendRedirect("adminDisplayMovies.html");	
	}
	
	if (request.getParameter("saveNew") != null)
	{
		//Here
		response.sendRedirect("adminDisplayMovies.html");

		String id = request.getParameter("Id");
		String desc = request.getParameter("desc");
		String rating= request.getParameter("rating");
		String age = request.getParameter("age");
		String genre = request.getParameter("genre");
		String cast = request.getParameter("cast");
		String director = request.getParameter("director");
		String producer = request.getParameter("producer");
		String trailer = request.getParameter("trailer");
		String trailerPicture = request.getParameter("trailerPicture");
		String runTime = request.getParameter("runTime");
		String releaseDate = request.getParameter("releaseDate");
		String movieName = request.getParameter("movieName");
		String status = request.getParameter("status");

		try {
			Movie m = new Movie (Integer.parseInt(id), movieName, desc, 
					Integer.parseInt(rating), Integer.parseInt(age), genre, cast, director, 
					producer,
					trailer, trailerPicture, Utilities.TimeConverter(runTime), 
					Utilities.DateConverter(releaseDate), Integer.parseInt(status));
			m.add(Utilities.stmt);
		} catch (NumberFormatException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
}
