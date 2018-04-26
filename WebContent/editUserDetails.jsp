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
          <form class ="box" action = "editUser" method = "GET">
            <h1> Edit User </h1>
            <input class = "i" type="text"  placeholder="Email" name = "id" value= "${id}" readOnly >
             <input class = "i" type="text"  placeholder="Email" name = "Email" value= "${Email}" >
             <input class = "i" type="text" placeholder="FirstName" name = "FirstName" value = "${FirstName}" }>
             <input class = "i" type="text" placeholder="LastName" name = "LastName" value = "${LastName}">
			 <input class = "i" type="text" placeholder="YYYY-MM-DD" name = "Date" value = "${Date}"><br>
            <button type="submit" name = "save">Save</button>
            <button type = "submit" name = "back"> Back to User List </button><br>
          </form>
        </div>

    </body>
</html>
