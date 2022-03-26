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
<title>Insert title here</title>
</head>
<jsp:include page="adminloginpage.jsp"></jsp:include>
<div>
<form>

<center><h2>DeactivatedCustomerDetails</h2></center>
<%
response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
%>

<table style="width:100%">
<tr>
<th>CustomerID</th><th>Name</th><th>Address</th><th>MobileNo</th><th>Activate</th>
</tr>

<c:forEach items="${AccountServelets}" var="current">
   <c:if test="${!current.value.isStatus()}">
<tr>
  
   <td><c:out value="${current.key}"/></td>
    
   <td><c:out value="${current.value.getName()}"/></td>
   <td><c:out value="${current.value.getAddress()}"/></td>
   <td><c:out value="${current.value.getMobileNo()}"/></td>
   <td><button type="submit" name="userId" value="<c:out value="${current.key}"/>" formaction="Activate" formmethod="post">Activate</button></td>     
   
</tr>
</c:if>
</c:forEach>

</table>

<br><br>


</form>
</div>

</body>
</html>