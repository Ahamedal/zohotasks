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
<center><h2>Admin Home Page</h2></center>
<form action="AccountServelets" method="post">
<div>
<button name="page" value="customerloginpage" type="submit">Customer Details</button>
<button name="page" value="adminloginpage"  type="submit">Account Details</button>
<button type="submit" formaction="Deposit.jsp" >Deposit</button>
<button type="submit" formaction="WithDraw.jsp">WithDraw</button>
<button type="submit" formaction="Transfer to Another Account.jsp">Transfer To Another Account</button>
<button type="submit" formaction="banklogin.jsp">LogOut</button>
<br><br><br>

</div>
</form>

</body>
</html>