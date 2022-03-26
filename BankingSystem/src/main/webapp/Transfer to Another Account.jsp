<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<% 	if(session.getAttribute("id")==null) {
			RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			rd.forward(request, response);
		}%>
		<%
response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
%>
<title>Transfer to Another Account</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
<script>  
function Numeric(evt)
{
    var charCode = (evt.which) ? evt.which : event.keyCode;
        if (charCode > 31 && ( charCode < 48 || charCode > 57))
        {
            document.getElementById("span").innerHTML = "*Please enter Numeric value only!";
            return false;
        }
        else
        {
            document.getElementById("span").innerHTML = "";
           
            return true;
        }
}
 
</script>
</head>
<body>
<jsp:include page="adminloginpage.jsp" ></jsp:include>
<br><br>
<form action="TransferToAnotherAccount" method="post">

<div class="divv">
<center><h2>Transfer to another Account</h2></center>
<h3>From account:</h3>
<label for="uAccNo"></label>
<input type="text" placeholder="enter AccountNo" name="uAccNo" onkeypress="return Numeric(event)" required> <br>
<h3>To account:</h3>
<label for="uaccNo"></label>
<input type="text" placeholder="enter AccountNo" name="uaccNo" onkeypress="return Numeric(event)" required><br>
<label for="uDep"></label>
<input type="text" placeholder="enter deposit" name="uDep" onkeypress="return Numeric(event)" required><br>

<button type="submit" id="b" name="page" value="admin">submit</button>
<label id="d"><span id="span"></span></label>
<br><br>
<%
 String a=(String)request.getAttribute("transfers");
if(a!=null){
	out.print("<label id=d>*"+a+"</label>");
}
%>
<%
 String error=(String)request.getAttribute("same");
if(error!=null){
	out.print("<label id=d>*"+error+"</label>");
}
%>
</div>
</form>
</body>
</html>