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
<script>
function myconfirm(){
	var result=confirm("want to delete");
	if(result==true){
		return true;
	}
	else{
		return false;
	}
}
</script>  
<meta charset="UTF-8">
<title>Customer Login Page</title>

<link rel="stylesheet" type="text/css" href="detailsStyle.css">

</head>
<body>
<jsp:include page="adminloginpage.jsp"></jsp:include>
<div>

<a href="addCustomer.jsp" type="submit" style="float:right">AddCustomer</a>
<center><h2>CustomerDetails</h2></center>
<form>
<table style="width:100%">
<tr>
<th>CustomerID</th><th>Name</th><th>Address</th><th>MobileNo</th><th>Deactivate</th>
</tr>

<c:forEach items="${AccountServelets}" var="current">
  
<tr>
  
   <td><button name="userId" value="<c:out value="${current.key}"/>" formaction="AutoFill" formmethod="post" type="submit"><c:out value="${current.key}"/></button></td>
 
   <td><c:out value="${current.value.getName()}"/></td>
   <td><c:out value="${current.value.getAddress()}"/></td>
   <td><c:out value="${current.value.getMobileNo()}"/></td>

   <td><button onclick="return myconfirm()" type="submit" name="userId" value="<c:out value="${current.key}"/>"  formaction="Deactivate" formmethod="post">Delete</button></td>

</tr>

</c:forEach>

</table>
</form>
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


</div>

</body>
</html>