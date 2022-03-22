/**
 * 
 */
 var expression='';
 var res=0;
 
 var ex='';
 var temp='';
 
 var flag=true;
 var flag2=true;
 var flag3=true;
 var flag4=true;
 
 function display(no){
	
	if((no=='+'||no=='-'||no=='*'||no=='/')&&document.getElementById("dis").value==""){

   document.getElementById("dis").value=0;


 }
	if((temp=='+'||temp=='*'||temp=='/')&&no!='-'&&Number.isNaN(Number(no))&&no!='('){
		flag3=false;
	}
	if(Number.isInteger(no)){
		flag=true;
		flag2=true;
		flag4=true;
		
	}
	if(temp=='.'&&no=='.'){
		flag4=false;
	}
	if((temp=='-'&&!flag2)||(temp=='.'&&!flag4)){
		no='';
		
	}
	if(temp=='('&&(no=='+'||no=='*'||no=='/')){
		no='';
	}
	if((temp==''||temp=='+'||temp=='-'||temp=='*'||temp=='/'||temp=='(')&&no=='-'){
		flag=false;
		flag2=false;
	}
	
	ex= document.getElementById("dis").value+=no;
	
	if(!flag3&&no!='-'&&Number.isNaN(Number(no))&&no!='('){
		var sub=ex.substring(0,ex.length-2);
		document.getElementById("dis").value=sub+no;
		flag3=true;
	}
	

	
	
	if(no!=''){
	temp=no;
  }
  if(no=='+'&&flag){
	color();
	document.getElementById("plus").style.background="green";
	document.getElementById("display").value=" ";
	flag4=true;
}
else if(no=='-'&&flag){
	color();
	document.getElementById("minus").style.background="green";
	document.getElementById("display").value=" ";
	flag4=true;
}
else if(no=='*'&&flag){
	color();
	document.getElementById("mul").style.background="green";
	document.getElementById("display").value=" ";
	flag4=true;
}
else if(no=='/'&&flag){
	color();
	document.getElementById("div").style.background="green";
	document.getElementById("display").value=" ";
	flag4=true;
}
else if(!Number.isNaN(Number(no))||no=='.'){
	document.getElementById("display").value+=no;
	var commaReplaced=document.getElementById("display").value.replaceAll(",","");
	 commaReplaced=commaReplaced.replaceAll(" ","");
	document.getElementById("display").value=comma(commaReplaced);
}
 }
function evaluate(expression){
	var array=expression.split("");
	var count1=0;
	var count2=0;
	var datas=[];
	
	var operand=[];
	for(var i=0;i<array.length;i++){
		if((array[i]>=0&&array[i]<=9)||(array[i]=='-'&&!flag&&(Number.isNaN(Number(array[i-1]))||array[i-1]==undefined))||array[i]=='.'||(array[i-1]=='('&&array[i]=='-')){
			var temp='';
			console.log(array[i-1]);
	     while((i<array.length&&array[i]>=0&&array[i]<=9)||((Number.isNaN(Number(array[i-1]))||array[i-1]==undefined)&&array[i]=='-'&&!flag)||array[i]=='.'||(array[i-1]=='('&&array[i]=='-')){
		  temp=temp+array[i];
		 
		  i++;
		}
		datas.push(Number(temp));
		i--;
		}
		else if(array[i]=='('||array[i]==')'){
			if(array[i]=='('){
				operand.push(array[i]);
				++count1;
			}
			else{
				++count2;
				while(operand[operand.length-1]!='('){
					res=operation(operand.pop(),datas.pop(),datas.pop());
	                datas.push(res);
				}
				operand.pop();
			}
		}
		else {
			while(operand.length>0&&(check(array[i],operand[operand.length-1]))){
				res=operation(operand.pop(),datas.pop(),datas.pop());
	       datas.push(res);
	       }
			
			operand.push(array[i]);
			}
		
	}
	console.log(datas);
	
	console.log(operand);
	while(operand.length>0){
		
	res=operation(operand.pop(),datas.pop(),datas.pop());
	datas.push(res);
	}
	document.getElementById("display").value=comma(res);
	if(count1!=count2){
		document.getElementById("display").value="give brackets correctly"
	}

}
function check(op1,op2){
	if((op1=='+'||op1=='-')&&(op2=="*"||op2=='/')){
		return true;
	}
	else if(op1=='+'&&op2=='-'){
		return true;
	}
	else if(op1=='*'&&op2=='/'){
		return true;
	}
	else{
		return false;
	}
}
function operation(op,data2,data1){
	var result=0;
	if(op=='+'){
		result=data1+data2;
	}
	if(op=='-'){
		result=data1-data2;
	}
	if(op=='*'){
		result=data1*data2;
	}
	if(op=='/'){
		result=data1/data2;
	}
	return result;
}

function results(){
	

evaluate(ex);


color();

}
function color(){
	document.getElementById("plus").style.background="";
	document.getElementById("minus").style.background="";
	document.getElementById("mul").style.background="";
	document.getElementById("div").style.background="";
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