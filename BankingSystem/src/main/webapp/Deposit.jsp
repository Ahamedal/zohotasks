<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
<style>
button{
	background-color:lightblue;
	 padding: 2px; 
	 font-size:20px;
}
</style>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
</head>
<body>   

<jsp:include page="adminloginpage.jsp" ></jsp:include>
<br><br><br>
<form  >

<div >
<center><h1>Deposit Here</h1></center>

<h5>*please fill all details to below here</h5>
<label for="uId">userId:</label><br>
<input type="text" placeholder="enter userId" name="uId" required> <br>
<label for="uAccNo">Account No:</label><br>
<input type="text" placeholder="enter AccountNo" name="uAccNo" required><br>
<label for="uDep">Deposit Money:</label><br>
<input type="text" placeholder="enter deposit" name="uDep" required><br>

<button formaction="Deposit" formmethod="post" type="submit" id="b">submit</button>
<br><br>
<%
 String a=(String)request.getAttribute("deposit");
if(a!=null){
	out.print("<label id=d>*"+a+"</label>");
}
%>
</div>
</form>
</body>
</html>