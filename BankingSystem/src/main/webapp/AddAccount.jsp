<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>AddAccount</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
<jsp:include page="adminloginpage.jsp" ></jsp:include><br><br>
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
<center><h2><%String id=request.getParameter("accId");
if(id!=null){
	out.print("Update Account");
}
else{
	out.print("Add Account");
}
%></h2></center>
<form action="AddAccount" method="post">
<div class="divv">
<h5>*please fill all details to below here</h5>

<label for="userId">UserId:</label><br>
<input type="text" placeholder="enter userId" name="userId" onkeypress="return Numeric(event)" <% if(id!=null){%> readonly="readonly" value="<%out.print(request.getParameter("userId")); %>" <%}%> required> <br>
<label for="uAT">AccountType:</label><br>
<select name="uAT" required>
   <option><% if(id!=null){%><%out.print(request.getParameter("accType")); %><%} else{%>Select Account Type<%} %> </option>
   <option>Savings</option>
   <option>Current</option>
</select>  
<label for="uAT">Branch:</label><br> 
<select name="uBr" required>
<option><% if(id!=null){%><%out.print(request.getParameter("branch")); %><%} else{%>Select Branch<%} %> </option>
<option>Karaikudi</option>
<option>Chennai</option>
<option>Selam</option>
</select>
<button name="userId1" value="<%out.print(id);%>" type="submit" id="b">register</button>
</div>
</form>
</body>
</html>