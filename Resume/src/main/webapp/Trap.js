/**
 * 
 */
 function t(){
	
var n1=200;
	var n2=300;
	var b=7;
	var map=new Map();
	for(var k=n1;k<=n2;k++){
	var	a=k;
		while(true){
			if((a%b)==0||(b%a)==0){
				map.set(k,b);
				b=b+2;
				break;
			}
			else{
				
			if(a<10){
					if(b>3){
						b--;
						}
					break;
				}
			
			}
			var c=sum(a);
			a=c;
		}
	}
	
	for(var value of map){
		document.getElementById("id").innerHTML+="<ul><li>"+value+"</li></ul>";
		
	}
	document.getElementById("size").innerHTML="map size is ="+map.size;
	}
	function sum(v){
		var c=0;
		while(v>0){
		var k=v%10;
		c=c+k;
		v=Math.floor(v/10);
	}
	return c;	
	}
	
	function binary(){
		var no=document.getElementById("number").value;
		var result="";
		var ones=0;
		while(no>=1){
			var r=no%2;
			ones=ones+r;
			result=r+result;
			no=Math.floor(no/2);
		
			
			
		}
		document.getElementById("b").innerHTML="binary value is="+result+"<br> no of ones is="+ones;
	}
   function datas(){
	
	var data=document.getElementById("data").value;
	for(let i=0;i<data;i++){
		var label=document.createElement("label");
		label.setAttribute("id","f"+i);
		document.body.appendChild(label);
		document.getElementById("f"+i).innerHTML=i+1+"- Father:";
	
		
		var text=document.createElement("input");
		text.setAttribute("type","text");
		text.setAttribute("name","fathers");
		document.body.appendChild(text);
		
		var label2=document.createElement("label");
		label2.setAttribute("id","s"+i);
		document.body.appendChild(label2);
		document.getElementById("s"+i).innerHTML="Son:";
		
		var text2=document.createElement("input");
		text2.setAttribute("type","text");
		text2.setAttribute("name","sons");
		document.body.appendChild(text2);
		
		var br=document.createElement("br");
		document.body.appendChild(br);
		
		
	}
	
  	var button=document.createElement("button");
		button.setAttribute("onclick","values()");
		button.setAttribute("id","bb");
		document.body.appendChild(button);
		 document.getElementById("bb").innerHTML="Submit";
		
}
function values(){
		var br=document.createElement("br");
		document.body.appendChild(br);
 var label2=document.createElement("label");
		label2.setAttribute("id","s");
		document.body.appendChild(label2);
		document.getElementById("s").innerHTML="Enter grand father name:";
	
  var text21=document.createElement("input");
		text21.setAttribute("type","text");
		text21.setAttribute("id","ii");
		document.body.appendChild(text21);
		
  var button=document.createElement("button");
  button.setAttribute("onclick","answer()");
		button.setAttribute("id","bbc");
		document.body.appendChild(button);
		 document.getElementById("bbc").innerHTML="Submit";

	
}
function answer(){
	var para=document.createElement("p");
		para.setAttribute("id","sonn");
		document.body.appendChild(para);
	var map=new Map();
    var l=null;
	const father=document.getElementsByName("fathers");
		const son=document.getElementsByName("sons");
	
	for(let i=0;i<father.length;i++)
	{
		
		
		
		
		if(map.get(father[i].value)==null){
			l=new Array();
			map.set(father[i].value,l);
			}
		map.get(father[i].value).push(son[i].value);
		
		}
	for(var value of map){
	document.getElementById("v").innerHTML+=value+"&";
	}
	var vv=document.getElementById("ii").value;
	var sonnn=map.get(vv);
	var count=0;
	var k=[];
	for(let i=0;i<sonnn.length;i++){
		var grandSon=map.get(sonnn[i]);
		if(grandSon!=undefined){
		count=count+grandSon.length;
	   k.push(grandSon);
	}
	}
	if(count==1){
	 document.getElementById("sonn").innerHTML+="he is :"+k+"<br>"+"total grandson are="+count;
	 }
	 else if(count>1){
		 document.getElementById("sonn").innerHTML+="They are :"+k+"<br>"+"total grandsons are="+count;
	}
	else {
		 document.getElementById("sonn").innerHTML+="no grandson here";
	}
	
}
