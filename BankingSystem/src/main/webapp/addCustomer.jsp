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
<center><h2><%String id=request.getParameter("userId");
if(id!=null){
	out.print("Update Customer");
}
else{
	out.print("Add Customer");
}
%></h2></center>
<%

%>
<form action="AddCustomer" method="post">
<div>
<h5>*please fill all details to below here</h5>
<label for="uname">username:</label><br>
<input type="text" placeholder="enter username" name="uname" <% if(id!=null){%>value="<%out.print((String)(request.getAttribute("name"))); %>"<%} %>  > <br>
<label for="uadd">useraddress:</label><br>
<input type="text" placeholder="enter useradress" name="uadd" <% if(id!=null){%> value="<%out.print((String)(request.getAttribute("address"))); %>"<%} %>  ><br>
<label for="umob">mobileno:</label><br>
<input type="text" placeholder="enter usermobileno" name="umob" <% if(id!=null){%> value="<%out.print((Long)(request.getAttribute("mobileno"))); %>" <%} %> ><br>


<button name="userId1" value="<%out.print(id);%>" type="submit" id="b">register</button>
</div>
</form>
</body>
</html>