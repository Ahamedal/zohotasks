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
<center><h1>ChangeStatus Here</h1></center>
<form>
<div>
<h5>*please fill all details to below here</h5>
<label for="uId">userId:</label><br>
<input type="text" placeholder="enter userId" name="uId"> <br>
<label for="uaccNo">Account No:</label><br>
<input type="text" placeholder="enter AccountNo" name="uaccNo"><br>
<label for="uDea">Change Activate/Deactivate:</label><br>
<input type="text" placeholder="enter 0 for deactivated or 1 to activated" name="uDea"><br>

<button type="submit">submit</button>
</div>
</form>
</body>
</html>