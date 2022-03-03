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
<form action="TransferToAnotherAccount" method="post">

<div>
<center><h2>Transfer to another Account</h2></center>
<h3>From account:</h3>
<label for="uId"></label>
<input type="text" placeholder="enter userId" name="uId"> <br>
<label for="uAccNo"></label>
<input type="text" placeholder="enter AccountNo" name="uAccNo"> <br>
<h3>To account:</h3>
<label for="uId1"></label>
<input type="text" placeholder="enter userId" name="uId1"> <br>
<label for="uaccNo"></label>
<input type="text" placeholder="enter AccountNo" name="uaccNo"><br>
<label for="uDep"></label>
<input type="text" placeholder="enter deposit" name="uDep"><br>

<button type="submit">submit</button>
</div>
</form>
</body>
</html>