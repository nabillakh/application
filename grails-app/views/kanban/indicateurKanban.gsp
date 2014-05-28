
	<!--// OPTIONAL & CONDITIONAL CSS FILES //-->   
	<!-- date picker css -->
	<link rel="stylesheet" href="${request.contextPath}/css/datepicker.css?v=1">
	<!-- full calander css -->
	<link rel="stylesheet" href="${request.contextPath}/css/fullcalendar.css?v=1">
	<!-- data tables extended CSS -->
	<link rel="stylesheet" href="${request.contextPath}/css/TableTools.css?v=1">
	<!-- bootstrap wysimhtml5 editor -->
	<link rel="stylesheet" href="${request.contextPath}/css/bootstrap-wysihtml5.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/wysiwyg-color.css">
	<!-- custom/responsive growl messages -->
	<link rel="stylesheet" href="${request.contextPath}/css/toastr.custom.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/toastr-responsive.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/jquery.jgrowl.css?v=1">
	
	<!-- // DO NOT REMOVE OR CHANGE ORDER OF THE FOLLOWING // -->
	<!-- bootstrap default css (DO NOT REMOVE) -->
	<link rel="stylesheet" href="${request.contextPath}/css/bootstrap.min.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/bootstrap-responsive.min.css?v=1">
	<!-- font awsome and custom icons -->
	<link rel="stylesheet" href="${request.contextPath}/css/font-awesome.min.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/cus-icons.css?v=1">
	<!-- jarvis widget css -->
	<link rel="stylesheet" href="${request.contextPath}/css/jarvis-widgets.css?v=1">
	<!-- main theme files -->
	<link rel="stylesheet" href="${request.contextPath}/css/theme.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/theme-responsive.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/jquery.jgrowl.css?v=1">
    
	<!-- // THEME CSS changed by javascript: the CSS link below will override the rules above // -->
	<!-- For more information, please see the documentation for "THEMES" -->
    <link rel="stylesheet" id="switch-theme-js" href="${request.contextPath}/css/themes/default.css?v=1">   
	
   	<!-- To switch to full width -->
    <link rel="stylesheet" id="switch-width" href="${request.contextPath}/css/full-width.css?v=1">
    
	<!-- Webfonts -->
	<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Lato:300,400,700' type='text/css'>
	
	<!-- All javascripts are located at the bottom except for HTML5 Shim -->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
   		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
   		<script src="${request.contextPath}/js/include/respond.min.js"></script>
   	<![endif]-->

	<!-- For Modern Browsers -->
	<link rel="shortcut icon" href="${request.contextPath}/img/favicons/favicon.png">
	<!-- For everything else -->
	<link rel="shortcut icon" href="${request.contextPath}/img/favicons/favicon.ico">
	<!-- For retina screens -->
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="${request.contextPath}/img/favicons/apple-touch-icon-retina.png">
	<!-- For iPad 1-->
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="${request.contextPath}/img/favicons/apple-touch-icon-ipad.png">
	<!-- For iPhone 3G, iPod Touch and Android -->
	<link rel="apple-touch-icon-precomposed" href="${request.contextPath}/img/favicons/apple-touch-icon.png">
	
	<!-- iOS web-app metas -->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<!-- Add your custom home screen title: -->
	<meta name="apple-mobile-web-app-title" content="Jarvis"> 

	<!-- Startup image for web apps -->
	<link rel="apple-touch-startup-image" href="${request.contextPath}/img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
	<link rel="apple-touch-startup-image" href="${request.contextPath}/img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
	<link rel="apple-touch-startup-image" href="${request.contextPath}/img/splash/iphone.png" media="screen and (max-device-width: 320px)">
	
          

<div class="row-fluid">
								
								<article class="span6">
									<!-- new widget -->
									
                                                                        
                                                                        
                                                                        
                                                                        
                                                    mettre courbe avancement
                                                      <div id="indicateurKanban"></div>
                                                      <g:hiddenField name="kanban" id="monKanban" value="${kanbanInstance.nomKanban}"/>
                                                      <g:hiddenField name="chargePlanifiee" id="chargePlanifiee" value="${kanbanInstance.chargePlanifiee}"/>
                                                      
                                                                        
                                                                        
									<!-- end widget -->
								</article>
							
								<article class="span6">
									
									<!-- new widget -->
                                                                        avancement par phase
									    <div>
									    
									       
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
												<div class="progress-stats">
			                                        <div class="widget-content-padding">
                                                                  <g:each in="${kanbanInstance.of}" status="k" var="ofInstance">
			                                            <div class="semi-block">
			                                                <strong>${ofInstance.phase.nom}</strong><strong class="pull-right">${ofInstance.chargeAgenda / ofInstance.chargePlanifiee * 100} %</strong>
			                                                <div class="progress progress-info value"><div class="bar" data-percentage="40" data-amount-part="${ofInstance.chargeAgenda}" data-amount-total="${ofInstance.chargePlanifiee}">456 / 631</div></div>
			                                            </div>
                                                                  </g:each>
			                                        </div>
			                                    </div>
									        <!-- end content -->
									        </div>
									        
									        
									    </div>
									<!-- end widget -->
								</article>
  
  <article>
  <div class="inner-spacer"> 
    ok
    <div id="avancementKanban" class="chart" style="height:350px; margin:0;"></div>
    
    <div id="chargeCapa" class="chart" style="height:350px; margin:0;"></div>
									        			
  
							</div>
  </article>
  
  
  
								
							</div>
                
                
                
    <script src="${request.contextPath}/js/include/amchart/amcharts.js"></script>
	<script src="${request.contextPath}/js/include/amchart/amchart-draw1.js"></script>
    <script src="${request.contextPath}/js/include/morris.min.js"></script> 
    <script src="${request.contextPath}/js/include/morris-chart-settings.js"></script> 
    
	<!-- REQUIRED: Justgage animated charts -->
	<script src="${request.contextPath}/js/include/raphael.2.1.0.min.js"></script>
    <script src="${request.contextPath}/js/include/justgage.min.js"></script>
    
    
    
    <!-- creer par NL pour gerer tous les graphiques -->
    <script src="${request.contextPath}/js/include/indicateur.js"></script>
    
    
