<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>Data Chart</title>
    <script type="text/javascript" src="http://www.google.com/jsapi"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript"> 
    google.charts.load('current', {'packages':['line']});
//    google.charts.setOnLoadCallback(drawChart);
	var Date_Colum	= "B";
	var VBat_Colum	= "E";
	var IBat_Colum	= "F";
	var VSolar_Colum	= "G";
	var ISolar_Colum	= "H";
	var VLamp_Colum	= "I";
	var ILamp_Colum	= "J";
	
	var ssKey = "1IjB07yf9t-CUeYyl2mc81ozelBvEjMlfr570BglU57E"
	var materialOptions = {
		chart: {
			title: 'Carga e descarga Bateria'
		},
		width: 900,
		height: 500,
		series: {
			// Gives each series an axis name that matches the Y-axis below.
			0: {axis: 'Tensao'},
			1: {axis: 'Corrente'}
		}
	};
	
	function drawChart(Voltage,Corrente,Title) {
	
		var query = new google.visualization.Query('http://spreadsheets.google.com/tq?key='+ssKey+'&pub=1');
		materialOptions.chart.title = Title;
		//query.setQuery("SELECT "+Date_Colum+","+Voltage+","+Corrente+" LIMIT 10 OFFSET 20");
		query.setQuery("SELECT "+Date_Colum+","+Voltage+","+Corrente+" OFFSET 2");
		query.send(handleQueryResponse);
	}

		
	
	function handleQueryResponse(response) {
	var data = response.getDataTable();
	var chart = new google.charts.Line(document.getElementById('chart'));
	
	chart.draw(data, materialOptions);
	}

  </script>
</head>
<body>
  <button onclick="drawChart(VBat_Colum,IBat_Colum, 'Carga e descarga bateria')">Status Bateria</button>
  <button onclick="drawChart(VSolar_Colum,ISolar_Colum,'Tensão e corrente painel solar')">Status Painel Solar</button>
  <button onclick="drawChart(VLamp_Colum,ILamp_Colum,'Tensão e corretente lâmpada')">Status Lâmpada</button>
  <div id="chart"></div>
</body>
</html>

