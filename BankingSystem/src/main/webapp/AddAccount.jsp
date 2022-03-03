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
<center><h2><%String id=request.getParameter("userId");
if(id!=null){
	out.print("Update Account");
}
else{
	out.print("Add Account");
}
%></h2></center>
<form action="AddAccount" method="post">
<div>
<h5>*please fill all details to below here</h5>

<label for="userId">UserId:</label><br>
<input type="text" placeholder="enter userId" name="userId"> <br>
<label for="uAT">AccountType:</label><br>
<select name="uAT" >
   <option>Select Account Type</option>
   <option>Savings</option>
   <option>Current</option>
</select>   
<label for="uBr">Branch:</label><br>
<input type="text" placeholder="enter branch" name="uBr"><br>

<button name="userId1" value="<%out.print(id);%>" type="submit">register</button>
</div>
</form>
</body>
</html>