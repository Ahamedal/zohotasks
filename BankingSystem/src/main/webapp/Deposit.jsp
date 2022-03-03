<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
</head>
<body>   
<center><h1>Deposit Here</h1></center>
<div>
<form action="Deposit" method="post">
<h5>*please fill all details to below here</h5>
<label for="uId">userId:</label><br>
<input type="text" placeholder="enter userId" name="uId"> <br>
<label for="uAccNo">Account No:</label><br>
<input type="text" placeholder="enter AccountNo" name="uAccNo"><br>
<label for="uDep">Deposit Money:</label><br>
<input type="text" placeholder="enter deposit" name="uDep"><br>

<button type="submit" >submit</button>
</form>
</div>

</body>
</html>