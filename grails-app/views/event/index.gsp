<style>

	body {
		margin-top: 40px;
		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		}
		
	#wrap {
		width: 1100px;
		margin: 0 auto;
		}
		
	#external-events {
		float: left;
		width: 110px;
		padding: 0 10px;
		border: 1px solid #ccc;
		background: #eee;
		text-align: left;
		}
		
	#external-events h4 {
		font-size: 16px;
		margin-top: 0;
		padding-top: 1em;
		}
		
	.external-event { /* try to mimick the look of a real event */
		margin: 10px 0;
		padding: 2px 4px;
		background: #3366CC;
		color: #fff;
		font-size: .85em;
		cursor: pointer;
		}
		
	#external-events p {
		margin: 1.5em 0;
		font-size: 11px;
		color: #666;
		}
		
	#external-events p input {
		margin: 0;
		vertical-align: middle;
		}

	#calendar {
		float: right;
		width: 900px;
		}
</style>
<!DOCTYPE html>


  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
 <g:render template="/menues/mainleft" />	
<div id="page-content">
					<!-- breadcrumb -->
					<!-- DISABLED 
					<ul class="breadcrumb">
						<li>
							<a href="javascript:void(0);"><i class="icon-off"></i> Dashboard</a><span class="divider">/</span>
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
					<h1 id="page-header">Agenda</h1>	

					
					<div class="fluid-container">
						
						<!-- start icons -->
												
						<!-- end start icons -->
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							
							<!-- row-fluid -->
							<div class="row-fluid">
								
							</div>
							
							<!-- end row-fluid -->
							
							<!-- row-fluid -->
							
							<div class="row-fluid">

								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Calendrier</h2>                           
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
												
                                                                                                
                                                                                                 <div id='wrap'>
                                                                                                   
                                                                                                   <div id='external-events'>
                                                                                                     <h4>Liste des projets en cours</h4>
                                                                                                     
                                                                                                     <g:each in="${mesOF}" status="i" var="ofInstance">
                                                                                                        <div class='external-event'> ${ofInstance.kanban.nomKanban} : ${ofInstance.phase.nom}</div>
                                                                                                       </g:each>
                                                                                                       
                                                                                                       <input type='checkbox' id='drop-remove' /> <label for='drop-remove'>a enlever?</label>
                                                                                                     </p>
                                                                                                   </div>
                                                                                                   
                                                                                                   <div id="calendar-container" style="weight: 600px; float :left ; text-align: left;  ">
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
							
							<!-- row-fluid -->
							
							<div class="row-fluid">
								
							</div>
							
							<!-- end row-fluid -->
							
							<!-- row-fluid -->
							
							<div class="row-fluid">
								
										
								
								
							</div>
							
							<!-- end row-fluid -->

						</section>
						<!-- end widget grid -->
					</div>		
				</div>
				<!-- end main content -->
			
				  <g:render template="/menues/mainright" />
