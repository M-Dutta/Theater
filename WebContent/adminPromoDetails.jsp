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
    <jsp:useBean id = "pro" class = "beanies.PromoList" scope = "request"></jsp:useBean>

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
            <h1>Promo Codes</h1>
            <table>
                <tr>
                    <th>Code</th>
                    <th>Discount</th>
                    <th>End Date</th>
                </tr>
				
				<c:forEach items = "${pro.promoList}" var = "promo">
                <tr>
                    <td> ${promo.promo}</td>
                    <td> ${promo.discount}</td>
                    <td> ${promo.date}</td>
                    <td>
                        <form action="adminPromo" method="GET">
                            <button type="submit" name = "edit" value = "${promo.promo}"> Edit </button><br>
                            <button type="submit" name = "remove" value = "${promo.promo}"> Remove </button><br>
                        </form>
                    </td>
                </tr>
                </c:forEach>

            </table>


        </div>
        <form action="adminPromo" method="GET">
        	<button type = "submit" name = "add"> Add Promo </button> <br>
        	<button type = "submit" name = "options"> Back To Options </button><br>
		</form>
      </div>

    </body>
</html>
