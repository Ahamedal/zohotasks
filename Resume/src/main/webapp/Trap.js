/**
 * 
 */
 function t(){
var n1=15;
	var n2=45;
	var b=50;
	var a=n1;
	var map=new Map();
	console.log("a");
	while(a<=n2){
		
	var c=0;

	var result="b";
var c=sum(a);
var c=sum(c);
console.log(c);
	if(a==b){
		console.log(a+" "+b);
		map.set(a,b);
		result="trap";
	}
	else if(a%b==0||b%a==0) {
		console.log(a+" "+b);
		map.set(a,b);
		result="trap";
	}
	else if(c%b==0||b%c==0){
		console.log(a+" "+b);
		map.set(a,b);
		result="trap";
	}
	if(result=="trap"){
		b=b+2;
	}
	else{
		if(b>3) {
		b=b-1;
		}
	}
	++a;
	}
	for(var value of map){
		document.getElementById("id").innerHTML+=value+"@";
	}
	}
	function sum(v){
		var c=0;
		while(v>=1){
		var k=v%10;
		c=c+k;
		v=v/10;
	}
	return Math.floor(c);	
	}
