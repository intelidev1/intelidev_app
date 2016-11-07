google.charts.load('current', {'packages': ['table', 'map']});
      google.charts.setOnLoadCallback(initialize);

      function initialize() {
        // The URL of the spreadsheet to source data from.
        var query = new google.visualization.Query(
            'https://spreadsheets.google.com/pub?key=pCQbetd-CptF0r8qmCOlZGg');
        query.send(draw);
      }

      function draw(response) {
        if (response.isError()) {
          alert('Error in query');
        }

        var ticketsData = response.getDataTable();
        
        var geoData = google.visualization.arrayToDataTable([
          ['Lat', 'Lon', 'Name', 'Status'],
          [-30.043139808803016, -51.202626861376984, 'Poste 1', true],
          [-30.04310780918443, -51.20200369999998, 'Poste 2', true],
          [-30.04311290918446, -51.20162519999997, 'Poste 3', true],
          [-30.043119109184456, -51.20118745000002, 'Poste 4', true],
          [-30.04310050918442, -51.20047420000003, 'Poste 5', true],
          [-30.046226909185563, -51.19772494999995, 'Poste 6', false]]);


        var geoView = new google.visualization.DataView(geoData);
        
        geoView.setColumns([0,1]);

        var table =
            new google.visualization.Table(document.getElementById('table_div'));
        table.draw(geoData, {showRowNumber: false, width: '100%'});

        var map = new google.visualization.Map(document.getElementById('map_div'));

        var options = {
          showTip: true,
          useMapTypeControl: true
        };

        map.draw(geoView, options);

        // Set a 'select' event listener for the table.
        // When the table is selected, we set the selection on the map.
        google.visualization.events.addListener(table, 'select',
            function() {
              map.setSelection(table.getSelection());
            });

        // Set a 'select' event listener for the map.
        // When the map is selected, we set the selection on the table.
        google.visualization.events.addListener(map, 'select',
            function() {
              table.setSelection(map.getSelection());
            });
      }