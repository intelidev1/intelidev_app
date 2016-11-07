google.charts.load('current', {'packages': ['table', 'map']});
google.charts.setOnLoadCallback(initialize);
var ssKey = "1a4INQGgP4AaDCTmoGK0pPr_dE-Bgv0Mi8gJK-WaiY2k"
function initialize() {
	var query = new google.visualization.Query('http://spreadsheets.google.com/tq?key='+ssKey+'&pub=1');
	query.setQuery("SELECT A , B,C,D,E,G ");
	query.send(draw);
}


function draw(response) {
	if (response.isError()) {
		alert('Error in query');
	}
	var geoData = response.getDataTable();
    var geoView = new google.visualization.DataView(geoData);
	var geoTable =  new google.visualization.DataView(geoData);
    
    geoView.setColumns([2,3,5]);

    var table = new google.visualization.Table(document.getElementById('table_div'));
	geoTable.setColumns([0,1,2,3,4]);
    table.draw(geoTable, {showRowNumber: false, width: '100%'});
    
	var map = new google.visualization.Map(document.getElementById('map_div'));
    var options = {
      showTip: true,
      useMapTypeControl: true
      
    };
    map.draw(geoView, options);
    // Set a 'select' event listener for the table.
    // When the table is selected, we set the selection on the map.
    google.visualization.events.addListener(table, 'select',function() {map.setSelection(table.getSelection());});
    // Set a 'select' event listener for the map.
    // When the map is selected, we set the selection on the table.
    google.visualization.events.addListener(map, 'select',function() {table.setSelection(map.getSelection());});
		
//	var content = "Loan Number: "; 
//	var infowindow = new google.maps.InfoWindow();
//	google.visualization.events.addListener(geoView,'select', (function(geoView,content,infowindow){ 
//        return function() {
//           infowindow.setContent(content);
//           infowindow.open(map,geoView);
//        };
//    }));
		
}
	  