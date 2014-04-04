<!DOCTYPE html>

<html lang="en">
	<head>
          <meta charset="utf-8">
          <meta http-equiv="X-UA-Compatible" content="IE=edge" />
          <title><g:layoutTitle default="SysProd"/></title>
          <meta name="description" content="">
          <meta name="author" content="">
    
	<!-- http://davidbcalhoun.com/2010/viewport-metatag -->
	<meta name="HandheldFriendly" content="True">
	<meta name="MobileOptimized" content="320">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

	<!--// OPTIONAL & CONDITIONAL CSS FILES //-->   
	<!-- date picker css -->
	<link rel="stylesheet" href="css/datepicker.css?v=1">
	<!-- full calander css -->
	<link rel="stylesheet" href="css/fullcalendar.css?v=1">
	<!-- data tables extended CSS -->
	<link rel="stylesheet" href="css/TableTools.css?v=1">
	<!-- bootstrap wysimhtml5 editor -->
	<link rel="stylesheet" href="css/bootstrap-wysihtml5.css?v=1">
	<link rel="stylesheet" href="css/wysiwyg-color.css">
	<!-- custom/responsive growl messages -->
	<link rel="stylesheet" href="css/toastr.custom.css?v=1">
	<link rel="stylesheet" href="css/toastr-responsive.css?v=1">
	<link rel="stylesheet" href="css/jquery.jgrowl.css?v=1">
	
	<!-- // DO NOT REMOVE OR CHANGE ORDER OF THE FOLLOWING // -->
	<!-- bootstrap default css (DO NOT REMOVE) -->
	<link rel="stylesheet" href="css/bootstrap.min.css?v=1">
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css?v=1">
	<!-- font awsome and custom icons -->
	<link rel="stylesheet" href="css/font-awesome.min.css?v=1">
	<link rel="stylesheet" href="css/cus-icons.css?v=1">
	<!-- jarvis widget css -->
	<link rel="stylesheet" href="css/jarvis-widgets.css?v=1">
	<!-- main theme files -->
	<link rel="stylesheet" href="css/theme.css?v=1">
	<link rel="stylesheet" href="css/theme-responsive.css?v=1">
	<link rel="stylesheet" href="css/jquery.jgrowl.css?v=1">
    
	<!-- // THEME CSS changed by javascript: the CSS link below will override the rules above // -->
	<!-- For more information, please see the documentation for "THEMES" -->
    <link rel="stylesheet" id="switch-theme-js" href="css/themes/default.css?v=1">   
	
   	<!-- To switch to full width -->
    <link rel="stylesheet" id="switch-width" href="css/full-width.css?v=1">
    
	<!-- Webfonts -->
	<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Lato:300,400,700' type='text/css'>
	
	<!-- All javascripts are located at the bottom except for HTML5 Shim -->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
   		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
   		<script src="js/include/respond.min.js"></script>
   	<![endif]-->

	<!-- For Modern Browsers -->
	<link rel="shortcut icon" href="img/favicons/favicon.png">
	<!-- For everything else -->
	<link rel="shortcut icon" href="img/favicons/favicon.ico">
	<!-- For retina screens -->
	<link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/favicons/apple-touch-icon-retina.png">
	<!-- For iPad 1-->
	<link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/favicons/apple-touch-icon-ipad.png">
	<!-- For iPhone 3G, iPod Touch and Android -->
	<link rel="apple-touch-icon-precomposed" href="img/favicons/apple-touch-icon.png">
	
	<!-- iOS web-app metas -->
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="apple-mobile-web-app-status-bar-style" content="black">
	<!-- Add your custom home screen title: -->
	<meta name="apple-mobile-web-app-title" content="Jarvis"> 

	<!-- Startup image for web apps -->
	<link rel="apple-touch-startup-image" href="img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)">
	<link rel="apple-touch-startup-image" href="img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)">
	<link rel="apple-touch-startup-image" href="img/splash/iphone.png" media="screen and (max-device-width: 320px)">
	
          
        <g:layoutHead/>
        <g:javascript/>
        <r:layoutResources />
                    
        
        
            <!--[if lt IE 9]
   		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"</script>
   		<script src="${request.contextPath}/js/include/respond.min.js"</script>
   	<![endif]-->
        </head>
        
        
        
	<body>
		
        <g:layoutBody/>
		
        <r:layoutResources />
        
        
          	<!-- .height-wrapper -->
	<div class="height-wrapper">
		
		<!-- header -->
		<header>
			<!-- tool bar -->
			<div id="header-toolbar" class="container-fluid">
				<!-- .contained -->
				<div class="contained">
					
					<!-- theme name -->
					<h1> SysProd <span class="hidden-phone">- Mon tableau de bord</span> </h1>
					<!-- end theme name -->
																		
					<!-- span4 -->
					<div class="pull-right">
						<!-- demo theme switcher-->
						<div id="theme-switcher" class="btn-toolbar">
							
							<!-- search and log off button for phone devices -->
							<div class="btn-group pull-right visible-phone">
								<a href="javascript:void(0)" class="btn btn-inverse btn-small"><i class="icon-search"></i></a>
								<a href="login.html" class="btn btn-inverse btn-small"><i class="icon-off"></i></a>
							</div>
							<!-- end buttons for phone device -->
							
							<!-- dropdown mini-inbox-->
                                                        
                                                        <div class="btn-group">
                                                          
                                                          <!-- new mail ticker -->
                                                                <g:remoteLink name="miniBox" on404="alert('not found!')" update="mesMails"
                                                                              url="[controller: 'Mail', action:'maListe']">
                                                                  <a href="javascript:void(0)" class="btn btn-small btn-inverse dropdown-toggle" data-toggle="dropdown">
                                                                    <span class="mail-sticker">3</span>
                                                                    <i class="cus-email"></i>
                                                                  </a>
                                                                </g:remoteLink>
                                                          <!-- email lists -->
                                                          
                                                          <div class="dropdown-menu toolbar pull-right">
                                                              <h3>Messagerie</h3>
                                                              <!-- "mailbox-slimscroll-js" identifier is used with Slimscroll.js plugin -->
                                                                
                                                                <messagerie:miniMessagerie mesMail="${mesMails}"/>
                                                               
                                                              <a href="javascript:void(0);" id="go-to-inbox">Go to Inbox <i class="icon-double-angle-right"></i></a>
                                                              
                                                            </div>
                                                            
                                                          
                                                          <!-- end new mail ticker -->
                                                          
                                                          
                                                        </div>                                                        
                                                        
							<!-- end dropdown mini-inbox-->
							
							<!-- Tasks -->
							<div class="btn-group hidden-phone">
								<a href="javascript:void(0)" class="btn btn-inverse btn-small">My Tasks</a>
								<a href="javascript:void(0)" class="btn btn-inverse dropdown-toggle btn-small" data-toggle="dropdown"><span class="caret"></span></a>
					
								<div class="dropdown-menu toolbar pull-right">
									<h3>Showing All Tasks</h3>
									<ul class="progressbox">
						                <li>
						                    <strong><i class="online pull-left"></i>Urgent Bug Fixes</strong><b>Complete</b>
						                    <div class="progress progress-success slim"><div class="bar" style="width: 100%;"></div></div>
						                </li>
						                <li>
						                    <strong>Added functionality</strong><b>70%</b>
						                    <div class="progress progress-info slim"><div class="bar" style="width: 70%;"></div></div>
						                </li>
						                <li>
						                    <strong>CAD Changes</strong><b>50%</b>
						                    <div class="progress progress-info slim"><div class="bar" style="width: 50%;"></div></div>
						                </li>
						                <li>
						                    <strong>Marketing Campaign Mocup</strong><b>22%</b>
						                    <div class="progress progress-danger slim"><div class="bar" style="width: 22%;"></div></div>
						                </li>
						                <li>
						                    <strong><i class="offline pull-left"></i>Proposal</strong><b>Pending</b>
						                    <div class="progress progress-info slim"><div class="bar" style="width: 0%;"></div></div>
						                </li>
						            </ul>
								</div>

							</div>
							<!-- end Tasks -->
							
							<!-- theme dropdown -->
							<div class="btn-group hidden-phone">
								<a href="javascript:void(0)" class="btn btn-small btn-inverse" id="reset-widget"><i class="icon-refresh"></i></a>
								<a href="javascript:void(0)" class="btn btn-small btn-inverse dropdown-toggle" data-toggle="dropdown">Themes <span class="caret"></span></a>
								<ul id="theme-links-js" class="dropdown-menu toolbar pull-right">
									<li>
										<a href="javascript:void(0)" data-rel="purple"><i class="icon-sign-blank purple-icon"></i>Royal Purple</a>
									</li>
									<li>
										<a href="javascript:void(0)" data-rel="blue"><i class="icon-sign-blank navyblue-icon"></i>Navy Blue</a>
									</li>
									<li>
										<a href="javascript:void(0)" data-rel="green"><i class="icon-sign-blank green-icon "></i>Emerald</a>
									</li>
									<li>
										<a href="javascript:void(0)" data-rel="darkred"><i class="icon-sign-blank red-icon "></i>Dark Rose</a>
									</li>
									<li>
										<a href="javascript:void(0)" data-rel="default"><i class="icon-sign-blank grey-icon"></i>Default</a>
									</li>
								</ul>
							</div>
							<!-- end theme dropdown-->
							
						</div>
					  	<!-- end demo theme switcher-->
					</div>
					<!-- end span4 -->
				</div>
				<!-- end .contained -->
			</div>
			<!-- end tool bar -->
			
		</header>
		<!-- end header -->
		
	    <div id="main" role="main" class="container-fluid">
	    	
			<div class="contained">
				<!-- aside -->	
				<aside>	
					
					<!-- search box -->
					<div class="main-search">
						<label for="main-search"><i class="icon-search"></i></label>
	                    <input id="main-search" type="text" placeholder="Recherche">
                	</div>
					<div class="divider"></div>
					<!-- end search box -->
										
					<!-- aside item: Mini profile -->
					<div class="my-profile">
						<a href="javascript:void(0)" class="my-profile-pic">
							<img src="${request.contextPath}/img/avatar/avatar_0.jpg" alt="" />
						</a>
                                          Bienvenue
                                          <sec:ifLoggedIn><sec:username/></sec:ifLoggedIn>
					<span><a href="javascript:void(0);">Modifier profil </a></span>
					</div>
					<div class="divider"></div>
					<!-- end aside item: Mini profile -->

					<!-- aside item: Menu -->
					<div class="sidebar-nav-fixed">
						
						<ul class="menu" id="accordion-menu-js">
							<li class="current">
								<a href="javascript:void(0)"><i class="icon-off"></i>Tableau de bord <span class="badge">2</span></a>
								<ul>
									<li>
										<g:link  action="index" controller="Login">Tableau de bord</g:link>
									</li>
									<li>
                                                                                <sec:ifLoggedIn>
										 <g:link  action="index" controller="Logout">  Se déconnecter </g:link>
                                                                                 </sec:ifLoggedIn>
                                                                        <sec:ifNotLoggedIn>
										 <g:link  action="index" controller="Login">  Se connecter </g:link>
                                                                                 </sec:ifNotLoggedIn>
                                                                        
									</li>
								</ul>
							</li>
                                                        
							<li class="">
								<a href="mail"><i class="icon-envelope"></i>Boite de réception</a>
							</li>
							<li class="">
								<a href="javascript:void(0)"><i class="icon-check"></i>Suvi d'activités<span class="badge">3</span></a>
								<ul>
                                                                        <li>
                                                                                <g:link  action="portefeuille" controller="activite"> Portefeuille d'activité </g:link>
									</li>	
                                                                    <li>
                                                                                <g:link  action="activite" controller="activite">  Mon activité </g:link>
									</li>
									<li>
										<a href="validation.html">eeeeee</a>
									</li>
									<li>
										<a href="wizard.html">Mes indicateurs</a>
									</li>
								</ul>
							</li>
                                                        <li class="">
								<a href="mail"><i class="icon-envelope"></i>Mon agenda</a>
							</li>

							<li class="">
								<a href="javascript:void(0)"><i class="icon-signal"></i>Charts &amp; Graphs<span class="badge">3</span></a>
								<ul>
									<li>
										<a href="basic">Basic Charts</a>
									</li>
									<li>
										<a href="adv_charts.html">Advanced Charts</a>
									</li>
									<li>
										<a href="raphael.html">Raphael Engine</a>
									</li>
								</ul>
							</li>
							<li class="">
								<a href="widgets.html"><i class="icon-refresh"></i>Smart Widgets</a>
							</li>
							<li class="">
								<a href="javascript:void(0)"><i class="icon-plus"></i>Administration</a>
								<ul>
									<li>
										<a href="administration/ressource">Gestion des ressources</a>
									</li>
									<li>
										<a href="administration/activite">Gestion d'activite</a>
									</li>
								</ul>
							</li>
						</ul>
						
					</div>
					<div class="divider"></div>
					<!-- end aside item: Menu -->
					
					<!-- aside item: Inbox -->
					<!-- inbox message 1-->
					<div class="mini-inbox">
						<div class="alert inbox">
							<button type="button" class="close" data-dismiss="alert">
								×
							</button>
							
							<a href="javascript:void(0)">
								<img src="${request.contextPath}/img/email-important.png" width="22" height="18" alt="important mail" />
								From:David S...
							</a>
							Dear Victoria, Congratulations! You work has been uploade...
						</div>
						<!-- inbox message 2-->
						<div class="alert inbox">
							<button type="button" class="close" data-dismiss="alert">
								×
							</button>
							<a href="javascript:void(0)">
								<img src="${request.contextPath}/img/email-unread.png" width="22" height="18" alt="important mail" />
								Re:Last Year...
							</a>
							Hey Vicky, find attached! Thx :-)
						</div>
						<!-- inbox message 3-->
						<div class="alert inbox last-child">
							<button type="button" class="close" data-dismiss="alert">
								×
							</button>
							<a href="javascript:void(0)">
								<img src="${request.contextPath}/img/email-unread.png" width="22" height="18" alt="important mail" />
								Company Party
							</a>
							Hi, You have been cordially invited to join new year...
						</div>
						
					</div>
					<div class="divider"></div>
					<!-- end aside item: Inbox -->
					
					<!-- aside item: Tiny Stats -->
					<div class="number-stats">
				    	<ul>
				        	<li>4579<span>visitors</span></li>
				            <li>571<span>orders</span></li>
				            <li>879<span>reviews</span></li>
				        </ul>
				    </div>
				    <div class="divider"></div>
					<!-- end aside item: Tiny Stats -->
					
		            <!-- end aside buttons -->
				</aside>
				<!-- aside end -->
				
				<!-- main content -->
				<div id="page-content">
					<!-- breadcrumb -->
					<!-- DISABLED 
					<ul class="breadcrumb">
						<li>
							<a href="javascript:void(0);"><i class="icon-off"></i> Tableau de bord</a><span class="divider">/</span>
						</li>
						<li>
							<a href="javascript:void(0);">Library</a><span class="divider">/</span>
						</li>
						<li class="active">
							Current Page
						</li>
					</ul>
					-->
					<!-- end breadcrumb -->
					
					<!-- page header -->
					<h1 id="page-header">Tableau de bord</h1>	
                                        <sec:ifLoggedIn>
					<div class="alert adjusted alert-info">
						<button class="close" data-dismiss="alert">×</button>
						<i class="cus-exclamation"></i>
						<strong>Welcome to  <sec:username/></strong> 
					</div>
					</sec:ifLoggedIn>
					<div class="fluid-container">
						
						<!-- start icons -->
						<div id="start">
							<ul>
								<li>
									<label>246 </label>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/orders.png" alt="">
										<span>Projets en cours</span>
									</a>
								</li>
								<li>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/mass.png" alt="">
										<span>Broadcast</span>
									</a>
								</li>
								<li>
									<label>new</label>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/stats.png" alt="">
										<span>Show Statistics</span>
									</a>
								</li>
								<li>
									<label>657</label>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
										<span>Comments</span>
									</a>
								</li>
								<li>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/upgrade.png" alt="">
										<span>Service Upgrade</span>
									</a>
								</li>
							</ul>

						</div>						
						<!-- end start icons -->
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							
							<!-- row-fluid -->
							<div class="row-fluid">
								<article class="span12">
									
									<div class="jarviswidget transparent" id="widget-id-0">
									    <header>
									        <h2>No Title</h2>                           
									    </header>
									    
									    <!-- widget div-->
									    <div>
									    	<!-- widget edit box -->
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
									        <!-- end widget edit box -->
            
									        <div class="inner-spacer"> 
									        	<!-- content goes here -->
									        	
									        	<div id="chartdiv" class="chart" style="height:350px; margin:0;"></div>
									        													
									        	<!-- end calendar container -->
									        </div>
									        
									    </div>
									    <!-- end widget div -->
									</div>

								</article>
							</div>
							
							<!-- end row-fluid -->
							
							<!-- row-fluid -->
							
							<div class="row-fluid">

								<article class="span6">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Calendar</h2>                           
									    </header>
									    
									    <!-- widget div-->
									    <div>
									    	<!-- widget edit box -->
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
									        <!-- end widget edit box -->
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
												<div class="widget alert alert-info adjusted">
													<button class="close" data-dismiss="alert">×</button>
													<i class="cus-exclamation"></i>
													<strong>Helpful Hint:</strong> Did you know you can click on the <strong>Calendar Cell</strong> to add a new event? Try to add an event and see how easy it is!
												</div>
												<!-- calnedar container -->
									        	<div id="calendar-container">
										        	<div id="calendar-buttons">
														<div class="btn-group">
															<a href="javascript:void(0)" class="btn btn-small" id="btn-today">Today</a>
															<a href="javascript:void(0)" class="btn dropdown-toggle btn-small" data-toggle="dropdown"><span class="caret"></span></a>
															<ul class="dropdown-menu btn-small pull-right">
																<li>
																	<a href="javascript:void(0);" id="btn-month">Month</a>
																</li>
																<li>
																	<a href="javascript:void(0);" id="btn-agenda">Agenda</a>
																</li>
																<li>
																	<a href="javascript:void(0);" id="btn-day">Today</a>
																</li>
															</ul>
														</div>
														<div class="btn-group">
															<a href="javascript:void(0)" class="btn btn-small" id="btn-prev"><i class="icon-chevron-left"></i></a>
															<a href="javascript:void(0)" class="btn btn-small" id="btn-next"><i class="icon-chevron-right"></i></a>
														</div>
													</div>
										        	<div class="dt-header calender-spacer"></div>
										        	<div id="calendar"></div>
									        	</div>
									        	<!-- end calendar container -->
									        </div>
									        
									    </div>
									    <!-- end widget div -->
									</div>
									<!-- end widget -->
								</article>
										
								<article class="span6">
									
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-2">
									    <header>
									        <h2>Chat Interface</h2>                           
									    </header>
									    
									    <!-- widget div-->
									    <div>
									    	<!-- widget edit box -->
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
									        <!-- end widget edit box -->

									        <!-- content -->	            
									        <div class="inner-spacer chat-widget widget-content-padding"> 
									        	
									        	<!-- chat tabs -->
												<ul id="myChat" class="nav nav-tabs chat-tabs">
									              <li class="active">
									              	<button class="btn btn-mini pull-right chat-close-btn"><i class="icon-remove"></i></button>
									              	<a href="#user1" data-toggle="tab"><i class="online"></i>Nicolas Cage</a>
									              	</li>
									              <li>
									              	<button class="btn btn-mini pull-right chat-close-btn"><i class="icon-remove"></i></button>
									              	<a href="#user2" data-toggle="tab"><i class="away"></i>David Simpson</a>
									              </li>
									              <li class="pull-right">
									              	
													<div id="chat-user-control" class="btn-group hidden-phone">
		                                                <button class="btn dropdown-toggle btn-small btn-link" data-toggle="dropdown"><i class="cus-status-online"></i></button>
		                                                <ul class="dropdown-menu btn-small pull-right">
															<li>
																<a href="javascript:void(0);"><i class="cus-status-online"></i> Available</a>
															</li>
															<li>
																<a href="javascript:void(0);"><i class="cus-cross-shield-2"></i> Busy</a>
															</li>
															<li>
																<a href="javascript:void(0);"><i class="cus-clock"></i> Away</a>
															</li>
															<li class="divider"></li>
															<li>
																<a href="javascript:void(0);"><i class="cus-disconnect"></i> Disconnect</a>
															</li>
		                                                </ul>
		                                            </div>

							
									              </li>
									            </ul>
									            <!-- end chat tabs -->
									            
									            <!-- chat box -->
									            <div id="myChatTab" class="tab-content chat-content">
									              
									              <!-- chat user1 -->	
									              <div class="tab-pane fade in active" id="user1">
									              	
									              	<!-- chat messages -->
									              	<div class="chat-messages">
									              		
									              		<!-- message-id-1 -->
														<p id="message-id-1" class="message-box">
															<img src="${request.contextPath}/img/avatar/avatar_1.jpg" alt="">
															<span class="message">
																<strong>Nicolas Cage</strong> 
																<span class="message-time">14:23pm, 4th Jan 2013</span>
																<span class="message-text">Hehehe....sem quam semper libero, sit amet adipiscing sem neque sed ipsum. <i class="cus-emoticon-tongue"></i></span>
															</span>
														</p>
														<!-- end message-id-1 -->
														
														<!-- message-id-2 -->
														<p id="message-id-2" class="message-box you">
															<img src="${request.contextPath}/img/avatar/avatar_0.jpg" alt="">
															<span class="message">
																<strong>Me</strong> 
																<span class="message-time">14:25pm, 4th Jan 2013</span>
																<span class="message-text"> Faucibus! Nullam quis ante. Etiam sit amet orci eget eros faucibus tincidunt. Duis leo. Sed fringilla mauris sit amet nibh. Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales, augue velit cursus nunc <i class="cus-emoticon-smile"></i></span>
															</span>
														</p>
									              		<!-- end message-id-2 -->
									              		
									              		<!-- message-id-3 -->
														<p id="message-id-3" class="message-box">
															<img src="${request.contextPath}/img/avatar/avatar_1.jpg" alt="">
															<span class="message">
																<strong>Nicolas Cage</strong> 
																<span class="message-time">14:23pm, 4th Jan 2013</span>
																<span class="message-text">Hey Vicky! Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. LOLOL!  Maecenas tempus, tellus eget condimentum rhoncus. </span>
															</span>
														</p>
														<!-- end message-id-3 -->
									              	
									             	</div>
									              	<!-- end chat messages -->
									              	
									              </div>
									              <!-- end chat user1 -->
									              
									              <!-- chat user2 -->
									              <div class="tab-pane fade" id="user2">
									              	
									              	<!-- chat messages -->
									              	<div class="chat-messages">
									              		
									              		<!-- message-id-1 -->
														<p id="message-id-4" class="message-box">
															<img src="${request.contextPath}/img/avatar/avatar_2.jpg" alt="">
															<span class="message">
																<strong>David Simpson</strong> 
																<span class="message-time">14:23pm, 4th Jan 2013</span>
																<span class="message-text">Hi Victoria, Yes you have uploaded it and its currently in que. I will have a look at it and send you an email shortly.</span>
															</span>
														</p>
														<!-- end message-id-1 -->
														
														<!-- message-id-2 -->
														<p id="message-id-5" class="message-box you">
															<img src="${request.contextPath}/img/avatar/avatar_0.jpg" alt="">
															<span class="message">
																<strong>Me</strong> 
																<span class="message-time">14:25pm, 4th Jan 2013</span>
																<span class="message-text">Hi David, I just submitted a theme on wrapbootstrap, not sure if it went through. Did I do it right? :S</span>
															</span>
														</p>
														<!-- end message-id-2 -->
														
									              	</div>
									              	<!-- end chat messages -->
									              	
									              </div>
									              <!-- end chat user2 -->
									              
									            </div>
									            <!-- end chat box -->
									            
									            <div class="row-fluid chat-box">
									            	
									            	<textarea name="enter-message" rows="3" cols="1" placeholder="Enter your message..." id="chat-box-textarea"></textarea>
													<div class="row-fluid">
		                                                <div class="span6 type-effect" style="display:none"><img src="${request.contextPath}/img/loaders/misc/16-2.gif" alt=""> Victoria is typing...</div>
		                                                <div class="span6 chat-box-buttons pull-right">
		                                                	<input type="submit" name="chat-box-textarea" class="btn medium btn-danger pull-right" value="Send" id="send-msg-js">
		                                                    <a href="javascript:void(0);" title="" class="pull-right"><i class="icon-camera"></i></a>
		                                                </div>
		                                            </div>

									            </div>
										       		
											
									        </div>
									        <!-- end content -->	
									        
									    </div>
									    <!-- end widget div -->
									</div>
									<!-- end widget -->
									
								</article>
								
							</div>
							
							<!-- end row-fluid -->
							
							<!-- row-fluid -->
							
							<div class="row-fluid">
								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-3">
									    <header>
									        <h2>Sales Chart</h2>                           
									    </header>
									    <div>
									    
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
            
									        <div class="inner-spacer"> 
									        <!-- content -->	
												<div class="widget alert alert-success adjusted">
													<button class="btn btn-mini pull-right btn-success">New Campaign</button>
													<i class="cus-accept"></i>
													<strong>Congratulations!</strong> Your last campaign was a success. Your goal was reached on <strong>28-12-12 @ 4:23 AM</strong>. Would you like to set up a new campaign?
												</div>
												<!-- sales chart -->
								        		<div id="saleschart" class="chart"></div>
										       		
											<!-- end content -->	
									        </div>
									        
									    </div>
									</div>
									<!-- end widget -->
								</article>
							</div>
							
							<!-- end row-fluid -->
							
							<!-- row-fluid -->
							
							<div class="row-fluid">
								
								<article class="span6">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-4">
									    <header>
									        <h2>Bootstrap WYSIHTML5 Editor</h2>                           
									    </header>
									    <div>
									    
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
            
									        <div class="inner-spacer wysihtml5-widget"> 
									        <!-- content -->	
												<textarea id="wysihtml5" placeholder="Enter text ..." style="width: 100%; height: 200px;"></textarea>
												
											    <div class="pull-right post-msg">
											    	<a href="javascript:void(0)" class="btn medium" id="save-notes-btn-js" >Save to notes</a>
											    	<a href="javascript:void(0)" class="btn medium btn-primary" id="post-btn-js">Post Message</a>
											    </div>   		
											<!-- end content -->	
									        </div>
									        <!-- end inner spacer -->
									    </div>
									</div>
									<!-- end widget -->
								</article>
							
								<article class="span6">
									
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-5">
									    <header>
									        <h2>Tasks in progress</h2>                           
									    </header>
									    <div>
									    
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
												<div class="progress-stats">
			                                        <div class="widget-content-padding">
			                                            <strong>Hot Fixes</strong><strong class="pull-right">51%</strong>
			                                            <div class="progress progress-danger value"><div class="bar" data-percentage="30" data-amount-part="784" data-amount-total="1544">784 / 1544</div></div>
			                                            
			                                            <div class="semi-block">
			                                                <strong>Urgent Tasks</strong><strong class="pull-right">87%</strong>
			                                                <div class="progress progress-info value"><div class="bar" data-percentage="40" data-amount-part="456" data-amount-total="631">456 / 631</div></div>
			                                            </div>
			                                            
			                                            <div class="semi-block">
			                                                <strong>Other tasks</strong><strong class="pull-right">41%</strong>
			                                                <div class="progress progress-success value"><div class="bar" data-percentage="79" data-amount-part="51" data-amount-total="141">51 / 141</div></div>
			                                            </div>
			                                            
			                                            <div class="semi-block">
			                                                <strong>Pending tasks</strong><strong class="pull-right">33%</strong>
			                                                <div class="progress progress-warning value"><div class="bar" data-percentage="33" data-amount-part="33" data-amount-total="100">33 / 100</div></div>
			                                            </div>
			                                        </div>
			                                    </div>
									        <!-- end content -->
									        </div>
									        
									        
									    </div>
									</div>
									<!-- end widget -->
								</article>
								
							</div>
							
							<!-- end row-fluid -->

						</section>
						<!-- end widget grid -->
					</div>		
				</div>
				<!-- end main content -->
			
				<!-- aside right on high res -->
				<aside class="right">
					
					<!-- sparkline stats -->
					<ul class="mystats indented">
		                <li class="first">
		                    <h1><span>My Balance:</span>$17,349</h1>
		                    <div class="mychart" id="balance" style="width:35px"></div>
		                </li>
		                <li>
		                    <h1><span>Impressions:</span>145k+</h1>
		                    <div class="mychart" id="clicks" style="width:35px"></div>
		                </li>
		                <li>
		                    <h1><span>Subscribers:</span>1,120</h1>
		                    <div class="mychart" id="subscribe" style="width:35px"></div>
		                </li>
		                <li class="last">
		                    <h1><span>Support Ticket:</span>945+</h1>
		                    <div class="mychart" id="support" style="width:35px"></div>
		                </li>
		            </ul>
		            <div class="divider"></div>
		            <!-- end sparkline stats -->

					<!-- aside progress bars -->
					<ul class="indented aside-progress-stats">
						<li>
							<!-- easy pie chart -->
							<div class="easypie">
								<div class="percentage" data-percent="68">
									<span>68</span>%
								</div>
								<div class="easypie-text">
									Server load
								</div>
							</div>
							<!-- end easy pie chart -->
						</li>
		                <li>
		                    <strong>Data Restored</strong><strong class="pull-right">90%</strong>
		                    <div class="progress progress-danger slim"><div class="bar" data-percentage="90"></div></div>
		                </li>
		                <li>
		                    <strong>Recovering IDE</strong><strong class="pull-right">66%</strong>
		                    <div class="progress progress-info slim"><div class="bar" data-percentage="66"></div></div>
		                </li>
		                <li>
		                    <strong>DLL Construction</strong><strong class="pull-right">48%</strong>
		                    <div class="progress progress-info slim"><div class="bar" data-percentage="48"></div></div>
		                </li>
		                <li>
		                    <strong>Machine Req</strong><strong class="pull-right">33%</strong>
		                    <div class="progress progress-info slim"><div class="bar" data-percentage="33"></div></div>
		                </li>
		            </ul>
		            <div class="divider"></div>
		            <!-- end aside progress bars -->
					
					<!-- date picker -->
					<div id="datepicker"></div>
					<div class="divider"></div>
					<!-- end date picker -->

				
				<!-- end aside right -->
			</div>
			
	    </div><!--end fluid-container-->
		<div class="push"></div>
	</div>
	<!-- end .height wrapper -->
        
        
                
                
                  <!--================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/libs/jquery.min.js"><\/script>')</script>
    	<!-- OPTIONAL: Use this migrate scrpit for plugins that are not supported by jquery 1.9+ -->
		<!-- DISABLED <script src="js/libs/jquery.migrate-1.0.0.min.js"></script> -->
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
    <script>window.jQuery.ui || document.write('<script src="js/libs/jquery.ui.min.js"><\/script>')</script>
    
    <!-- IMPORTANT: Jquery Touch Punch is always placed under Jquery UI -->
    <script src="js/include/jquery.ui.touch-punch.min.js"></script>
    
    <!-- REQUIRED: Mobile responsive menu generator -->
	<script src="js/include/selectnav.min.js"></script>

	<!-- REQUIRED: Datatable components -->
    <script src="js/include/jquery.accordion.min.js"></script>

	<!-- REQUIRED: Toastr & Jgrowl notifications  -->
    <script src="js/include/toastr.min.js"></script>
    <script src="js/include/jquery.jgrowl.min.js"></script>
    
    <!-- REQUIRED: Sleek scroll UI  -->
    <script src="js/include/slimScroll.min.js"></script>
	
	<!-- REQUIRED: Datatable components -->
	<script src="js/include/jquery.dataTables.min.js"></script>
	<script src="js/include/DT_bootstrap.min.js"></script> 

    <!-- REQUIRED: Form element skin  -->
    <script src="js/include/jquery.uniform.min.js"></script> 

	<!-- REQUIRED: AmCharts  -->
    <script src="js/include/amchart/amcharts.js"></script>
	<script src="js/include/amchart/amchart-draw1.js"></script>

	<script type="text/javascript">
		var ismobile = (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase()));	
	    if(!ismobile){
	    	
	    	/** ONLY EXECUTE THESE CODES IF MOBILE DETECTION IS FALSE **/
	    	
	    	/* REQUIRED: Datatable PDF/Excel output componant */
	    	
	    	document.write('<script src="js/include/ZeroClipboard.min.js"><\/script>'); 
	    	document.write('<script src="js/include/TableTools.min.js"><\/script>');
	    	document.write('<script src="js/include/select2.min.js"><\/script>'); 
	    	document.write('<script src="js/include/jquery.excanvas.min.js"><\/script>');
	    	document.write('<script src="js/include/jquery.placeholder.min.js"><\/script>');
	    	
			
	       
	    }else{
	    	
	    	/** ONLY EXECUTE THESE CODES IF MOBILE DETECTION IS TRUE **/

	    	document.write('<script src="js/include/responsive-tables.min.js"><\/script>');
	    }
	</script>
	
	<!-- REQUIRED: iButton -->
    <script src="js/include/jquery.ibutton.min.js"></script>
	
	<!-- REQUIRED: Justgage animated charts -->
	<script src="js/include/raphael.2.1.0.min.js"></script>
    <script src="js/include/justgage.min.js"></script>
    
    <!-- REQUIRED: Morris Charts -->
    <script src="js/include/morris.min.js"></script> 
    <script src="js/include/morris-chart-settings.js"></script> 
    
    <!-- REQUIRED: Animated pie chart -->
    <script src="js/include/jquery.easy-pie-chart.min.js"></script>
    
    <!-- REQUIRED: Functional Widgets -->
    <script src="js/include/jarvis.widget.min.js"></script>
    <script src="js/include/mobiledevices.min.js"></script>
    <!-- DISABLED (only needed for IE7 <script src="js/include/json2.js"></script> -->
	
	<!-- REQUIRED: Full Calendar -->
    <script src="js/include/jquery.fullcalendar.min.js"></script>		
    
    <!-- REQUIRED: Flot Chart Engine -->
    <script src="js/include/jquery.flot.cust.min.js"></script>			
    <script src="js/include/jquery.flot.resize.min.js"></script>		
    <script src="js/include/jquery.flot.tooltip.min.js"></script>		
    <script src="js/include/jquery.flot.orderBar.min.js"></script> 	
    <script src="js/include/jquery.flot.fillbetween.min.js"></script>	
    <script src="js/include/jquery.flot.pie.min.js"></script> 	 
    
    <!-- REQUIRED: Sparkline Charts -->
    <script src="js/include/jquery.sparkline.min.js"></script>

	<!-- REQUIRED: Infinite Sliding Menu (used with inbox page) -->
	<script src="js/include/jquery.inbox.slashc.sliding-menu.js"></script> 

	<!-- REQUIRED: Form validation plugin -->
    <script src="js/include/jquery.validate.min.js"></script>
    
    <!-- REQUIRED: Progress bar animation -->
    <script src="js/include/bootstrap-progressbar.min.js"></script>
    
    <!-- REQUIRED: wysihtml5 editor -->
    <script src="js/include/wysihtml5-0.3.0.min.js"></script>
    <script src="js/include/bootstrap-wysihtml5.min.js"></script>

	<!-- REQUIRED: Masked Input -->
    <script src="js/include/jquery.maskedinput.min.js"></script>
    
    <!-- REQUIRED: Bootstrap Date Picker -->
    <script src="js/include/bootstrap-datepicker.min.js"></script>

    <!-- REQUIRED: Bootstrap Wizard -->
    <script src="js/include/bootstrap.wizard.min.js"></script> 
    
	<!-- REQUIRED: Bootstrap Color Picker -->
    <script src="js/include/bootstrap-colorpicker.min.js"></script>

    
	<!-- REQUIRED: Bootstrap Time Picker -->
    <script src="js/include/bootstrap-timepicker.min.js"></script> 
    
    <!-- REQUIRED: Bootstrap Prompt -->
    <script src="js/include/bootbox.min.js"></script>
    
    <!-- REQUIRED: Bootstrap engine -->
    <script src="js/include/bootstrap.min.js"></script>
    
    <!-- DO NOT REMOVE: Theme Config file -->
    <script src="js/config.js"></script>
    
    <!-- d3 library placed at the bottom for better performance -->
    <!-- DISABLED  <script src="js/include/d3.v3.min.js"></script> -->
    <!-- DISABLED  <script src="js/include/adv_charts/d3-chart-1.js"></script> -->
    <!-- DISABLED  <script src="js/include/adv_charts/d3-chart-2.js"></script> -->

    <!-- Google Geo Chart -->
    <!-- DISABLED <script src="http://maps.google.com/maps/api/js?sensor=true" type="text/javascript"></script> -->
    <!-- DISABLED <script type='text/javascript' src='https://www.google.com/jsapi'></script>-->
    <!-- DISABLED <script src="js/include/adv_charts/geochart.js"></script> -->
    
    <!-- end scripts -->
	</body>
</html>
