<%@ page contentType = "text/html;charset=UTF-8" %>
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
    <jsp:useBean id = "bean" class = "beanies.ReportList" scope = "session"></jsp:useBean>
    
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
            <h1>Reports</h1>
            <table>
              <tr>
                <th>Ticket Id</th>
                <th>Movie Id </th>
                <th>Date</th>
                <th>Time</th>

              </tr>
				
			  <c:forEach items = "${bean.reportList}" var = "ticket">
              <tr>
                <td>"${ticket.id}"</td>
                <td>"${ticet.movie}"</td>
                <td>"${ticket.date}"</td>
                <td>"${ticket.time}"</td>
                <td>
                  <form action="adminReport" method="GET">
                    <button type="submit" name = "refund" id = "${ticket.id}" > Refund </button><br>
                  </form>
                </td>

              </tr>
			</c:forEach>
            </table>



          </div>
       	<form action = "adminReport" method = "GET">
          <button type = "submit" name = "options"> Back to Options </button><br>
		</form>
      </div>


    </body>
</html>