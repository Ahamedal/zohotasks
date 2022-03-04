<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"
    %>
    <%@ page import="level3.*"
    %>
     <%@ page import="javax.servlet.*"
    %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin login Page</title>
<link rel="stylesheet" type="text/css" href="detailsStyle.css">
</head>
<body>    

<form action="AccountServelets" method="post">

<button name="page" value="customerdetails" type="submit">Customer Details</button>
<button name="page" value="accountdetails"  type="submit">Account Details</button>
<button type="submit" formaction="Deposit.jsp" >Deposit</button>
<button type="submit" formaction="WithDraw.jsp">WithDraw</button>
<button type="submit" formaction="Transfer to Another Account.jsp">Transfer To Another Account</button>
<button name="page" value="logout" type="submit">LogOut</button>
<br><br><br>

</form>

</body>
</html>