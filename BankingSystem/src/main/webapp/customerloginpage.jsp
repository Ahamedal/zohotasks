<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.*"
    %>
    <%@ page import="java.lang.*"
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
<body onpageshow="b()">

<form action="TransferToAnotherAccountCustomer.jsp">
<button  type="submit">Transfer To Another Account</button>
<button formaction="AccountServelets" formmethod="post" type="submit" name="page" value="logout">LogOut</button>
<center><h1>Customer Home Page</h1></center>
<center><%
String msg=request.getParameter("msg");
if(msg!=null){
	out.print("<label id=s>"+msg+"</label>");
}
%></center>
<div>

<br>
<br><br><br>
<table style="width:100%">
<tr>
<th>CustomerID</th><th>Name</th><th>Address</th><th>MobileNo</th>
</tr>

<c:forEach items="${AccountServelets}" var="current">


<tr>
  
   <td><c:out value="${current.key}"/></td>
   
   <td><c:out value="${current.value.getName()}"/></td>
   <td><c:out value="${current.value.getAddress()}"/></td>
   <td><c:out value="${current.value.getMobileNo()}"/></td>

   
</tr>

</c:forEach>

</table>
<br><br><br>
<table style="width:100%">
<tr>
<th>AccountID</th><th>AccountType</th><th>BranchName</th><th>Status</th><th>Balance</th>
</tr>

<c:forEach items="${AccountServelet}" var="current1">

  
<tr>
   
   <td><c:out value="${current1.key}"/></td>
   <td><c:out value="${current1.value.getAccountType()}"/></td>
   <td><c:out value="${current1.value.getBranchName()}"/></td>
   <td><c:out value="${current1.value.isStatus()}"/></td>
   <td><c:out value="${current1.value.getBalance()}"/></td>
  
    
   
 
</tr>






</c:forEach>


</table>
<br><br><br><br><br>

</div>
</form>
</body>
</html>