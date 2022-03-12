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

<meta charset="UTF-8">
<title>AccountDetails</title>
<% 	if(session.getAttribute("id")==null) {
			RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			rd.forward(request, response);
		}%>
<link rel="stylesheet" type="text/css" href="detailsStyle.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

<jsp:include page="adminloginpage.jsp"></jsp:include>

<form >

<button formaction="AccountServelets"  formmethod="post" name="page" value="deactivatedetails" type="submit" style="float:right">DeactivatedAccounts</button>
<a href="AddAccount.jsp" type="submit" style="float:left"><i class="fa fa-plus"></i>AddAccount</a>
<center><h2>AccountDetails</h2></center>
<center><%
String msg=request.getParameter("msg");
if(msg!=null){
	out.print("<label id=s>"+msg+"</label>");
}
%></center>
<table style="width:100%">
<tr>
<th>CustomerID</th><th>AccountID</th><th>AccountType</th><th>BranchName</th><th>Balance</th><th>Deactivate</th>
</tr>

<c:forEach items="${AccountServelets}" var="current">
<c:forEach items="${current.value}" var="current1">
   <c:if test="${current1.value.isStatus()}">
<tr>
  
   <td><c:out value="${current.key}"/></td>
   <td><a  type="submit" href="AddAccount.jsp?userId=<c:out value="${current.key}"/>&accType=<c:out value="${current1.value.getAccountType()}"/>&branch=<c:out value="${current1.value.getBranchName()}"/>&accId=<c:out value="${current1.key}"/>"><i class="fa fa-edit"></i><c:out value="${current1.key}"/></a></td>
   <td><c:out value="${current1.value.getAccountType()}"/></td>
   <td><c:out value="${current1.value.getBranchName()}"/></td>
   <td><c:out value="${current1.value.getBalance()}"/></td>
   <td><button onclick="return myconfirm()" type="submit" name="aId" value="<c:out value="${current1.key}"/>" formaction="Deactivate" formmethod="post"><i class="fa fa-trash"></i> Delete</button></td>     
 
</tr>
</c:if>
</c:forEach>
</c:forEach>

</table>

<br><br><br><br><br><br>


</form>
</body>
</html>