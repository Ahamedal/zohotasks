/**
 * 
 */
 var store=0;
 var temp=0;
 var x=0;
 var a='';
 var k='';
 var s=0;
 var flag=true;	
 var flag2=true;
 var temp2='';
 function number(no){
	if(temp!=0||temp2!=''){
		document.getElementById("display").value="";
	}
	
	document.getElementById("display").value+=no;
	flag2=true;
	temp2='';
	flag=true;
   
     
 }
function result(r){
	var y=0;
	flag=true;
	document.getElementById("plus").style.background="";
	document.getElementById("minus").style.background="";
	document.getElementById("mul").style.background="";
	document.getElementById("div").style.background="";
	if(r=='c'){
		document.getElementById("display").value="";
		document.getElementById("dis").value="";
		store=0;
         s=0;
         a='';
         k='';
          temp2='';
           temp=0;
    
	}
	
	else{
	
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
  else{
	y=x;
}
  document.getElementById("display").value=y;
  temp=y;
 temp2='';
  store=0;
  s=0;
  a='';
  k='';
  }

}
function operator(no){
	
	
	if(store==0){
	store=Number(document.getElementById("display").value);
	}
	else if(flag2){
		 
    s=Number(document.getElementById("display").value);
    
    
     }
    if(a!=''&&s!=0){
	
	if(a=='+'){
		store+=s;
	}
	else if(a=='-'){
		store-=s;
		
	}
	else if(a=='*'){
		store*=s;
		
	}
	else if(a=='/'){
		store/=s;
	}
	a='';
}
  
   if(flag==false){
	temp2='';
}
else{
  temp2='a';
  }
	if(no==='+'&&temp2=='a'){
		
		flag2=false;	
		a=no;
		
		
	document.getElementById("plus").style.background="green";
	document.getElementById("minus").style.background="";
	document.getElementById("mul").style.background="";
	document.getElementById("div").style.background="";
	
	}
	if(no==='-'&&temp2=='a'){
		
	
	if((flag2==false)){
			
			document.getElementById("display").value=no;
			document.getElementById("minus").style.background="";
			temp2='';
			flag=false;
		}
		else if(a!=''&&s==0){
			document.getElementById("display").value=no;
			temp2='';
			flag=false;
		}
		else if(store==0&&s==0){
			document.getElementById("display").value=no;
			temp2='';
			flag=false;
		}
		else{
			temp2='a';
			flag2=false;
			document.getElementById("minus").style.background="green";
	document.getElementById("plus").style.background="";
	document.getElementById("mul").style.background="";
	document.getElementById("div").style.background="";
			a=no;
			
			
		}
	}
	if(no==='*'&&temp2!=''){
		
		a=no;
	flag2=false;
	
	document.getElementById("mul").style.background="green";
	document.getElementById("plus").style.background="";
	document.getElementById("minus").style.background="";
	document.getElementById("div").style.background="";
	
	}
	if(no==='/'&&temp2!=''){
	a=no;
		
		flag2=false;
	
	document.getElementById("div").style.background="green";
	document.getElementById("plus").style.background="";
	document.getElementById("minus").style.background="";
	document.getElementById("mul").style.background="";
	}
	

}
function display(no){

	if(temp!=0){
		document.getElementById("dis").value=temp;
	
	}
		document.getElementById("dis").value+=no;
		temp=0;
	
}
