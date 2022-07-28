/**
 * 
 */

 
 const obj1={OrganisationName:"ZOHO",CEO:"SridharVembu",YearOfStart:"1997"};
 var str1="";
 for(let key in obj1){
		str1+=key+":";
	    str1+=obj1[key]+"\n";
 
 }
 document.getElementById("img1").setAttribute("alt",str1);
 function userClicked(){
	
	var image01=document.getElementById("img01");
	if(image01.style.display=="none"){
		image01.style.display='';
		
	}
	else{
		image01.style.display="none";
	}

	var x = event.clientX;
    var y = event.clientY;
    
    image01.style.position = 'absolute';
    image01.style.left = x + 'px';
    image01.style.top = y + 'px';
    image01.innerHTML=str1;
    
 }