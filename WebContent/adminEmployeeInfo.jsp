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
    <jsp:useBean id = "emp" class = "beanies.EmployeeList" scope = "request"></jsp:useBean>
      
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
            <h1>Employees</h1>
            <table>
                <tr>
                    <th>Id</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Designation</th>
                </tr>

				<c:forEach items = "${emp.employeeList}" var = "emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.firstName}</td>
                    <td>${emp.lastName}</td>
                    <td>${emp.designation}</td>
                    <td>
                        <form action = "adminEmployee" method = "GET">
                            <button type="submit" name = "edit" value = "${emp.id}" >Edit</button><br>
                            <button type="submit" name = "remove"  value = "${emp.id}">Remove</button><br>
                        </form>
                    </td>
                </tr>
                </c:forEach>

            </table>


        </div>
        <form action = "adminEmployee" method = "GET">
        	<button type = "submit" name = "add"> Add Employee </button><br>
        	<button type="submit" name = "options"> Back To Options </button><br>
		</form>
      </div>

    </body>
</html>
