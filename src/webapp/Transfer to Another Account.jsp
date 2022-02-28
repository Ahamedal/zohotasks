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
<a href="banklogin.jsp" type="submit" style="float:right">LogOut</a>
<br><br><br><br><br>
<form action="customerloginpage.jsp">

<div>
<center><h2>Transfer to another Account</h2></center>
<h3>From account:</h3>
<label for="uaccNo">AccountNo:</label>
<input type="text" placeholder="enter AccountNo" name="uaccNo"> <br>
<h3>To account:</h3>
<label for="uId">userId:</label>
<input type="text" placeholder="enter userId" name="uId"> <br>
<label for="uaccNo">Account No:</label>
<input type="text" placeholder="enter AccountNo" name="uaccNo"><br>
<label for="uDep">Deposit Money:</label>
<input type="text" placeholder="enter deposit" name="uDep"><br>

<button type="submit">submit</button>
</div>
</form>
</body>
</html>