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
<% 	if(session.getAttribute("id")==null) {
			RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			rd.forward(request, response);
		}%>
<link rel="stylesheet" type="text/css" href="detailsStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script>
function myconfirm(){
	var result=confirm("Are you sure want to delete");
	if(result==true){
		return true;
	}
	else{
		return false;
	}
}
</script> 

</head>
<body>

<jsp:include page="adminloginpage.jsp"></jsp:include>

<div>
<form>

<button formaction="AccountServelets"  formmethod="post" name="page" value="deactivatedetailscustomer" type="submit" style="float:right">DeactivatedAccounts</button>
<a href="addCustomer.jsp" type="submit" style="float:left"> <i class="fa fa-plus"></i>  AddCustomer</a>

<center><h2>CustomerDetails</h2></center>
<center><%
String msg=request.getParameter("msg");
if(msg!=null){
	out.print("<label id=s>"+msg+"</label>");
}
%></center>
<table style="width:100%">
<tr>
<th>CustomerID</th><th>Name</th><th>Address</th><th>MobileNo</th><th>Deactivate</th>
</tr>

<c:forEach items="${AccountServelets}" var="current">
   <c:if test="${current.value.isStatus()}">
<tr>
  
   <td><button name="userId" value="<c:out value="${current.key}"/>" formaction="AutoFill" formmethod="post" type="submit"><i class="fa fa-edit"></i><c:out value="${current.key}"/></button></td>
    
   <td><c:out value="${current.value.getName()}"/></td>
   <td><c:out value="${current.value.getAddress()}"/></td>
   <td><c:out value="${current.value.getMobileNo()}"/></td>
   <td><button onclick="return myconfirm()" type="submit" name="userId" value="<c:out value="${current.key}"/>" formaction="Deactivate" formmethod="post"><i class="fa fa-trash"></i> Delete</button></td>     
   
</tr>
</c:if>
</c:forEach>

</table>

<br><br>


</form>
</div>

</body>
</html>