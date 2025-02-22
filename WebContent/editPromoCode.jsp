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
          <form class="box" action = "editPromo" method = "GET">
            <h1> Edit Promo </h1>
            <input class = "i" type="text" placeholder="Code" name = "promo" value = "${promo}" readOnly>
            <input class = "i" type="text" placeholder="Discount" name = "discount" value = "${discount}">
            <input class = "i" type="text" placeholder="End Date" name ="exp" value = "${exp}"><br>
            <button type = "submit" name = "save"> Save </button>
            <button type = "submit" name = "back"> Back to Promos List </button><br>
          </form>

    

        </div>

    </body>
</html>
