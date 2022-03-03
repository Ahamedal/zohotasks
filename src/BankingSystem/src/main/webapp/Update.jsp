<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>AddAccount</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
</head>
<body>
<center><h2>Update Account here</h2></center>
<form action="AddAccount" method="post">
<div>
<h5>*please fill all details to below here</h5>
<% String id=request.getParameter("userId"); 

%>
<label for="userId">UserId:</label><br>
<input type="text" placeholder="enter userId" name="userId"> <br>
<label for="uAT">AccountType:</label><br>
<input type="text" placeholder="enter accountType" name="uAT"><br>
<label for="uBr">Branch:</label><br>
<input type="text" placeholder="enter branch" name="uBr"><br>

<button name="userId1" value="<%out.print(id);%>" type="submit">register</button>
</div>
</form>
</body>
</html>