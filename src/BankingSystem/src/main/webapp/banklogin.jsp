<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banking System</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
</head>
<body>  

<center><h1>Bank Login</h1></center>

<form action="AccountServelets"method="post">
<div>
<label for="uname">UserID:</label><br>
<input type="text" placeholder="enter userid" name="uname"> <br>
<label for="pass">Password:</label><br>
<input type="password" placeholder="enter password" name="pass"><br>

<button name="page" value="login" type="submit">login</button>

</div>
</form>

</body>
</html>