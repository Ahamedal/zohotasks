<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddCustomer</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
<jsp:include page="adminloginpage.jsp" ></jsp:include>
<script>
        function checkString(form) {
            if (form.uname.value.trim() == null ||
                form.uname.value.trim() == undefined ||
                form.uname.value.trim().length == 0) {
               
            	 document.getElementById("span").innerHTML = "*String Cannot be null or Empty!";
                return false;
            } 
            else if (form.uadd.value.trim() == null ||
                    form.uadd.value.trim() == undefined ||
                    form.uadd.value.trim().length == 0) {
                   
                	 document.getElementById("span").innerHTML = "*String Cannot be null or Empty!";
                    return false;
                } else {
                	form.uname.value=form.uname.value.trim();
                	form.uadd.value=form.uadd.value.trim() 
                    alert("Your response has been recorded Successfully\n");
                    return true;
                }
        }
    </script>
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
<form action="AddCustomer" method="post" name="form" onsubmit="return checkString(form)" >
<div>
<h5>*please fill all details to below here</h5>
<label for="uname">username:</label><br>
<input type="text" placeholder="enter username" name="uname" <% if(id!=null){%>value="<%out.print((String)(request.getAttribute("name"))); %>"<%} %>  required > <br>
<label for="uadd">useraddress:</label><br>
<input type="text" placeholder="enter useradress" name="uadd" <% if(id!=null){%> value="<%out.print((String)(request.getAttribute("address"))); %>"<%} %> required ><br>
<label for="umob">mobileno:</label><br>
<input type="text" placeholder="enter usermobileno" name="umob"  <% if(id!=null){%> value="<%out.print((Long)(request.getAttribute("mobileno"))); %>" <%} %>onkeypress="return Numeric(event)" required ><br>


<button name="userId1" value="<%out.print(id);%>" type="submit" id="b">register</button><br>
<label id="d"><span id="span"></span></label>
</div>
</form>
</body>
</html>