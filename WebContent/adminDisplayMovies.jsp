<%@ page contentType = "text/html;charset=UTF-8" import = "beanies.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
    <head>
        <!-- meta tag -->
        <meta charset="utf-8">

        <!-- style sheets -->
        <link rel="stylesheet" type="text/css" href="css/style.css">

        <!-- tab details -->
        <link rel="icon" type="image/png" href="img/cinema.png">
        <title>Theater</title>

    </head>

    <body>
    <jsp:useBean id = "mov" class = "beanies.MovieList" scope = "request"></jsp:useBean>
    
      <div class="navbar">
        <a style = "float:left" href = "homepage.html"> Home </a>
        <div class="dropdown">
          <button class="dropbtn"> Profile
            <i class="fa fa-caret-down"></i>
          </button>
          <div class="dropdown-content">
            <a href="signIn.html">Sign-In</a>
            <a href="register.html">Register</a>
          </div>
        </div>
        <a href = "cart.html"> Cart </a>
        <a href = "bookTickets.html"> Book Tickets </a>
        <form>
          <input type="text" placeholder="Search" name="search">
        </form>
      </div>

        <div class = "outside">
          <div class = "table">
            <h1>Movies</h1>
              <table>
                  <tr>
                  	  <th>ID</th>
                      <th>Movie Name</th>
                      <th>Movie Length</th>
                  </tr>
		
				<c:forEach items = "${mov.movieList}" var = "mov">
                  <tr>
                      <td>${mov.id}</td>
                      <td>${mov.movieName}</td>
                      <td>${mov.length}</td>
                      <td>
                          <form action = "adminMovie" method = "GET">
                              <button type="submit" name = "edit" value = "${mov.id}"> Edit </button><br>
                              <button type="submit" name = "remove" value = "${mov.id}"> Remove </button><br>
                            </form>
                      </td>
                    </tr>
                    </c:forEach>

                </table>

            </div>
            <form action = "adminMovie" method = "GET">
            	<button type = "submit" name = "add"> Add Movie </button><br>
            	<button type="submit" name = "options"> Back To Options </button><br>
            </form>
          </div>


    </body>
</html>
