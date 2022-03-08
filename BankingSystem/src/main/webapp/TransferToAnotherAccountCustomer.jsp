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
<title>Transfer to Another Account</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
</head>
<body>
<%
HttpSession sess=request.getSession();
Map<Integer,AccountInfo> map1=(Map<Integer,AccountInfo>)sess.getAttribute("map");
Object[] accIds=map1.keySet().toArray();
%>
<form action="TransferToAnotherAccount" method="post">
<button formaction="AccountServelets" formmethod="post" type="submit" style="float:right" name="page" value="logout">LogOut</button>
<br><br><br><br><br>
<div>
<h2>Transfer to another Account</h2>
<h3>From account:</h3>
<select name="uAccNo" required>
<%for(int i=0;i<accIds.length;i++) {%>
<option><%out.print(accIds[i]) ;%></option> 
<%} %>
</select>
<h3>To account:</h3>
<label for="uaccNo"></label>
<input type="text" placeholder="enter AccountNo" name="uaccNo" required><br>
<label for="uDep"></label>
<input type="text" placeholder="enter deposit" name="uDep" required><br>

<button type="submit" id="b" name="page" value="customer">submit</button>
<br><br>
<%
 String a=(String)request.getAttribute("transfers");
if(a!=null){
	out.print("<label id=d>*"+a+"</label>");
}
%>
</div>
</form>
</body>
</html>