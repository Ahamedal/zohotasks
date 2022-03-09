<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banking System</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>  

<center><h1>Bank Login</h1></center>

<form action="AccountServelets"method="post">
<div>
<label for="uname">UserID:</label><br>
<input type="text" placeholder="enter userid" name="uname" required> <br>
<label for="pass">Password:</label><br>
<input type="password" placeholder="enter password" name="pass" required><br>

<button name="page" value="login"  type="submit" id="b"> <i class="fa fa-sign-in"></i> login</button>
<input type="reset" ><br>

<br>

<%
 String a=(String)request.getAttribute("login");
if(a!=null){
	out.print("<label id=d>*"+a+"</label>");
}
%>
</div>
</form>


</body>
</html>