<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="java.util.*"
    %>
    <%@ page import="level3.*"
    %>
     <%@ page import="javax.servlet.*"
    %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@page import="javax.servlet.annotation.MultipartConfig"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AccountDetails</title>

<link rel="stylesheet" type="text/css" href="detailsStyle.css">

</head>
<body>
<center><h2>AccountDetails</h2></center>
<form action="AccountServelets" method="post">
<button name="page" value="customerdetails" type="submit">Customer Details</button>
<button name="page" value="accountdetails"  type="submit">Account Details</button>
<button type="submit" formaction="Deposit.jsp" >Deposit</button>
<button type="submit" formaction="WithDraw.jsp">WithDraw</button>
<button type="submit" formaction="Transfer to Another Account.jsp">Transfer To Another Account</button>
<button type="submit" formaction="banklogin.jsp">LogOut</button>



<a href="AddAccount.jsp" type="submit" style="float:right">AddAccount</a>
</form>
<form >
<table style="width:100%">
<tr>
<th>CustomerID</th><th>AccountID</th><th>AccountType</th><th>BranchName</th><th>Balance</th><th>Deactivate</th>
</tr>

<c:forEach items="${AccountServelets}" var="current">
<c:forEach items="${current.value}" var="current1">
  
<tr>
   
   <td><c:out value="${current.key}"/></td>
   <td><button  type="submit" name="userId" value="<c:out value="${current1.key}"/>" formaction="Update.jsp" formmethod="post"><c:out value="${current1.key}"/></button></td>
   <td><c:out value="${current1.value.getAccountType()}"/></td>
   <td><c:out value="${current1.value.getBranchName()}"/></td>
   <td><c:out value="${current1.value.getBalance()}"/></td>
  
    
    <td><button type="submit" name="aId" value="<c:out value="${current1.key}"/>" formaction="Deactivate" formmethod="post">Delete</button></td>     
 
</tr>
</c:forEach>
</c:forEach>

</table>
</form>
<br><br><br><br><br><br>
<table style="width:100%">
<tr>
<th>Customer Id</th><th>Account Id</th><th>AccountType</th><th>Branch</th><th>Balance</th><th>Delete</th>

</tr>
<tr>
<td>1</td><td><button onclick="window.location.href='AddAccount.jsp'" type="submit">1001</button></td><td>Savings</td><td>ramnad</td><td>1000</td><td><button>Delete</button></td>
</tr>
<tr>
<td>2</td><td><button onclick="window.location.href='AddAccount.jsp'" type="submit">1002</button></td><td>Savings</td><td>bodi</td><td>200</td><td><button>Delete</button>


</table>


</body>
</html>