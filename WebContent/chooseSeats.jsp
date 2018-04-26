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
      }


    </style>
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
    
    <form>
      <input type="text" placeholder="Search" name="search">
    </form>
  </div>

    <div class= "outside">
      <div class = "otherBox">
      	<h1> Choose Seats </h4>
      	<form action = "chooseSeats" method = "GET">
        <table>
          <tr>
            <td> 1 <input type = "checkbox" name = "seat" value = "seat 1"> </td>
            <td> 2 <input type = "checkbox" name = "seat" value = "seat 2"> </td>
            <td> 3 <input type = "checkbox" name = "seat" value = "seat 3"> </td>
            <td> 4 <input type = "checkbox" name = "seat" value = "seat 4"> </td>
            <td> 5 <input type = "checkbox" name = "seat" value = "seat 5"> </td>
            <td> 6 <input type = "checkbox" name = "seat" value = "seat 6"> </td>
            <td> 7 <input type = "checkbox" name = "seat" value = "seat 7"> </td>
            <td> 8 <input type = "checkbox" name = "seat" value = "seat 8"> </td>
            <td> 9 <input type = "checkbox" name = "seat" value = "seat 9"> </td>
            <td> 10 <input type = "checkbox" name = "seat" value = "seat 10"> </td>
          </tr>

          <tr>
            <td> 11 <input type = "checkbox" name = "seat" value = "seat 11"> </td>
            <td> 12 <input type = "checkbox" name = "seat" value = "seat 12"> </td>
            <td> 13 <input type = "checkbox" name = "seat" value = "seat 13"> </td>
            <td> 14 <input type = "checkbox" name = "seat" value = "seat 14"> </td>
            <td> 15 <input type = "checkbox" name = "seat" value = "seat 15"> </td>
            <td> 16 <input type = "checkbox" name = "seat" value = "seat 16"> </td>
            <td> 17 <input type = "checkbox" name = "seat" value = "seat 17"> </td>
            <td> 18 <input type = "checkbox" name = "seat" value = "seat 18"> </td>
            <td> 19 <input type = "checkbox" name = "seat" value = "seat 19"> </td>
            <td> 20 <input type = "checkbox" name = "seat" value = "seat 20"> </td>
          </tr>

    
        </table>

        <br>
        <br>

        Adult: <input type = "checkbox" name = "seatType" value = "adult">
        Child: <input type = "checkbox" name = "seatType" value = "child">

        
		
        	<button type = "submit" name = "browse">Back To Browse </button>
        	<button type = "submit "name = "checkout" value = "BlackPanther"> Checkout </button>
		</form>
      </div>
    </div>

</body>
</html>