/**
 * 
 */
 var elem = document.getElementById("img1");
 var left=0;
 var t=0;
 var id;
 var id1;

 function myMove() {
  elem.style.top="150px";
  elem.style.left="50px";
   left=50;
  var pos = 0;
  id = setInterval(frame, 5);
  function frame() {
    if (pos == 350) {
         myMove1();
         clearInterval(id);
    } else {
      pos++; 
      left++;
     elem.style.left = left + 'px';
      document.getElementById("msg").innerHTML="left is: "+left; 
    }
  }
}
function myMove1(){
	t=0;
	elem.style.top="0px";
	elem.style.left="150px";
	var pos = 0;
     id1 = setInterval(frame, 5);
  function frame() {
    if (pos == 350) {
	   myMove();
       clearInterval(id1);
    } else {
      pos++; 
      t++;
     elem.style.top = t + 'px'; 
     document.getElementById("msg").innerHTML="top is: "+t;
    }
  }
}
function pause(){
	clearInterval(id);
     clearInterval(id1);
}
function reset(){
pause();
elem.style.left= "50px";
elem.style.top= "150px";

}
 /*var dir_h='right';
var dir_v='down';
function reset1(){
clearTimeout(my_time);
document.getElementById('img1').style.left= "500px";
document.getElementById('img1').style.top= "100px";
document.getElementById("msg").innerHTML="";
}


function disp(){
var step=1; //;
var y=document.getElementById('img1').offsetTop;
var x=document.getElementById('img1').offsetLeft;
document.getElementById("msg").innerHTML="X: " + x  + " Y : " + y
if(y < 400 ){y= y +step;
document.getElementById('img1').style.top= y + "px"; // vertical movment
}else{
if(x < 800){x= x +step;
document.getElementById('img1').style.left= x + "px";//horizontal move
}
}
//////////////////////
}
// Now move to new position of x & y value
function timer(){
disp();
my_time=setTimeout('timer()',10);
}
*/
//////////////////////

 

/*var left = 0,
    right=0;
    tank = document.getElementById('img1'),
    timerId = 0;
var i=0;
function leftMove(){
timerId = setInterval( function() { //This function is called by the browser every 33 milliseconds
    if( i>100 ) {
         i=0;
         clearInterval( timerId );
    }
    i++;
    left++;
    tank.style.left = left + "px";
    
}, 33 );
}
	
	
function MoveDown() {
    var i=0;
    function step() {
       document.getElementById("Amanda").style.top=i+"px";
       i++;
       if (i<=100) setTimeout(step,10);
    }
    step();
}*/
