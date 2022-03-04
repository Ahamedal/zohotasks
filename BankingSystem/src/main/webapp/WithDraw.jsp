<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
<body>
<jsp:include page="adminloginpage.jsp" ></jsp:include>


<div>
<center><h2>WithDraw Here</h2></center>
<form action="WithDraw" method="post">
<h5>*please fill all details to below here</h5>
<label for="uId">userId:</label><br>
<input type="text" placeholder="enter userId" name="uId"> <br>
<label for="uAccNo">Account No:</label><br>
<input type="text" placeholder="enter AccountNo" name="uAccNo"><br>
<label for="uWit">WithDraw Money:</label><br>
<input type="text" placeholder="enter amount" name="uWit"><br>

<button type="submit" id="b">submit</button>
</form>
</div>

</body>
</html>