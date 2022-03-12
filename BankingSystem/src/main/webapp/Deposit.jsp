<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Deposit</title>
<style>
button{
	background-color:lightblue;
	 padding: 2px; 
	 font-size:20px;
}
</style>
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
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
</head>
<body>   
<% 	if(session.getAttribute("id")==null) {
			RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			rd.forward(request, response);
		}%>
<jsp:include page="adminloginpage.jsp" ></jsp:include>

<br><br>
<form action="Deposit" method="post" >

<div class="divv" >
<center><h2>Deposit Here</h2></center>

<h5>*please fill all details to below here</h5>
<label for="uAccNo">Account No:</label><br>
<input type="text" placeholder="enter AccountNo" name="uAccNo" onkeypress="return Numeric(event)" required><br>
<label for="uDep">Deposit Money:</label><br>
<input type="text" placeholder="enter deposit" name="uDep" onkeypress="return Numeric(event)" min="1" required><br>

<button  type="submit" id="b">submit</button>
<label id="d"><span id="span"></span></label>
<br><br>
<%
 String a=(String)request.getAttribute("deposit");
if(a!=null){
	out.print("<label id=d>*"+a+"</label>");
}
%>
</div>
</form>
</body>
</html>