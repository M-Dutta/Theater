<%@ page contentType = "text/html;charset=UTF-8" import = "beanies.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <!-- meta tag -->
  <meta charset="utf-8">

  <!-- style sheets -->
  <link rel="stylesheet" type="text/css" href="css/style.css">

  <!-- tab details -->
  <link rel="icon" type="image/png" href="img/cinema.png">
  <title>Theater</title>

  <meta name="viewport" content="width=device-width, initial-scale=1">

  <style>

    table
    {
      margin: auto;
      border-spacing: 30px;
    }

    td
    {
      text-align: center;
    }



  </style>
</head>
<body>
<jsp:useBean id = "mov" class = "beanies.MovieList" scope = "request"></jsp:useBean>

  <div class="navbar">
    <a style = "float:left" href = "homepage.html"> Home </a>
    <div class="dropdown">
      <button class="dropbtn"> User
        <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
        <a href="signIn.html">Profile</a>
        <a href="signIn.html">Logout</a>
      </div>
    </div>
    
    <form>
      <input type="text" placeholder="Search" name="search">
    </form>
  </div>

  <div class = "outside">
    <table>
      <tr>
      	<c:forEach items = "${mov.movieList}" var = "mov">
   
        <td>
        <img src="${mov.pic}">
 		<form action = "homepage" method = "GET">
        	<button type = "submit" name = "viewDetails" value = "${mov.movieName}"> View Details </button>
        	<button type = "submit" name = "bookTickets" value = "${mov.movieName}"> Book Tickets </button>
      	</form>
        </td>
        </c:forEach>
       </tr>

    </table>
  </div>


</body>
</html>