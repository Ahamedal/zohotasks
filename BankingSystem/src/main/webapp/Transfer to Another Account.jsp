<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Transfer to Another Account</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
</head>
<body>
<jsp:include page="adminloginpage.jsp" ></jsp:include>
<br><br>
<form action="TransferToAnotherAccount" method="post">

<div>
<center><h2>Transfer to another Account</h2></center>
<h3>From account:</h3>
<label for="uAccNo"></label>
<input type="text" placeholder="enter AccountNo" name="uAccNo" required> <br>
<h3>To account:</h3>
<label for="uaccNo"></label>
<input type="text" placeholder="enter AccountNo" name="uaccNo" required><br>
<label for="uDep"></label>
<input type="text" placeholder="enter deposit" name="uDep" required><br>

<button type="submit" id="b" name="page" value="admin">submit</button>
<br><br>
<%
 String a=(String)request.getAttribute("transfers");
if(a!=null){
	out.print("<label id=d>*"+a+"</label>");
}
%>
</div>
</form>
</body>
</html>