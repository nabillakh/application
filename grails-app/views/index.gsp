
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
                                          <sec:ifLoggedIn>
 <g:render template="/menues/mainleft" />
   				
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

								<article class="span12">
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
										
								
								
							</div>
							
							<!-- end row-fluid -->
							

						</section>
						<!-- end widget grid -->
					</div>		
				</div>

<g:render template="/menues/mainright" />



 
</sec:ifLoggedIn>
  
  
  
  
  <sec:ifNotLoggedIn>
    <h2> <g:link  action="index" controller="login"> <font size="3" face="georgia" color="red"> Se connecter </font></g:link> <h2>
  </sec:ifNotLoggedIn>