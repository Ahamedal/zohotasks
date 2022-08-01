/**
 * 
 */
var romanNum = new Array();
romanNum = ["M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"];
var dNum = new Array();
dNum = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
function decimalToRoman(value) {
	var romanNumeral = "Roman Number is: ";
	for (var i = 0; i < romanNum.length; i++) {
		while (value >= dNum[i]) {
			value -= dNum[i];
			romanNumeral += romanNum[i];
		}
	}
	return romanNumeral;
}
function romanToDecimal(value) {
if(value == null) return -1;
var num = char_to_int(value.charAt(0));
var pre, curr;

for(var i = 1; i < value.length; i++){
curr = char_to_int(value.charAt(i));
pre = char_to_int(value.charAt(i-1));
if(curr <= pre){
num += curr;
} else {
num = num - pre*2 + curr;
}
}

return num;
}

function char_to_int(c){
switch (c){
case 'I': return 1;
case 'V': return 5;
case 'X': return 10;
case 'L': return 50;
case 'C': return 100;
case 'D': return 500;
case 'M': return 1000;
default: return -1;
}

}
function chooseMethod() {
	var value = document.getElementById("value").value;
	if(!isNaN(parseInt(value))){
	document.getElementById("ans").innerHTML = decimalToRoman(value);
	}
	else{
	document.getElementById("ans").innerHTML = "Decimal Number is: "+romanToDecimal(value);	
	}
}
