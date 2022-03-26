<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WithDraw</title>
<% 	if(session.getAttribute("id")==null) {
			RequestDispatcher rd=request.getRequestDispatcher("banklogin.jsp");
			rd.forward(request, response);
		}%>
		<%
response.setHeader("cache-control", "no-cache,no-store,must-revalidate");
%>
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
<div class="divv">
<center><h2>WithDraw Here</h2></center>
<form  action="WithDraw" method="post" >
<h5>*please fill all details to below here</h5>
<label for="uAccNo">Account No:</label><br>
<input type="text"  placeholder="enter AccountNo" name="uAccNo" onkeypress="return Numeric(event)"required><br>
<label for="uWit">WithDraw Money:</label><br>
<input type="text"  placeholder="enter amount" name="uWit" onkeypress="return Numeric(event)" required><br>

<button type="submit" id="b">submit</button>

<label id="d"><span id="span"></span></label>
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