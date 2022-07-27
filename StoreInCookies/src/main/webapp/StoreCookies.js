/**
 * 
 */
 function checkCookies(){
	var cookie=document.cookie;
	if(cookie!=null&&cookie!=undefined&&cookie.includes("visited")){
		if(cookie.length>0){
		var seenCount=parseInt(cookie.split("=")[1]);
		seenCount++;
		document.cookie="visited="+seenCount+"";
		document.getElementById("cook").innerHTML="you have visit "+seenCount+" time in the browser";
	}
	}
	else{
		document.cookie="visited=1";
		document.getElementById("cook").innerHTML="You have visit first time in the browser";
	}
}
function deleteAllCookies() {
    var cookies = document.cookie.split(";");

    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}