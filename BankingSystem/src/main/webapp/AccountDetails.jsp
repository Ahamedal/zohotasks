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
<title>AccountDetails</title>

<link rel="stylesheet" type="text/css" href="detailsStyle.css">

</head>
<body>

<jsp:include page="adminloginpage.jsp"></jsp:include>



<a href="AddAccount.jsp" type="submit" style="float:right">AddAccount</a>
</form>
<center><h2>AccountDetails</h2></center>
<form >
<table style="width:100%">
<tr>
<th>CustomerID</th><th>AccountID</th><th>AccountType</th><th>BranchName</th><th>Balance</th><th>Deactivate</th>
</tr>

<c:forEach items="${AccountServelets}" var="current">
<c:forEach items="${current.value}" var="current1">
  
<tr>
   
   <td><c:out value="${current.key}"/></td>
   <td><a  type="submit"  href="AddAccount.jsp?userId=<c:out value="${current.key}"/>&accType=<c:out value="${current1.value.getAccountType()}"/>&branch=<c:out value="${current1.value.getBranchName()}"/>&accId=<c:out value="${current1.key}"/>"><c:out value="${current1.key}"/></a></td>
   <td><c:out value="${current1.value.getAccountType()}"/></td>
   <td><c:out value="${current1.value.getBranchName()}"/></td>
   <td><c:out value="${current1.value.getBalance()}"/></td>
  
    
    <td><button onclick="return myconfirm()" type="submit" name="aId" value="<c:out value="${current1.key}"/>" formaction="Deactivate" formmethod="post">Delete</button></td>     
 
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