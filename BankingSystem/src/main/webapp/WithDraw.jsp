<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WithDraw</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
<script>  

 
</script> 
</head>
<body>
<jsp:include page="adminloginpage.jsp" ></jsp:include>


<div>
<center><h2>WithDraw Here</h2></center>
<form  action="WithDraw" method="post"  onsubmit="return validate(this)">
<h5>*please fill all details to below here</h5>
<label for="uId">userId:</label><br>
<input type="text" placeholder="enter userId" name="uId" required><span  id="a"></span><br>
<label for="uAccNo">Account No:</label><br>
<input type="text"  placeholder="enter AccountNo" name="uAccNo" required><span  id="a"></span><br>
<label for="uWit">WithDraw Money:</label><br>
<input type="text"  placeholder="enter amount" name="uWit" required><span  id="a"></span><br>

<button type="submit" id="b">submit</button>
<br>

<%
 String a=(String)request.getAttribute("withdraw");
if(a!=null){
	out.print("<label id=d>*"+a+"</label>");
}
%>

</form>
</div>
</body>
</html>