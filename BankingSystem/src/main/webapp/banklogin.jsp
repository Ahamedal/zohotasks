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
<body>  

<br><br><br><br><br><br><br>

<form  action="AccountServelets" method="post" name="myform1" onsubmit="return checkString(myform1)">
<div>
<center><i class="fa fa-bank" style="font-size:48px;color:black"></i></center>
<center><h3>Login here</h3></center>
<label for="uname">UserID:</label><br>
<input type="text" placeholder="enter userid" name="uname" required> <br>
<label for="pass">Password:</label><br>
<input type="password" placeholder="enter password" name="pass" required><br>

<button name="page" value="login"  type="submit" id="b"> <i class="fa fa-sign-in"></i> login</button>

<label id="d"><span id="span"></span></label>
<br>

<%
 String a=(String)request.getAttribute("login");
if(a!=null){
	out.print("<label id=d>*"+a+"</label>");
}
%>
</div>
<div class="container" style="background-color:gray">
    <button type="button" class="cancelbtn">Cancel</button>
    <button type="reset" style="float:right" >Reset</button><br>
  </div>
</form>



</body>
</html>