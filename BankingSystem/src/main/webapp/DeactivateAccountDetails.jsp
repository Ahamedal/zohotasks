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
<title>Deactivated Account</title>
<link rel="stylesheet" type="text/css" href="detailsStyle.css">
<%
response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
%>
</head>
<body>
<jsp:include page="adminloginpage.jsp"></jsp:include>
<center><h2>DeactivatedAccountDetails</h2></center>
<form>
<table style="width:100%">
<tr>
<th>CustomerID</th><th>AccountID</th><th>AccountType</th><th>BranchName</th><th>Balance</th><th>Activate</th>
</tr>

<c:forEach items="${AccountServelets}" var="current">
<c:forEach items="${current.value}" var="current1">
   <c:if test="${!current1.value.isStatus()}">
<tr>
  
   <td><c:out value="${current.key}"/></td>
   <td><c:out value="${current1.key}"/></td>
   <td><c:out value="${current1.value.getAccountType()}"/></td>
   <td><c:out value="${current1.value.getBranchName()}"/></td>
   <td><c:out value="${current1.value.getBalance()}"/></td>
    <td><button type="submit" name="aId" value="<c:out value="${current1.key}"/>" formaction="Activate" formmethod="post">Activate</button></td>     
 
</tr>
</c:if>
</c:forEach>
</c:forEach>

</table>
</form>
</body>
</html>