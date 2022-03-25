/**
 * 
 */

var res = 0;
var ex2 = '';
var ex = '';
var temp = '';
var temp2 = '';
var str = '';
var ans = 0;
var flag = true;
var flag2 = true;
var flag3 = true;
var flag6 = true;
function display(no) {
	
	 if (no == 'pi') {
		if (!Number.isNaN(Number(temp)) && ex != '') {

			no = '*3.14';
		}
		else {
			no = 3.14;
			
		flag3=false;
		}
	}
	
	
	if ((no == '+' || no == '*' || no == '/') && document.getElementById("dis").value == "") {

		document.getElementById("dis").value = 0;


	}
	
	if (no == '(' && (!Number.isNaN(Number(temp)) || (temp == ')')) && (ex !== '')&&temp!='√') {
		no = '*(';
	}
	if ((temp == '+' || temp == '-' || temp == '*' || temp == '/' || temp == '%') && no != '-' && Number.isNaN(Number(no)) && no != '('&&no!=')') {
		flag3 = false;
	}
	if (Number.isInteger(no)) {

		flag2 = true;
		

	}
   if((no=='²'||no=='³')&&ex===''){
	no='';
}
	
	if ((temp == '-' && !flag2&&no!='(') || (temp == '.' && no=='.') || (temp == '.' && Number.isNaN(Number(no))) || (!flag6 && no == '.')) {
		no = '';

	}
	if (no == '.') {
		flag6 = false;
	}
	if(temp==3.14&&no=='.'){
		no='*.';
		document.getElementById("display").value ='.';
	}
	if (temp == '(' && (no == '+' || no == '*' || no == '/' || no == '%')) {
		no = '';
	}
	if ((temp == '' || temp == '+' || temp == '-' || temp == '*' || temp == '/' || temp == '(' || temp == '%') && no == '-') {
		document.getElementById("display").value = '-';
		flag = false;
		flag2 = false;
	}
	if (ans !== 0 || temp2 === 'a') {
		document.getElementById("dis").value = ans;
		ans = 0;
		temp2 = '';
	}
	ex = document.getElementById("dis").value += no;

	if (!flag3 && no != '-' && (Number.isNaN(Number(no))||no==3.14)&&Number.isNaN(Number(temp))  && no != '(' && no != '√' && (no != '.')) {
		var sub = ex.substring(0, ex.length - 2);
		document.getElementById("dis").value = sub + no;
		flag3 = true;
		if(no==3.14){
			var sub = ex.substring(0, ex.length - 5);
		document.getElementById("dis").value = sub + no;
		flag3 = true;
		}
	}




	if (no !== '' ) {
		temp = no;
		str += temp;
	}
	if (no == '+') {
		color();
		str = '';
		document.getElementById("plus").style.background = "green";
		document.getElementById("display").value = " ";
		flag6 = true;
	}
	else if (no == '-' && flag2) {
		color();
		str = '';
		document.getElementById("minus").style.background = "green";
		document.getElementById("display").value = " ";
		flag6 = true;
	}
	else if (no == '*' || no == '*(') {
		color();
		str = '';
		document.getElementById("mul").style.background = "green";
		document.getElementById("display").value = " ";
		flag6 = true;

	}
	else if (no == '/') {
		color();
		str = '';
		document.getElementById("div").style.background = "green";
		document.getElementById("display").value = " ";
		flag6 = true;
	}
	else if (no == '%') {
		color();
		document.getElementById("modul").style.background = "green";
		document.getElementById("display").value = " ";
		flag6 = true;
	}
	else if (no == '√') {
		color();
		document.getElementById("root").style.background = "green";
		document.getElementById("display").value = " ";
		
		str = '';
	}
    else if(no=='²'){
	color();
	document.getElementById("power").style.background = "green";
		document.getElementById("display").value = " ";
		str = '';
}
   else if(no=='³'){
	color();
	document.getElementById("cube").style.background = "green";
		document.getElementById("display").value = " ";
		str = '';
}
    
	else if (!Number.isNaN(Number(no)) || no == '.') {
		ex2 = document.getElementById("display").value += no;
		var commaReplaced = document.getElementById("display").value.replaceAll(",", "");
		commaReplaced = commaReplaced.replaceAll(" ", "");
		document.getElementById("display").value = comma(commaReplaced);
		if(no==3.14){
			var sub = ex.substring(0, ex.length - 5);
		document.getElementById("display").value = sub + no;
		}
	}
}
function evaluate(expression) {
	var ch = expression.charAt(expression.length - 1);
	if (Number.isNaN(Number(ch)) && ch != ')'&&ch!='²'&&ch!='³') {
		document.getElementById("display").value = "syntax error";
		return;
	}
	var index1 = expression.lastIndexOf(")");
	var index2 = expression.indexOf("(");
	if (index1 < index2 || (!expression.includes("(") && expression.includes(")"))) {
		document.getElementById("display").value = "syntax error";
		return;
	}

	var array = expression.split("");

	var count1 = 0;
	var count2 = 0;
	var datas = [];

	var operand = [];
	for (var i = 0; i < array.length; i++) {
		if ((array[i] >= 0 && array[i] <= 9) || (array[i] == '-' && !flag && (Number.isNaN(Number(array[i - 1])) || array[i - 1] == undefined)) || array[i] == '.' || (array[i - 1] == '(' && array[i] == '-')) {
			var temp = '';
			console.log(array[i - 1]);
			while ((i < array.length && array[i] >= 0 && array[i] <= 9) || ((Number.isNaN(Number(array[i - 1])) || array[i - 1] == undefined) && array[i] == '-' && !flag) || array[i] == '.' || (array[i - 1] == '(' && array[i] == '-')) {
				temp = temp + array[i];

				i++;
			}
			datas.push(Number(temp));
			i--;
		}
		else if (array[i] == '(' || array[i] == ')') {
			if (array[i] == '(') {
				operand.push(array[i]);
				++count1;
			}
			else {
				++count2;
				while (operand[operand.length - 1] != '('&&operand[operand.length - 1]!=undefined) {
					if(operand[operand.length-1]=='√'||operand[operand.length-1]=='²'||operand[operand.length-1]=='³'){
						res = operation(operand.pop(), datas.pop(), "");
					datas.push(res);
					}
					else{
					res = operation(operand.pop(), datas.pop(), datas.pop());
					datas.push(res);
					}
				}
				operand.pop();
			}
		}
		else {
			if(operand[operand.length-1]=='√'||operand[operand.length-1]=='²'||operand[operand.length-1]=='³'){
				while (operand.length > 0 && (check(array[i], operand[operand.length - 1]))) {
				res = operation(operand.pop(), datas.pop(),"");
				datas.push(res);
				}
			}
			else{
			while (operand.length > 0 && (check(array[i], operand[operand.length - 1]))) {
				res = operation(operand.pop(), datas.pop(), datas.pop());
				datas.push(res);
				}
			}

			operand.push(array[i]);
		}

	}
	console.log(datas);

	console.log(operand);
	
	while (operand.length > 0) {
     if(operand[operand.length-1]=='√'||operand[operand.length-1]=='²'||operand[operand.length-1]=='³'){
		res = operation(operand.pop(), datas.pop(),"");
		datas.push(res);
    }
    else{
		res = operation(operand.pop(), datas.pop(), datas.pop());
		datas.push(res);
		}
	}
    if (count1 != count2) {
		document.getElementById("display").value ="give brackets correctly";
	}
	res=document.getElementById("display").value = comma(datas.pop());
	ans =res.replaceAll(",","");
	temp2 = 'a';
		
	return res;
	
}
function check(op1, op2) {
	if ((op1 == '+' || op1 == '-') && (op2 == "*" || op2 == '/')) {
		return true;
	}
	else if (op1 == '+' && op2 == '-') {
		return true;
	}
	else if (op1 == '*' && op2 == '/') {
		return true;
	}

	else if (op2 == '%' && (op1 == '+' || op1 == '-'||op1=='%')) {
		return true;
	}
	else if(op2=='√'||op2=='²'||op2=='³'){
		return true;
	}
	else {
		return false;
	}
}
function operation(op, data2, data1) {
	var result = 0;
	if(data1==undefined){
		return data2;
	}
	
	if (op == '+') {
		result = data1 + data2;
	}
	if (op == '-') {
		result = data1 - data2;
	}
	if (op == '*') {
		result = data1 * data2;
	}
	if (op == '/') {
		result = data1 / data2;
	}
	if (op == '%') {
		result = data1 % data2;
	}
    if(op=='√'){
	result=Math.sqrt(data2);
	
}
    if(op=='²'){
	result=data2*data2;
}
if(op=='³'){
	result=data2*data2*data2;
}
	return result;
}

function results() {




	evaluate(ex);


	color();

}
function color() {
	document.getElementById("plus").style.background = "";
	document.getElementById("minus").style.background = "";
	document.getElementById("mul").style.background = "";
	document.getElementById("div").style.background = "";
	document.getElementById("power").style.background = "";
	document.getElementById("cube").style.background = "";
	document.getElementById("root").style.background = "";
	document.getElementById("modul").style.background = "";
	document.getElementById("pi").style.background = "";


}
function comma(value) {
	var str = value.toString();
	  if(str=='Infinity'){
		return Infinity;
	}
	  

	var sp = str.split(".");
 
	var res = [];



	var a = 0, b = 0;
	for (var i = sp[0].length - 1; i >= 0; i--) {
		if (a < 3) {
			res.push(sp[0][i]);
			a++;
		} else if (b < 2) {
			if (b == 0 && sp[0][i] != '-') {
				res.push(",");
				res.push(sp[0][i]);
				b++;
			} else {
				res.push(sp[0][i]);
				b = 0;
			}
		}
	}
	var k = res.reverse();
	k = k.join("");
	if (sp[1] == undefined) {
		k = k;
	}
	else {
		k = k + "." + sp[1];
	}
	return k;


}
function clears() {
	str = str.substring(0, str.length - 1);
	var sub = ex.substring(0, ex.length - 1);
	ex = document.getElementById("dis").value = sub;
	if (ex2 != ' ') {
		var sub2 = ex2.substring(0, ex2.length - 1);
		ex2 = document.getElementById("display").value = sub2;
	}
}
