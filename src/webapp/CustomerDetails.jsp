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
<title>Customer Login Page</title>

<link rel="stylesheet" type="text/css" href="detailsStyle.css">

</head>
<body>
<center><h2>CustomerDetails</h2></center>
<div>
<form action="AccountServelets" method="post">
<button name="page" value="customerloginpage" type="submit">Customer Details</button>
<button name="page" value="adminloginpage"  type="submit">Account Details</button>
<button type="submit" formaction="Deposit.jsp" >Deposit</button>
<button type="submit" formaction="WithDraw.jsp">WithDraw</button>
<button type="submit" formaction="Transfer to Another Account.jsp">Transfer To Another Account</button>
<button type="submit" formaction="banklogin.jsp">LogOut</button>
<a href="addCustomer.jsp" type="submit" style="float:right">AddCustomer</a>

<table style="width:100%">
<tr>
<th>CustomerID</th><th>Name</th><th>Address</th><th>MobileNo</th><th>Deactivate</th>
</tr>

<c:forEach items="${AccountServelets}" var="current">


<tr>
  
   <td><button formaction="addCustomer.jsp" type="submit"><c:out value="${current.key}"/></button></td>
   
   <td><c:out value="${current.value.getName()}"/></td>
   <td><c:out value="${current.value.getAddress()}"/></td>
   <td><c:out value="${current.value.getMobileNo()}"/></td>

   <td><button type="submit" name="userId" value="<c:out value="${current.key}"/>"  formaction="Deactivate" formmethod="post">Delete</button></td>  
</tr>

</c:forEach>
</table>
<br><br>
<table style="width:100%">
<tr>
<th>customer Id</th><th>Name</th><th>address</th><th>MobileNo</th><th>Delete</th>

</tr>
<tr>
<td><button onclick="window.location.href='addCustomer.jsp'" type="submit">1</button></td><td>ahmed</td><td>ramnad</td><td>9791789617</td><td><button>Delete</button></td>
</tr>
<tr>
<td><button onclick="window.location.href='addCustomer.jsp'" type="submit">2</button></td><td>ruju</td><td>bodi</td><td>6385224645</td><td><button>Delete</button></td>


</table>
</form>
</div>
</body>
</html>