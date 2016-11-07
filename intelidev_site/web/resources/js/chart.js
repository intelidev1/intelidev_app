    google.charts.load('current', {'packages':['line']});
    google.charts.setOnLoadCallback(drawChart_load);
	var Date_Colum	= "B";
	var VBat_Colum	= "E";
	var IBat_Colum	= "F";
	var VSolar_Colum	= "G";
	var ISolar_Colum	= "H";
	var VLamp_Colum	= "I";
	var ILamp_Colum	= "J";
	
	//var ssKey = "1IjB07yf9t-CUeYyl2mc81ozelBvEjMlfr570BglU57E"
	//var ssKey = getQueryVariable(sskey_1);
	var materialOptions = {
		chart: {
			title: 'Carga e descarga Bateria'
		},
		width: 1024,
		height: 600,
		series: {
			// Gives each series an axis name that matches the Y-axis below.
			0: {axis: 'Tensao'},
			1: {axis: 'Corrente'}
		}
	};
	
	function $_GET(param) {
		var vars = {};
		window.location.href.replace( location.hash, '' ).replace( 
			/[?&]+([^=&]+)=?([^&]*)?/gi, // regexp
			function( m, key, value ) { // callback
				vars[key] = value !== undefined ? value : '';
			}
		);

		if ( param ) {
			return vars[param] ? vars[param] : null;	
		}
		return vars;
	}	
	var ssKey = $_GET('sskey_1');
	function drawChart(Voltage,Corrente,Title) {
	
		var query = new google.visualization.Query('http://spreadsheets.google.com/tq?key='+ssKey+'&pub=1');
		materialOptions.chart.title = Title;
		//query.setQuery("SELECT "+Date_Colum+","+Voltage+","+Corrente+" LIMIT 10 OFFSET 20");
		query.setQuery("SELECT "+Date_Colum+","+Voltage+","+Corrente+" OFFSET 2");
		query.send(handleQueryResponse);
	}

	function drawChart_load() {
	
		var query = new google.visualization.Query('http://spreadsheets.google.com/tq?key='+ssKey+'&pub=1');
		materialOptions.chart.title = "";
		//query.setQuery("SELECT "+Date_Colum+","+Voltage+","+Corrente+" LIMIT 10 OFFSET 20");
		query.setQuery("SELECT "+Date_Colum+","+VBat_Colum+","+IBat_Colum+" OFFSET 2");
		query.send(handleQueryResponse);
	}
		
	
	function handleQueryResponse(response) {
	var data = response.getDataTable();
	var chart = new google.charts.Line(document.getElementById('chart'));
	
	chart.draw(data, materialOptions);
	}

	
	
	