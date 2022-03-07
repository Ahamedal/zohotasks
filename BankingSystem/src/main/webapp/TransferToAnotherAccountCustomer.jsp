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

<form action="TransferToAnotherAccount" method="post">
<button formaction="AccountServelets" formmethod="post" type="submit" style="float:right">LogOut</button>
<br><br><br><br><br>
<div>
<h2>Transfer to another Account</h2>
<h3>From account:</h3>
<select name="uAccNo">
<option><%%></option> 
</select>
<h3>To account:</h3>
<label for="uaccNo"></label>
<input type="text" placeholder="enter AccountNo" name="uaccNo"><br>
<label for="uDep"></label>
<input type="text" placeholder="enter deposit" name="uDep"><br>

<button type="submit" id="b" name="page" value="customer">submit</button>
</div>
</form>
</body>
</html>