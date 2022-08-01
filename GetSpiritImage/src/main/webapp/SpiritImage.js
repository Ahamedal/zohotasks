/**
 * 
 */
const SPRITE_WIDTH = 13;
const SPRITE_HEIGHT = 14;
const BORDER_WIDTH = 1;
const SPACING_WIDTH = 1;
var position=0;

function spritePositionToImagePosition(row, col) {
    return {
        x: (
            BORDER_WIDTH +
            col * (SPACING_WIDTH + SPRITE_WIDTH)
        ),
        y: (
            BORDER_WIDTH +
            row * (SPACING_WIDTH + SPRITE_HEIGHT)
        )
    }
}
function getImage(){
var canvas = document
            .createElement('canvas');
var context = canvas
              .getContext('2d');

var spriteSheetURL = 'https://codehs.com/uploads/e4cfb06e001bd92cf41139928e88819a';
//var spriteSheetURL="https://www.formget.com/wp-content/uploads/2014/12/2015-01-13_1032.png";
var image = new Image();
image.src = spriteSheetURL;

  


	
context.drawImage(
        image,
        position.x,
        position.y,
        SPRITE_WIDTH,
        SPRITE_HEIGHT,
        0,
        0,
        150,
        150
 );

document.body.appendChild(canvas);
}
function getImage1(){
	
   var row=document.getElementById("row").value;
   var col=document.getElementById("col").value;
   
   if(isNaN(parseInt(row))&&!isNaN(parseInt(col))){
   for(var i=0;i<2;i++){
   position = spritePositionToImagePosition(i,col);
   getImage();
   }
   }
   else if(isNaN(parseInt(col))&&!isNaN(parseInt(row))){
   for(var i=0;i<3;i++){
   position = spritePositionToImagePosition(row,i);
   getImage();
   }
   }
   else{
   position = spritePositionToImagePosition(row,col);
   getImage2();
   }
}
function getImage2(){
	var canvas = document
            .createElement('canvas');
var context = canvas
              .getContext('2d');

var spriteSheetURL = 'https://codehs.com/uploads/e4cfb06e001bd92cf41139928e88819a';
//var spriteSheetURL="https://www.formget.com/wp-content/uploads/2014/12/2015-01-13_1032.png";
var image = new Image();
image.src = spriteSheetURL;

  

image.onload=function(){
	
context.drawImage(
        image,
        position.x,
        position.y,
        SPRITE_WIDTH,
        SPRITE_HEIGHT,
        0,
        0,
        150,
        150
 );
}
document.body.appendChild(canvas);
}