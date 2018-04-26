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

import com.mysql.jdbc.Statement;

import containers.Movie;
import containers.User;
import containers.Utilities;

public class AdminMovieServlet extends HttpServlet {
 

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
		String movieID = request.getParameter("edit");
		Movie m = new Movie();
		m.getMovie(Utilities.stmt, Integer.parseInt(movieID));
		request.setAttribute("Id",m.id);
		request.setAttribute("desc",m.desc);
		request.setAttribute("rating",m.rating);
		request.setAttribute("age",m.age);
		request.setAttribute("genre", m.genre);
		request.setAttribute("cast",m.cast);
		request.setAttribute("director",m.director);
		request.setAttribute("producer",m.producer);
		request.setAttribute("trailer",m.trailer);
		request.setAttribute("trailerPicture",m.trailerPicture);
		request.setAttribute("runTime",m.runTime);
		request.setAttribute("releaseDate",m.releaseDate);
		request.setAttribute("movieName",m.movie_name);
		request.setAttribute("status",m.status);
		request.getRequestDispatcher("editMovieDetails.jsp").forward(request, response);
	}
	if (request.getParameter("remove") != null)
	{	
		Movie m = new Movie();
		m.getMovie(Utilities.stmt, Integer.parseInt(request.getParameter("remove")));
		m.remove(Utilities.stmt);
		response.sendRedirect("adminDisplayMovies.jsp");
	}
	if (request.getParameter("add") != null)
	{
		response.sendRedirect("addMovie.html");
	}
	if (request.getParameter("options") != null)
	{
		response.sendRedirect("adminOptions.html");	
	}
	
}
}

