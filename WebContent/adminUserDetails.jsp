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
    <jsp:useBean id = "bean" class = "beanies.UserList" scope = "session"></jsp:useBean>
    
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
          <h1>Users</h1>
          <table>
            <tr>
              <th>Email</th>
              <th>First Name</th>
              <th>Last Name</th>

            </tr>

			<c:forEach items = "${bean.userList}" var = "user">
            <tr>
                <td> "${user.email}"</td>
                <td> "${user.firstName}"</td>
                <td> "${user.lastName}"</td>
               	<td>
                  <form action= "adminUser" method="GET">'
                    <button type="submit" name = "edit" id = "${user.email}">Edit</button><br>
                    <button type="submit" name = "remove" id = "${user.email}">Remove</button><br>
                  </form>
                </td>
            </tr>
            </c:forEach>
          </table>

        
        </div>
        <form action= "adminUser" method="GET">
        	<button type = "submit" name = "add"> Add User </button><br>
        	<button type = "submit" name = "options"> Back to Options </button><br>
		</form>
      </div>
    </body>
</html>