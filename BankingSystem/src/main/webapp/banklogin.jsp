<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banking System</title>
<link rel="stylesheet" type="text/css" href="BankStyle2.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
        function checkString(form) {
            if (form.uname.value.trim() == null ||
                form.uname.value.trim() == undefined ||
                form.uname.value.trim().length == 0) {
               
            	 document.getElementById("span").innerHTML = "*String Cannot be null or Empty!";
                return false;
            } 
          
                else {
                    
                    return true;
                }
        }
    </script>
</head>
<body class="img">  

<br><br><br><br><br><br><br>

<form  action="AccountServelets" method="post" name="myform1" onsubmit="return checkString(myform1)">
<div class="div111" >
<h2>AAS BANK</h2>
</div><br><br><br>
<div class="divv" id="login"><br>
<img id="iimg" src="https://www.w3schools.com/howto/img_avatar.png"  style="border-radius:50%" alt="Avatar">
<br><br>
<label for="uname">UserID:</label><br>
<input type="text" placeholder="enter userid" name="uname" onkeypress="return Numeric(event)" required> <br>
<label for="pass">Password:</label><br>
<input type="password" placeholder="enter password" name="pass" required><br>

<button name="page" value="login"  type="submit" id="b"> <i class="fa fa-sign-in"></i> login</button>
<input id="b" type="reset">
<label id="d"><span id="span"></span></label>
<br>

<%
 String a=(String)request.getAttribute("login");
if(a!=null){
	out.print("<label id=d>*"+a+"</label>");
}
%>
</div>

</form>



</body>
</html>