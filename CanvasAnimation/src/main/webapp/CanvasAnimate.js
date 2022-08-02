/**
 * 
 */
 window.onload=animation1;
 
 function animation(){
	
	var myCanvas=document.getElementById("myCanvas");
	var context=myCanvas.getContext("2d");
	var r=25;
	var x=-50;
	var x1=myCanvas.width+r;
	var y=-50;
	var y1=myCanvas.width+r;
		
	setInterval(function(){
		context.fillStyle="black";
		context.fillRect(0,0,myCanvas.width,myCanvas.height);
		context.beginPath();
		
		context.fillStyle="red";
		context.arc(x++,myCanvas.height/2,r,0,2*Math.PI);
		context.fill();
		context.beginPath();
		context.arc(x1--,myCanvas.height/2,r,0,2*Math.PI);
		context.fill();
		context.beginPath();
		context.arc(myCanvas.width/2,y++,r,0,2*Math.PI);
		context.fill();
		context.beginPath();
		context.arc(myCanvas.width/2,y1--,r,0,2*Math.PI);
		context.fill();
		
		
		if(y>=myCanvas.width+r){
			y=-50;
		}
		if(x1<=-50){
			x1=myCanvas.width+r;
		}
		if(y1<=-50){
			y1=myCanvas.width+r;
		}
		
	},10)
}

var flag2=false;
function animation1(){
	var flag=false;
	var myCanvas=document.getElementById("myCanvas");
	var context=myCanvas.getContext("2d");
	var r=25;
	var x=-25;
	var y=myCanvas.height/4;
	setInterval(function(){
	context.fillStyle="black";
	context.fillRect(0,0,myCanvas.width,myCanvas.height);
	context.beginPath();
	
	context.fillStyle="red";
	if(x<myCanvas.width&&!flag){
		
		x+=2;
	}
	else if(x>=myCanvas.width||flag){
		if(x<=0){
			flag=false;
		}
		else{
		flag=true;
		x-=2;
		y++;
		}
	}
	
	
	context.arc(x,y,r,0,2*Math.PI);
	context.fill();
	if(y>=myCanvas.height){
		x=-25;
	    y=myCanvas.height/4;
	    flag=false;
	}
	},10)
	
}