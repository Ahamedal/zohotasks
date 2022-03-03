<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddCustomer</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
</head>
<body>
<center><h2>Add Customer here</h2></center>
<form action="AddCustomer" method="post">
<div>
<h5>*please fill all details to below here</h5>
<label for="uname">username:</label><br>
<input type="text" placeholder="enter username" name="uname"> <br>
<label for="uadd">useraddress:</label><br>
<input type="text" placeholder="enter useradress" name="uadd"><br>
<label for="umob">mobileno:</label><br>
<input type="text" placeholder="enter usermobileno" name="umob"><br>
<label for="upass">Password:</label><br>
<input type="text" placeholder="enter password" name="upass"><br>
<label for="upas1">ConfirmPassword:</label><br>
<input type="text" placeholder="enter password" name="upas1"><br>

<button type="submit">register</button>
</div>
</form>
</body>
</html>