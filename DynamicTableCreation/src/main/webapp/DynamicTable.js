/**
 * 
 */

 
 function generateTable() {
	//Cookie c=new Cookie("visit",1);
	
	var table = document.createElement("table");

	for (var i = 0; i < 4; i++) {
		var row = document.createElement("tr");
		for (var j = 0; j < 2; j++) {
			var col = document.createElement("td");
			col.setAttribute("id", "bdetails" + i + "" + j);
			row.appendChild(col);
		}
		table.appendChild(row);
	}

	var showTable = document.getElementById("tables"+k);
	showTable.appendChild(table);
	document.getElementById("bdetails00").innerHTML = "Browser Name";
	document.getElementById("bdetails01").innerHTML = document.getElementById("bName").value;

	document.getElementById("bdetails10").innerHTML = "Browser Version";
	document.getElementById("bdetails11").innerHTML = document.getElementById("bVersion").value;

	document.getElementById("bdetails20").innerHTML = "Screen Width";
	document.getElementById("bdetails21").innerHTML = document.getElementById("sWidth").value;

	document.getElementById("bdetails30").innerHTML = "Screen Height";
	document.getElementById("bdetails31").innerHTML = document.getElementById("sHeight").value;

}