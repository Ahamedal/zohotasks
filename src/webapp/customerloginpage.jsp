<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*"
    %>
    <%@ page import="level3.*"
    %>
     <%@ page import="javax.servlet.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Login Page</title>

<link rel="stylesheet" type="text/css" href="detailsStyle.css">
</head>
<body>
<center><h1>Customer Home Page</h1></center>
<%
Map<Integer,Map<Integer,AccountInfo>> accMap=(Map<Integer,Map<Integer,AccountInfo>>)request.getAttribute("AccountServelets");
out.print(accMap);
%>
<div>
<a href="Transfer to Another Account.jsp" type="submit">Transfer To Another Account</a>
<a href="banklogin.jsp " type="submit">LogOut</a>
<br>
<br><br><br>
<table style="width:100%">
<tr>
<th>AccountNo</th><th>balance</th>

</tr>
<tr>
<td>1001</td><td>2000</td>
</tr>
<tr>
<td>1002</td><td>100</td>
<tr>

</table>
</div>
</body>
</html>