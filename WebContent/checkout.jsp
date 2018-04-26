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

      .form
      {
        text-align: left;
      }

      .i
      {
        width: 60%;
        margin-bottom: 10px;
        text-align: center;
        font-size: 16px;
        border: 1px solid white;
        border-radius: 10px;
        color: black;
        padding-left: 2px;
        display: inline-block;
        float: left;
      }

      label
      {
        display: inline-block;
        float: left;
        clear: left;
        width: 150px;
        text-align: right;
        padding-right: 7px;

      }

      table
      {
        margin: auto;
        width: 100%;
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

    <div class "outside">
      <div class= "otherBox">
    	   <h1> Checkout </h1>
        <table>
          <tr>
            <td style = "width: 400px">
              <form class = "form">
                <label> Card Number:</label><input class ="i" type = "text" id = "cardNumber"> <br>
                <label> Expiration Date:</label><input class ="i" type = "text" id = "expirationDate"> <br>
                <label> CVV: </label><input class ="i" type = "text" id = "cvv"> <br>
                <label> Address 1: </label><input class ="i" type = "text" id = "address1"> <br>
                <label> Address 2: </label><input class ="i" type = "text" id = "address2"> <br>
                <label> Zip Code: </label><input class ="i" type = "text" id = "zipCode"> <br>
                <label> State: </label><input class ="i" type = "text" id = "state"> <br>
                <label> Country: </label><input class ="i" type = "text" id ="country"> <br>
                <label> Contact Number: </label><input class ="i" type = "text" id = "contactNumber"> <br>
                <label> Promo Code: </label><input class ="i" type = "text" id = "promoCode">
              </form>
            </td>

            <td style = "width: 200px">
              <p class = "p"> ${name} </p> <br>
              <p class = "p"> ${seat} </p> <br>
              <p class = "p"> ${type} </p> <br>

            </td>
          </tr>

        </table>

        <p> Total: $10 </p>
        <form action = "checkout" method = "GET">
        	<button type = "submit" name = "order"> Place Order </button>
       		<button type = "submit" name = "cancel"> Cancel Order </button>
       	</form>

      </div>
    </div>

  
</body>
</html>