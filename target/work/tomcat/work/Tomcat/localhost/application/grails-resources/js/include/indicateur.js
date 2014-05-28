
        // chargement data pour PIC
        var json_data = (function() {
               var json;
               $.ajax({
                   type:'GET',
                   url: '/application/activite/chargePIC',
                   async: false,
                   global: false,
                   success: function(data) {
                       bootbox.alert("ok");
                       json = data;
                   }, 
                       error:function(){
                       bootbox.alert("Error loading chart");
                   }
               });
               return json;
           });
           
        var absPIC = (function() {
               var json;
               $.ajax({
                   type:'GET',
                   url: '/application/activite/listeFamille',
                   async: false,
                   global: false,
                   success: function(data) {
                       bootbox.alert("ok");
                       json = data;
                   }, 
                           error:function(){
                       bootbox.alert("Error loading chart");
                   }
               });
               return json;
           });
        
        
        // charge issue du pic
        
       if ($('#chargePIC').length){
           $.getJSON( "/application/activite/chargePIC", function( data ) {
               $.getJSON( "/application/activite/listeFamille", function( fam ) {
               Morris.Bar({
		  element: 'chargePIC',
		  axes: false,
		  grid: false,
		  data: data,
		  xkey: 'annee',
		  ykeys: fam,
		  labels: fam,
		  stacked: true
		});
	});
	});
        
       }
       
       if ($('#indicateurKanban').length){
           var nomKanban = $('#monKanban').val();
               Morris.Bar({
		  element: 'indicateurKanban',
		  axes: true,
		  grid: true,
		  data: [
		    {x: '2011 Q1', y: $('#chargePlanifiee').val(), z: 2, a: 3},
		    {x: '2011 Q2', y: $('#chargePlanifiee').val(), z: null, a: 1},
		    {x: '2011 Q3', y: 0, z: 2, a: $('#chargePlanifiee').val()},
		    {x: '2011 Q4', y: 2, z: 4, a: 3}
		  ],
		  xkey: 'x',
		  ykeys: ['y', 'z', 'a'],
		  labels: [nomKanban, 'Z', 'A'],
		  stacked: true
		});
            }
            
       
       
        var json_data2 = (function() {
               var json;
               $.ajax({
                   type:'GET',
                   url: '/application/activite/barPIC',
                   async: false,
                   global: false,
                   success: function(data) {
                       json = data;
                   }, 
                           error:function(){
                       alert("Error loading chart");
                   }
               });
               return json;
           })
        
        
        
	// bar graph color
	if ($('#1barPIC').length){ 
		    
                
                
		Morris.Bar({
		  element: '1barPIC',
		  data: json_data2,
		  xkey: 'annee',
		  ykeys: ['charge'],
		  labels: ['Charge'],
		  barColors: function (row, series, type) {
		    if (type === 'bar') {
		      var red = Math.ceil(255 * row.y / this.ymax);
		      return 'rgb(' + red + ',0,0)';
		    }
		    else {
		      return '#000';
		    }
		  }
		});
	
	}
        
        
	

if ($('#chargeCapa').length) {
	var chartData = [{
		date : new Date(2012, 0, 1),
		developpement : 108,
                commercial : 54,
                management : 54,
                veille : 27,
		capacite : 270
	}, {
		date : new Date(2012, 0, 2),
		developpement : 110,
                commercial : 60,
                management : 51,
                veille : 27,
		capacite : 255
	}, {
		date : new Date(2012, 0, 3),
		developpement : 150,
                commercial : 83,
                management : 63,
                veille : 45,
		capacite : 315
	}, {
		date : new Date(2012, 0, 4),
		developpement : 105,
                commercial : 45,
                management : 50,
                veille : 27,
		capacite : 255
	}, {
		date : new Date(2012, 0, 5),
		developpement : 146,
                commercial : 51,
                management : 50,
                veille : 47,
		capacite : 315
	}, {
		date : new Date(2012, 0, 6),
		developpement : 150,
                commercial : 63,
                management : 70,
                veille : 57,
		capacite : 300
	}, {
		date : new Date(2012, 0, 7),
		developpement : 61,
                commercial : 44,
                management : 45,
                veille : 43,
		capacite : 180
	}, {
		date : new Date(2012, 0, 8),
		developpement : 59,
                commercial : 39,
                management : 22,
                veille : 18,
		capacite : 150
	}, {
		date : new Date(2012, 0, 9),
		developpement : 112,
                commercial : 45,
                management : 50,
                veille : 27,
		capacite : 285
	}, {
		date : new Date(2012, 0, 10),
		developpement : 149,
                commercial : 49,
                management : 58,
                veille : 23,
		capacite : 300
	}, {
		date : new Date(2012, 0, 11),
		developpement : 175,
                commercial : 69,
                management : 39,
                veille : 27,
		capacite : 270
	}, {
		date : new Date(2012, 0, 12),
		developpement : 125,
                commercial : 43,
                management : 38,
                veille : 27,
		capacite : 225
	}];

	var chart;

	AmCharts.ready(function() {
		// SERIAL CHART
		chart = new AmCharts.AmSerialChart();
		chart.pathToImages = "img/amchart/";
		chart.dataProvider = chartData;
		chart.categoryField = "date";
		chart.marginTop = 0;
		chart.autoMarginOffset = 5;

		// AXES
		// category axis
		var categoryAxis = chart.categoryAxis;
		categoryAxis.parseDates = true;
		// as our data is date-based, we set parseDates to true
		categoryAxis.minPeriod = "DD";
		// our data is daily, so we set minPeriod to DD
		categoryAxis.autoGridCount = false;
		categoryAxis.min = 0;
		categoryAxis.max = 300;
		categoryAxis.gridAlpha = 0;
		categoryAxis.gridColor = "#000000";
		categoryAxis.axisColor = "#000";
		// we want custom date formatting, so we change it in next line
		categoryAxis.dateFormats = [{
			period : 'DD',
			format : 'DD'
		}, {
			period : 'WW',
			format : 'MMM DD'
		}, {
			period : 'MM',
			format : 'MMM'
		}, {
			period : 'YYYY',
			format : 'YYYY'
		}];

		

		// charge value axis
		var salesAxis = new AmCharts.ValueAxis();
		salesAxis.title = "Charge planifiée (jour)";
		salesAxis.gridAlpha = 0;
		salesAxis.inside = true;
		salesAxis.mininimum = 0;
		salesAxis.maximum = 400;
		salesAxis.unit = " j";
                salesAxis.stackType ="regular";
		salesAxis.axisAlpha = 0;
		chart.addValueAxis(salesAxis);

		// GRAPHS
		// duration graph
		var durationGraph = new AmCharts.AmGraph();
		durationGraph.title = "Capacité planifiée";
		durationGraph.valueField = "capacite";
		durationGraph.type = "line";
		durationGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		durationGraph.lineColor = "#CC0000";
		durationGraph.balloonText = "[[title]] : [[value]] j";
		durationGraph.lineThickness = 1;
		durationGraph.legendValueText = "[[value]] j";
		durationGraph.bullet = "square";
		chart.addGraph(durationGraph);

		// developpement graph
		var salesGraph = new AmCharts.AmGraph();
		salesGraph.valueField = "developpement";
		salesGraph.title = "developpement";
		salesGraph.type = "column";
		salesGraph.fillAlphas = 0.3;
		salesGraph.fillColors = ["#0000FF", "#0000FF"];
		salesGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		salesGraph.balloonText = "[[title]] : [[value]] j";
		salesGraph.legendValueText = "[[value]] j";
		salesGraph.lineColor = "#0000FF";
		salesGraph.lineAlpha = .7;
		chart.addGraph(salesGraph);
                
                
		// management graph
		var salesGraph = new AmCharts.AmGraph();
		salesGraph.valueField = "management";
		salesGraph.title = "management";
		salesGraph.type = "column";
		salesGraph.fillAlphas = 0.3;
		salesGraph.fillColors = ["#F08080", "#F08080"];
		salesGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		salesGraph.balloonText = "[[title]] : [[value]] j";
		salesGraph.legendValueText = "[[value]] j";
		salesGraph.lineColor = "#F08080";
		salesGraph.lineAlpha = .7;
		chart.addGraph(salesGraph);
                
                // veille graph
		var salesGraph = new AmCharts.AmGraph();
		salesGraph.valueField = "veille";
		salesGraph.title = "veille";
		salesGraph.type = "column";
		salesGraph.fillAlphas = 0.3;
		salesGraph.fillColors = ["#32CD32", "#32CD32"];
		salesGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		salesGraph.balloonText = "[[title]] : [[value]] j";
		salesGraph.legendValueText = "[[value]] j";
		salesGraph.lineColor = "#32CD32";
		salesGraph.lineAlpha = .7;
		chart.addGraph(salesGraph);
                

                // commercial graph
		var salesGraph = new AmCharts.AmGraph();
		salesGraph.valueField = "commercial";
		salesGraph.title = "commercial";
		salesGraph.type = "column";
		salesGraph.fillAlphas = 0.3;
		salesGraph.fillColors = ["#FF00FF", "#FF00FF"];
		salesGraph.valueAxis = salesAxis;
		// indicate which axis should be used
		salesGraph.balloonText = "[[title]] : [[value]] j";
		salesGraph.legendValueText = "[[value]] j";
		salesGraph.lineColor = "#FF00FF";
		salesGraph.lineAlpha = .7;
		chart.addGraph(salesGraph);
                

		// CURSOR
		var chartCursor = new AmCharts.ChartCursor();
		chartCursor.zoomable = false;
		chartCursor.categoryBalloonDateFormat = "DD";
		chartCursor.cursorAlpha = 0;
		chart.addChartCursor(chartCursor);

		// LEGEND
		var legend = new AmCharts.AmLegend();
		legend.bulletType = "round";
		legend.equalWidths = true;
		legend.valueWidth = 30;
		legend.color = "#000000";
		chart.addLegend(legend);

		// BAR
		/* var chartScrollbar = new AmCharts.ChartScrollbar();
		chartScrollbar.scrollbarHeight = 25;
		chartScrollbar.graph = salesGraph; // as we want graph to be displayed in the scrollbar, we set graph here
		chartScrollbar.graphType = "line"; // we don't want candlesticks to be displayed in the scrollbar
		chartScrollbar.gridCount = 5;
		chartScrollbar.color = "#FFFFFF";
		chart.addChartScrollbar(chartScrollbar);*/

		// WRITE
		chart.write("chargeCapa");
	});
}

if ($('#avancementKanban').length) {
	var chartData2 = [{
            "date": "2012-07-27",
            "value": 13
        }, {
            "date": "2012-07-28",
            "value": 11
        }, {
            "date": "2012-07-29",
            "value": 15
        }, {
            "date": "2012-07-30",
            "value": 16
        }, {
            "date": "2012-07-31",
            "value": 18
        }, {
            "date": "2012-08-01",
            "value": 13
        }, {
            "date": "2012-08-02",
            "value": 22
        }, {
            "date": "2012-08-03",
            "value": 23
        }, {
            "date": "2012-08-04",
            "value": 20
        }, {
            "date": "2012-08-05",
            "value": 17
        }, {
            "date": "2012-08-06",
            "value": 16
        }, {
            "date": "2012-08-07",
            "value": 18
        }, {
            "date": "2012-08-08",
            "value": 21
        }, {
            "date": "2012-09-22",
            "value": 57
        }, {
            "date": "2012-09-23",
            "value": 61
        }, {
            "date": "2012-09-24",
            "value": 59
        }, {
            "date": "2012-09-25",
            "value": 67
        }, {
            "date": "2012-09-26",
            "value": 65
        }, {
            "date": "2012-09-27",
            "value": 61
        }, {
            "date": "2012-09-28",
            "value": 66
        }, {
            "date": "2012-09-29",
            "value": 69
        }, {
            "date": "2012-09-30",
            "value": 71
        }, {
            "date": "2012-10-01",
            "value": 67
        }, {
            "date": "2012-10-02",
            "value": 63
        }, {
            "date": "2012-10-03",
            "value": 46
        }, {
            "date": "2012-10-04",
            "value": 32
        }, {
            "date": "2012-10-08",
            "value": 28
        }, {
            "date": "2012-10-09",
            "value": 27
        }, {
            "date": "2012-10-10",
            "value": 36
        }, {
            "date": "2012-10-11",
            "value": 33
        }, {
            "date": "2012-10-12",
            "value": 31
        }, {
            "date": "2012-10-13",
            "value": 30
        }, {
            "date": "2012-10-14",
            "value": 34
        }, {
            "date": "2012-10-15",
            "value": 38
        }, {
            "date": "2012-10-16",
            "value": 37
        }, {
            "date": "2012-10-17",
            "value": 44
        }, {
            "date": "2012-10-18",
            "value": 49
        }, {
            "date": "2012-10-19",
            "value": 53
        }, {
            "date": "2012-10-20",
            "value": 57
        }, {
            "date": "2012-10-21",
            "value": 60
        }, {
            "date": "2012-10-22",
            "value": 61
        }, {
            "date": "2012-10-23",
            "value": 69
        }, {
            "date": "2012-10-24",
            "value": 67
        }, {
            "date": "2012-10-25",
            "value": 72
        }, {
            "date": "2012-10-26",
            "value": 77
        }, {
            "date": "2012-10-27",
            "value": 75
        }, {
            "date": "2012-10-28",
            "value": 70
        }, {
            "date": "2012-10-29",
            "value": 72
        }, {
            "date": "2012-10-30",
            "value": 70
        }];

	var chart2;

	AmCharts.ready(function() {
		// SERIAL CHART
		chart2 = new AmCharts.AmSerialChart();

		chart2.pathToImages = "img/amchart/";
		chart2.type = "serial";
		chart2.dataProvider = chartData2;
		chart2.categoryField = "date";
		chart2.dataDateFormat = "YYYY-MM-DD";
		// AXES
		// category axis
		var categoryAxis = chart2.categoryAxis;
		categoryAxis.parseDates = true;
                categoryAxis.dashLenght = 1;
		categoryAxis.minorGridEnabled = true;
                categoryAxis.position = top;
		

		// charge value axis
		var salesAxis = new AmCharts.ValueAxis();
		salesAxis.title = "Charge planifiée (jour)";
		salesAxis.gridAlpha = 0;
		salesAxis.inside = true;
		salesAxis.mininimum = 0;
		salesAxis.maximum = 400;
		salesAxis.unit = " j";
                salesAxis.stackType ="regular";
		salesAxis.axisAlpha = 0;
		chart2.addValueAxis(salesAxis);

		// GRAPHS
		// duration graph
                // developpement graph
		var monGraphe = new AmCharts.AmGraph();
		monGraphe.id = "g1";
		monGraphe.title = "developpement";
                
		monGraphe.valueField = "value";
                monGraphe.bulletBorderAlpha = 1;
                monGraphe.bulletColor = "#FFFFFF";
                monGraphe.bulletSize = 5;
                monGraphe.hideBulletsCount = 50;
                monGraphe.lineThickness = 2;
                monGraphe.useLineColorForBulletBorder = true;
                
		chart2.addGraph(monGraphe);
	

		// CURSOR
		var chartCursor = new AmCharts.ChartCursor();
		chartCursor.zoomable = false;
		chartCursor.categoryBalloonDateFormat = "DD";
		chartCursor.cursorAlpha = 0;
                
		chart2.addChartCursor(chartCursor);

		// LEGEND
		var legend = new AmCharts.AmLegend();
		legend.bulletType = "round";
		legend.equalWidths = true;
		legend.valueWidth = 30;
		legend.color = "#000000";
		chart2.addLegend(legend);

		// BAR
		/* var chartScrollbar = new AmCharts.ChartScrollbar();
		chartScrollbar.scrollbarHeight = 25;
		chartScrollbar.graph = salesGraph; // as we want graph to be displayed in the scrollbar, we set graph here
		chartScrollbar.graphType = "line"; // we don't want candlesticks to be displayed in the scrollbar
		chartScrollbar.gridCount = 5;
		chartScrollbar.color = "#FFFFFF";
		chart.addChartScrollbar(chartScrollbar);*/

		// WRITE
		chart2.write("avancementKanban");
	});
}





            
       if ($('#indicateurSocial').length){
               Morris.Bar({
		  element: 'indicateurSocial',
		  axes: true,
		  grid: true,
		  data: [
		    {x: 'Nombre de messages', y: $('#messagesKanban').val(), z: $('#messagesAutre').val()},
		    {x: 'Moyenne', y: $('#messagesKanbanMoyen').val(), z: $('#messagesAutreMoyen').val()}
		  ],
		  xkey: 'x',
		  ykeys: ['y', 'z'],
		  labels: ['Sur Projets', 'Autres'],
		  stacked: true
		});
            }
            