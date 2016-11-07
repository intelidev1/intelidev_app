//google.charts.load('current', {'packages': ['table', 'map']});
google.charts.load('current', {'packages': ['table']});
google.charts.setOnLoadCallback(initialize);
var ssKey = "1a4INQGgP4AaDCTmoGK0pPr_dE-Bgv0Mi8gJK-WaiY2k"
function initialize() {
	var query = new google.visualization.Query('http://spreadsheets.google.com/tq?key='+ssKey+'&pub=1');
	query.setQuery("SELECT A , B,C,D,E,G,H,I,J ");
	query.send(draw);
}


function draw(response) {
	if (response.isError()) {
		alert('Error in query');
	}
	var geoData = response.getDataTable();
	var geoTable =  new google.visualization.DataView(geoData);
    var table = new google.visualization.Table(document.getElementById('table_FULL'));
//	geoTable.setColumns([0,1,4,7,8,9]);
	geoTable.setColumns([1,4,6,7,8,5]);
    table.draw(geoTable, {showRowNumber: true, width: '100%',allowHtml: true});
    
}
	  