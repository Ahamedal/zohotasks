/**
 * 
 */
function generateTable() {
	var table = document.createElement("table");

	for (var i = 0; i < 4; i++) {
		var row = document.createElement("tr");
		for (var j = 0; j < 2; j++) {
			var col = document.createElement("td");
			col.setAttribute("id", "bdetails" + i + "," + j);
			row.appendChild(col);
		}
		table.appendChild(row);
	}

	var showTable = document.getElementById("tables");
	showTable.appendChild(table);
	document.getElementById("bdetails0,0").innerHTML = "Browser Name";
	document.getElementById("bdetails0,1").innerHTML = document.getElementById("bName").value;

	document.getElementById("bdetails1,0").innerHTML = "Browser Version";
	document.getElementById("bdetails1,1").innerHTML = document.getElementById("bVersion").value;

	document.getElementById("bdetails2,0").innerHTML = "Screen Width";
	document.getElementById("bdetails2,1").innerHTML = document.getElementById("sWidth").value;

	document.getElementById("bdetails3,0").innerHTML = "Screen Height";
	document.getElementById("bdetails3,1").innerHTML = document.getElementById("sHeight").value;

}