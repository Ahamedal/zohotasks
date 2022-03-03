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
<center><h2>Update Customer here</h2></center>
<form action="AddCustomer" method="post">
<div>
<h5>*please fill all details to below here</h5>
<% String id=request.getParameter("userId"); 
request.setAttribute("id", id);
%>
<label for="uname">username:</label><br>
<input type="text" placeholder="enter username" name="uname"> <br>
<label for="uadd">useraddress:</label><br>
<input type="text" placeholder="enter useradress" name="uadd"><br>
<label for="umob">mobileno:</label><br>
<input type="text" placeholder="enter usermobileno" name="umob"><br>

<button name="userId1" value="<%out.print(id);%>" type="submit">register</button>
</div>
</form>
</body>
</html>