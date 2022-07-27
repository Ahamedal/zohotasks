/**
 * 
 */
 function validation(){
	var name=document.getElementById("name").value;
	var isValid=false;
	var regex=/^[a-zA-Z ]*$/;
	isValid=regex.test(name);
	if(!isValid){
		document.getElementById("name").style.border="1px solid red";
		document.getElementById("nameErr").innerHTML="*please enter alphapets and space only";
		return;
	}
	else{
		document.getElementById("nameErr").innerHTML="";
		document.getElementById("name").style.border="1px solid blue";
	}
	
	
	var dob=document.getElementById("dob").value;
	var regex= /^\d{2}([-])\d{2}\1\d{4}$/;
	var isValid=regex.test(dob);
	if(!isValid){
		document.getElementById("dob").style.border="1px solid red";
		document.getElementById("dobErr").innerHTML="*please enter correct date format(MM-DD-YYYY)";
		return;
	}
	else{
		document.getElementById("dobErr").innerHTML="";
		document.getElementById("dob").style.border="1px solid blue";
	}
	let part=[];
	part=dob.split('-');
	let month=parseInt(part[0]);
	let days=parseInt(part[1]);
	let year=parseInt(part[2]);
	
	let listOfDays=[31,28,31,30,31,30,31,31,30,31,30,31];
	if(month==1||(month>2&&month<13)){
		if (days>listOfDays[month-1]){      
           document.getElementById("dobErr").innerHTML="*Date is out of range";
           return;         
        } 
     }
     else if(month==2){
	      let leapYear = false;      
            if ( (!(year % 4) && year % 100) || !(year % 400)) {      
                leapYear = true;      
            }      
            if ((leapYear == false) && (days>=29)){
	            document.getElementById("dob").style.border="1px solid red";   
                document.getElementById("dobErr").innerHTML="*Date is out of range";
                return;    
            }else      
            if ((leapYear==true) && (days>29)){
	            document.getElementById("dob").style.border="1px solid red";      
                document.getElementById("dobErr").innerHTML="*Date is out of range";
                return;      
            }      
     }
     else{
 	     document.getElementById("dobErr").innerHTML="*Month is out of range";
 	     return;
     }
     
		document.getElementById("dobErr").innerHTML="";
		document.getElementById("dob").style.border="1px solid blue";
	
     
     var mobileNumber=document.getElementById("mno").value;
     var regex=/^[0-9]*$/;
     var isValid=regex.test(mobileNumber);
     if(mobileNumber.length!=10||!isValid){
	            document.getElementById("mno").style.border="1px solid red";      
                document.getElementById("mnoErr").innerHTML="*Allows only ten digit numbers";
                return;
     }
		document.getElementById("mnoErr").innerHTML="";
		document.getElementById("mno").style.border="1px solid blue";
		localStorage.setItem("name",name);
		localStorage.setItem("dob",dob);
		var sex=document.getElementById("sex");
		var gender= sex.options[sex.selectedIndex].text;
		localStorage.setItem("sex",gender);
		localStorage.setItem("mno",mobileNumber);
	    location.href="CustomerDetails.html";

}