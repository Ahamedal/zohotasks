/**
 * 
 */
 var imgs=["https://zohowebstatic.com/sites/default/files/ogimage/zoho-logo.png","https://blog.hubspot.com/hubfs/image8-2.jpg","https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg/2048px-Facebook_f_logo_%282019%29.svg.png","https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/WhatsApp.svg/479px-WhatsApp.svg.png","https://1000logos.net/wp-content/uploads/2021/07/Jio-Logo.png","https://download.logo.wine/logo/Airtel_Uganda/Airtel_Uganda-Logo.wine.png","https://images.news18.com/ibnlive/uploads/2017/05/Wipro-new-logo.jpg?im=FitAndFill","https://professionallyspeaking.net/wp-content/uploads/2017/04/infosys-logo-1.jpg","https://www.tcs.com/content/dam/tcs/images/logo/tata-logo-blue.png","https://thumbs.dreamstime.com/b/twitter-logo-bird-isolated-over-white-background-social-media-networking-communications-symbol-breaking-news-130861855.jpg"];
 
 document.onkeydown = function(event) {
    if (event.keyCode == '37'||event.keyCode=='40') { //LEFT
        changeImage(-1);
    } else if (event.keyCode == '39'||event.keyCode=='38') { //RIGHT
        changeImage(1);
    }
}



function changeImage(dir) {
    var img = document.getElementById("imgClickAndChange");
    var newSrc = imgs[imgs.indexOf(img.src)+dir];
    
    if (imgs.indexOf(newSrc) != -1) {
        img.src = newSrc;
    }
    else {
    if(dir==1){
    img.src=imgs[0];
    }
    else{
    img.src=imgs[imgs.length-1];
    }
    
    }
}