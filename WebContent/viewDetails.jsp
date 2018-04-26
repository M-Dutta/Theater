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

    <style>


      table
      {
        margin: auto;
        width: 100%;
      }

      p
      {
          margin: auto;
          font-size:20px;
      }
    </style>

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

    <form>
      <input type="text" placeholder="Search" name="search">
    </form>
  </div>

    <div class = "outside">
      <div class = "otherBox">
     	<c:forEach items = "${mov.movieList}" var = "mov">
     	 <c:if test = "${mov.movieName == 'Black Panther'}"> 
    	   <h1>${mov.movieName}</h1>
           <table>
             <tr>
               <td>
                 <img src = "${mov.pic}" alt = "movie poster"> <br>
                 <form action = "viewDetails" method = "GET">
                 	<button type = "submit" name = "bookTickets" value = "${mov.movieName}"> Book Tickets </button>
                 </form>
               </td>

              <td>
                <p> ${mov.description} </p> <br>
                <p> ${mov.genre} </p> <br>
                <p> ${mov.length} </p>
              </td>
            </tr>
          </table>
		</c:if>
          </c:forEach>

         </div>
       </div>

</body>
</html>