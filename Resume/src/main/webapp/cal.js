/**
 * 
 */
 var store=0;
 var temp=0;
 var x=0;
 var a='';
 var temp3='';
 var s=0;
 var flag=true;	
 var flag2=true;
 var flag3=true;
 var flag4=true;
 var temp2='';
 function number(no){
	if(temp2!=''){
		document.getElementById("display").value="";
	}
	
	document.getElementById("display").value+=no;
	var commaReplaced=document.getElementById("display").value.replaceAll(",","");
	document.getElementById("display").value=comma(commaReplaced);
	
	flag2=true;
	temp2='';
	flag=true;
   
   
 }
function result(r){
	var y=0;
	flag=true;
	flag3=true;
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
    
          temp2='';
           temp=0;
    
	}
	
	else{
	document.getElementById("display").value=document.getElementById("display").value.replaceAll(",","");
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
  document.getElementById("display").value=comma(y);
  temp=y;
 temp2='';
  store=0;
  s=0;
  a='';
 
  }

}
function operator(no){
	
	
	if(store==0&&flag3){
	var aa=document.getElementById("display").value.replaceAll(",","");
	
	store=Number(aa);
	flag3=false;
	}
	else if(flag2){
		 
    s=Number(document.getElementById("display").value.replaceAll(",",""));
    
    
     }
    if(a!=''&&s!=0&&flag2){
	
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
	if(Number.isInteger(no)){
		flag4=true;
	}
	if(no=='-'&&document.getElementById("dis").value==""){
		flag3=false;
	}
	if(document.getElementById("dis").value=="-"){
	flag3=true;
	}
	if((no=='+'||no=='*'||no=='/')&&document.getElementById("dis").value==""){
document.getElementById("display").value=0;
document.getElementById("dis").value=0;
store=0;

}

	if(temp!=0){
		document.getElementById("dis").value=temp;
	
	}
	if((!flag4&&no=='.')||(temp3=='.'&&Number.isNaN(Number(no)))){
		no='';
	}
	   if(no=='.'){
		flag4=false;
	}
	
	    
		var ans=document.getElementById("dis").value+=no;
		temp3=no;
	 if(!flag2&&no!='-'){
		if(ans.charAt(ans.length-2)=='-'){
			var sub=ans.substring(0,ans.length-2);
			document.getElementById("dis").value=sub+'-';
			
		}
		else{
		var sub=ans.substring(0,ans.length-2);
		document.getElementById("dis").value=sub+no;
		}
	}
		
		temp=0;
	
}
function comma(value){
	var str=value.toString();
	
	var sp=str.split(".");
	
	var res=[];
	

	
	var a = 0, b = 0;
    for (var i = sp[0].length- 1; i >= 0; i--) {
        if (a < 3) {
            res.push(sp[0][i]);
            a++;
        } else if (b < 2) {
            if (b == 0&&sp[0][i]!='-') {
                res.push(",");
                res.push(sp[0][i]);
                b++;
            } else {
                res.push(sp[0][i]);
                b = 0;
            }
        }
    }
    var k=res.reverse();
    k=k.join(""); 
    if(sp[1]==undefined){
    k=k;
    }
    else{
	k=k+"."+sp[1];
}
    return k;
	
	
}
