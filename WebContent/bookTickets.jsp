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
   
    <form>
      <input type="text" placeholder="Search" name="search">
    </form>
  </div>

    <div class = "outside">
    <div class = "box">
    <h1> Select Showtime </h1>
      <br> <br>
      
          <form action = "bookTickets" method = "GET">
          <c:forEach items = "${mov.movieList}" var = "mov">
          <c:forEach items = "${mov.showtimeList}" var = "time">
            <button type = "submit" name = "show" value = "${mov.movieName}"> ${time} </button> 
            
           </c:forEach>
           </c:forEach>
          </form>
        
    <br> <br>

	</div>
    </div>

    
</body>
</html>