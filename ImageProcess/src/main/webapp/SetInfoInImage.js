/**
 * 
 */

 const obj1={OrganisationName:"ZOHO",CEO:"SridharVembu",YearOfStart:"1997"};
 const obj2={OrganisationName:"Google",CEO:"SundarPichai",YearOfStart:"1998"};
 const obj3={OrganisationName:"Facebook",CEO:"Mark Zuckerberg",YearOfStart:"2004"};
 const obj4={OrganisationName:"Whatsapp",CEO:"Will Catcart",YearOfStart:"2009"};
 const obj5={OrganisationName:"Jio",CEO:"Mukesh Ambani",YearOfStart:"2007"};
 const obj6={OrganisationName:"Airtel",CEO:"Gopal Vittal",YearOfStart:"1995"};
 const obj7={OrganisationName:"Wipro",CEO:"Thierry Delaporte",YearOfStart:"1945"};
 const obj8={OrganisationName:"Infosys",CEO:"Salil Parekh",YearOfStart:"1981"};
 const obj9={OrganisationName:"TCS",CEO:"Rajesh Gopinathan",YearOfStart:"1968"};
 const obj10={OrganisationName:"Twitter",CEO:"Parag Agarwal",YearOfStart:"2006"};
 
 
 var groupOfObj=new Map([["img1",obj1],["img2",obj2],["img3",obj3],["img4",obj4],["img5",obj5],["img6",obj6],["img7",obj7],["img8",obj8],["img9",obj9],["img10",obj10]]);
 

 document.getElementById("img1").onclick=userClicked;
 document.getElementById("img2").onclick=userClicked;
 document.getElementById("img3").onclick=userClicked;
 document.getElementById("img4").onclick=userClicked;
 document.getElementById("img5").onclick=userClicked;
 document.getElementById("img6").onclick=userClicked;
 document.getElementById("img7").onclick=userClicked;
 document.getElementById("img8").onclick=userClicked;
 document.getElementById("img9").onclick=userClicked;
 document.getElementById("img10").onclick=userClicked;

function userClicked(){
	var str1="";
	var id=this.id;
	const object=groupOfObj.get(id);
	for(let key in object){
		str1+=key+":";
	    str1+=object[key]+"\n";
 
    }
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
    image01.style.top=y+'px';
    image01.innerHTML=str1;
    
 }