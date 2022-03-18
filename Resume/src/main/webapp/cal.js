/**
 * 
 */
 var store=0;
 var store2=0;
 var x=0;
 var a='';
 var k='';
 var s=0;
 var flag=true;	
 function number(no){
	
	document.getElementById("display").value+=no;
   
     
 }
function result(r){
	var y=0;
	flag=true;
	if(r=='c'){
		document.getElementById("display").value="";
		store=0;
         s=0;
         a='';
         k='';
    document.getElementById("plus").style.background="";
	document.getElementById("minus").style.background="";
	document.getElementById("mul").style.background="";
	document.getElementById("div").style.background="";
	}
	
	else{
	document.getElementById("plus").style.background="";
	document.getElementById("minus").style.background="";
	document.getElementById("mul").style.background="";
	document.getElementById("div").style.background="";
   x=Number(document.getElementById("display").value);
  
   if(a=='+'){
  y=store+x;
  }
  else if(a=='-'){
	
  y=store-x;
  }
  else if(a=='*'){
   
  y=store*x;
  }
  else if(a=='/'){
  y=store/x;
  }
  document.getElementById("display").value=y;
  store=0;
  a='';
  }

}
function operator(no){
	
	
	if(store==0){
	store=Number(document.getElementById("display").value);
	}else{
    s=Number(document.getElementById("display").value);
     }
if(a!=''&&s!=0){
	
	if(a=='+'){
		store+=s;
	}
	else if(a=='-'){
		document.getElementById("minus").style.background="green";
		store-=s;
	}
	else if(a=='*'){
		store*=s;
	}
	else if(a=='/'){
		store/=s;
	}
}

	document.getElementById("display").value=" ";
	
	
	
     
	if(no==='+'&&store!=0){
		
		a=no;
		
		k='a';
	document.getElementById("plus").style.background="green";
	document.getElementById("minus").style.background="";
	document.getElementById("mul").style.background="";
	document.getElementById("div").style.background="";
	}
	if(no==='-'){
		
	
	if(k=='a'&&s==0){
			
			document.getElementById("display").value+=no;
			document.getElementById("minus").style.background="";
			flag=false;
		}
		else if(a!=''&&s==0){
			document.getElementById("display").value+=no;
			flag=false;
		}
		else if(store==0&&s==0){
			document.getElementById("display").value+=no;
			flag=false;
		}
		else{
			document.getElementById("minus").style.background="green";
	document.getElementById("plus").style.background="";
	document.getElementById("mul").style.background="";
	document.getElementById("div").style.background="";
			a=no;
			
		}
	}
	if(no==='*'&&store!=0){
		
		a=no;
	
		k='a';
	document.getElementById("mul").style.background="green";
	document.getElementById("plus").style.background="";
	document.getElementById("minus").style.background="";
	document.getElementById("div").style.background="";
	}
	if(no==='/'&&store!=0){
	
			a=no;
		
		k='a';
		
	document.getElementById("div").style.background="green";
	document.getElementById("plus").style.background="";
	document.getElementById("minus").style.background="";
	document.getElementById("mul").style.background="";
	}
}
