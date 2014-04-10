<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
 <g:render template="/menues/mainleft" />

		
							
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
                                                                                  <g:form url="[action:'save']">
									        <!-- content -->
                                                                                      <g:select name="recepteur" from="${application.RH.Effectif.list()}" multiple="multiple" optionKey="id" style="width: 100%; height: 60px;" value="${effectifInstance?.id}" class="many-to-many"/>
                                                                                      <div class="fieldcontain ${hasErrors(bean: mailInstance, field: 'objet', 'error')} ">
                                                                                        <textarea   name="objet"  value="${mailInstance?.objet}"  placeholder="Objet..." style="width: 100%; height: 20px;"></textarea>
                                                                                      </div>
                                                                                      <div class="fieldcontain ${hasErrors(bean: mailInstance, field: 'message', 'error')} ">
                                                                                        <textarea   name="message" value="${mailInstance?.message}"  placeholder="Enter text ..." style="width: 100%; height: 400px;"></textarea>
                                                                                      </div>	
                                                                                      <div class="pull-right post-msg">
                                                                                        <fieldset class="buttons">
                                                                                          <g:submitButton name="create" controller="Mail" class="btn medium btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                                                                                        </fieldset>
                                                                                        
                                                                                  </g:form>
</div>   		
											<!-- end content -->	
									        </div>
									        <!-- end inner spacer -->
									    </div>
									</div>
									<!-- end widget -->
								</article>
<div class="inbox-menu">
												<div class="inbox-control-panel">
													<a href="${request.contextPath}/javascript:void(0)" id='refresh-inbox-menu' class="btn medium pull-right"><i class="icon-refresh"></i> Refresh</a>
												</div>
												<!-- SLIDING MENU -->
												<div class="slashc-sliding-menu" id="inbox-menu-js">	
													<h1 id="inbox-menu-header-js">
														<span>test</span> 
														<a title="Slide Back Home" href="${request.contextPath}/javascript:void(0);" class="slashc-sliding-menu-home btn btn-inverse">
															<i class="icon-angle-left"></i>
														</a>
													</h1>
													<ul class="mailbox" id="mailbox-js">
														<li><a href="${request.contextPath}/javascript:void(0);"><span>Inbox</span><span class="badge">26</span><i class="icon-angle-right"></i></a>
															<ul>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			From: David Simpson
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">Dear Victoria, Congratulations! Your work has been uploaded to wrapbootstrap.com...</span>
																		</span>
																	</a>
																</li>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			Re:Last Year sales
																			<i class="icon-paper-clip"></i>
																			<span class="tiny-des">Hey Vicky, find attached! Thx :-)</span>
																		</span>
																	</a>
																</li>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			Company Party
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">Hi, You have been cordially invited to join new year after party.</span>
																		</span>
																	</a>
																</li>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			RE: 2 Bugs found...
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">I have found two more bugs in this your beta version, maybe its not working...</span>
																		</span>
																	</a>
																</li>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			2 Bugs found...
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">Donec sodales sagittis magna. Sed consequat, leo eget bibendum sodales.</span>
																		</span>
																	</a>
																</li>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			Incka porfa varos?
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">Forut dashly kuba tuma lope hamur toaila... </span>
																		</span>
																	</a>
																</li>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			This is a test message
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">Laku naka obaba muta...</span>
																		</span>
																	</a>
																</li>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			Welcome to Jarvis!
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">Feugiat a, tellus. Phasellus viverra nulla ut metus varius. Quisque rutrum. Aenean imperdiet... </span>
																		</span>
																	</a>
																</li>
																<li>
																	<div class="push-down"></div>
																</li>
															</ul>
														</li>
														<li>
															<a href="${request.contextPath}/javascript:void(0);"><span>Outbox</span><span class="badge">1</span><i class="icon-angle-right"></i></a>
															<ul>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			Message Title
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">Message line truncated...</span>
																		</span>
																	</a>
																</li>
															</ul>
														</li>
														<li>
															<a href="${request.contextPath}/javascript:void(0);"><span>Sent</span><i class="icon-angle-right"></i></a>
															<ul>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			Message Title
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">Message line truncated...</span>
																		</span>
																	</a>
																</li>
															</ul>
														</li>
														<li>
															<a href="${request.contextPath}/javascript:void(0);"><span>Trash</span><i class="icon-angle-right"></i></a>
															<ul>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			Message Title
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">Message line truncated...</span>
																		</span>
																	</a>
																</li>
															</ul>
														</li>
														<li>
															<a href="${request.contextPath}/javascript:void(0);"><span>Saved Messages</span><i class="icon-angle-right"></i></a>
															<ul>
																<li>
																	<a href="${request.contextPath}/javascript:void(0)">
																		<span class="tiny-sub">
																			Message Title
																			<!--<i class="icon-paper-clip"></i>-->
																			<span class="tiny-des">Message line truncated...</span>
																		</span>
																	</a>
																</li>
															</ul>
														</li>
													</ul>
												</div>
												<!-- end SLIDING MENU -->
											</div>


										</div>
									    <!-- end content-->
									   
									    <!-- end wrap div -->
									</div>
									
									
									<!-- end widget -->
								</article>
							</div>
					</div>		
				</div>
				<!-- end main content -->
			
				<!-- aside right on high res -->
				
				
				<!-- end aside right -->
			</div>
			
	    </div><!--/.fluid-container-->
		<div class="push"></div>
	</div>
	<!-- end .height-wrapper -->	
	
	<!-- footer -->
	
	<!-- if you like you can insert your footer here -->
	
	<!-- end footer -->

    <!--================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="${request.contextPath}/js/libs/jquery.min.js"><\/script>')</script>
    	<!-- OPTIONAL: Use this migrate scrpit for plugins that are not supported by jquery 1.9+ -->
		<!-- DISABLED <script src="${request.contextPath}/js/libs/jquery.migrate-1.0.0.min.js"></script> -->
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script>
    <script>window.jQuery.ui || document.write('<script src="${request.contextPath}/js/libs/jquery.ui.min.js"><\/script>')</script>
    
    <!-- IMPORTANT: Jquery Touch Punch is always placed under Jquery UI -->
    <script src="${request.contextPath}/js/include/jquery.ui.touch-punch.min.js"></script>
    
    <!-- REQUIRED: Mobile responsive menu generator -->
	<script src="${request.contextPath}/js/include/selectnav.min.js"></script>

	<!-- REQUIRED: Datatable components -->
    <script src="${request.contextPath}/js/include/jquery.accordion.min.js"></script>

	<!-- REQUIRED: Toastr & Jgrowl notifications  -->
    <script src="${request.contextPath}/js/include/toastr.min.js"></script>
    <script src="${request.contextPath}/js/include/jquery.jgrowl.min.js"></script>
    
    <!-- REQUIRED: Sleek scroll UI  -->
    <script src="${request.contextPath}/js/include/slimScroll.min.js"></script>
	
	<!-- REQUIRED: Datatable components -->
	<script src="${request.contextPath}/js/include/jquery.dataTables.min.js"></script>
	<script src="${request.contextPath}/js/include/DT_bootstrap.min.js"></script>

    <!-- REQUIRED: Form element skin  -->
    <script src="${request.contextPath}/js/include/jquery.uniform.min.js"></script> 

	<!-- REQUIRED: AmCharts  -->
    <script src="${request.contextPath}/js/include/amchart/amcharts.js"></script>
	<script src="${request.contextPath}/js/include/amchart/amchart-draw1.js"></script>

	<script type="text/javascript">
		var ismobile = (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase()));	
	    if(!ismobile){
	    	
	    	/** ONLY EXECUTE THESE CODES IF MOBILE DETECTION IS FALSE **/
	    	
	    	/* REQUIRED: Datatable PDF/Excel output componant */
	    	
	    	document.write('<script src="${request.contextPath}/js/include/ZeroClipboard.min.js"><\/script>'); 
	    	document.write('<script src="${request.contextPath}/js/include/TableTools.min.js"><\/script>');
	    	document.write('<script src="${request.contextPath}/js/include/jquery.uniform.min.js"><\/script>');
	    	document.write('<script src="${request.contextPath}/js/include/jquery.excanvas.min.js"><\/script>');
	    	document.write('<script src="${request.contextPath}/js/include/jquery.placeholder.min.js"><\/script>');
	    	
	    	/** DEMO SCRIPTS **/
	        $(function() {
	            /* jarvis tooltips */
				$.jGrowl("This <strong>fluid</strong> Inbox page makes it easy to organize and send messages.", { 
					header: 'Fluid Inbox Page.', 
					sticky: false,
					life: 5000,
					speed: 500,
					theme: 'with-icon',
					position: 'top-right', //this is default position
					easing: 'easeOutBack',
					animateOpen: { 
						height: "show"
					},
					animateClose: { 
						opacity: 'hide' 
					}
				});	
	        });
	        /** end DEMO SCRIPTS **/
	       
	    }else{
	    	
	    	/** ONLY EXECUTE THESE CODES IF MOBILE DETECTION IS TRUE **/
	    	
	    	document.write('<script src="${request.contextPath}/js/include/responsive-tables.min.js"><\/script>');
	    }
	</script>

	<!-- REQUIRED: iButton -->
    <script src="${request.contextPath}/js/include/jquery.ibutton.min.js"></script>
	
	<!-- REQUIRED: Justgage animated charts -->
	<script src="${request.contextPath}/js/include/raphael.2.1.0.min.js"></script>
    <script src="${request.contextPath}/js/include/justgage.min.js"></script>
    
    <!-- REQUIRED: Morris Charts -->
    <script src="${request.contextPath}/js/include/morris.min.js"></script> 
    <script src="${request.contextPath}/js/include/morris-chart-settings.js"></script> 
    
    <!-- REQUIRED: Animated pie chart -->
    <script src="${request.contextPath}/js/include/jquery.easy-pie-chart.min.js"></script>
    
    <!-- REQUIRED: Functional Widgets -->
    <script src="${request.contextPath}/js/include/jarvis.widget.min.js"></script>
    <script src="${request.contextPath}/js/include/mobiledevices.min.js"></script>
    <!-- DISABLED (only needed for IE7 <script src="${request.contextPath}/js/include/json2.js"></script> -->
	
	<!-- REQUIRED: Full Calendar -->
    <script src="${request.contextPath}/js/include/jquery.fullcalendar.min.js"></script>		
    
    <!-- REQUIRED: Flot Chart Engine -->
    <script src="${request.contextPath}/js/include/jquery.flot.cust.min.js"></script>			
    <script src="${request.contextPath}/js/include/jquery.flot.resize.min.js"></script>		
    <script src="${request.contextPath}/js/include/jquery.flot.tooltip.min.js"></script>		
    <script src="${request.contextPath}/js/include/jquery.flot.orderBar.min.js"></script> 	
    <script src="${request.contextPath}/js/include/jquery.flot.fillbetween.min.js"></script>	
    <script src="${request.contextPath}/js/include/jquery.flot.pie.min.js"></script> 	 
    
    <!-- REQUIRED: Sparkline Charts -->
    <script src="${request.contextPath}/js/include/jquery.sparkline.min.js"></script>

	<!-- REQUIRED: Infinite Sliding Menu (used with inbox page) -->
	<script src="${request.contextPath}/js/include/jquery.inbox.slashc.sliding-menu.js"></script> 

	<!-- REQUIRED: Form validation plugin -->
    <script src="${request.contextPath}/js/include/jquery.validate.min.js"></script>
    
    <!-- REQUIRED: Progress bar animation -->
    <script src="${request.contextPath}/js/include/bootstrap-progressbar.min.js"></script>
    
    <!-- REQUIRED: wysihtml5 editor -->
    <script src="${request.contextPath}/js/include/wysihtml5-0.3.0.min.js"></script>
    <script src="${request.contextPath}/js/include/bootstrap-wysihtml5.min.js"></script>

	<!-- REQUIRED: Masked Input -->
    <script src="${request.contextPath}/js/include/jquery.maskedinput.min.js"></script>
    
    <!-- REQUIRED: Bootstrap Date Picker -->
    <script src="${request.contextPath}/js/include/bootstrap-datepicker.min.js"></script>

    <!-- REQUIRED: Bootstrap Wizard -->
    <script src="${request.contextPath}/js/include/bootstrap.wizard.min.js"></script> 
    
	<!-- REQUIRED: Bootstrap Color Picker -->
    <script src="${request.contextPath}/js/include/bootstrap-colorpicker.min.js"></script>

    
	<!-- REQUIRED: Bootstrap Time Picker -->
    <script src="${request.contextPath}/js/include/bootstrap-timepicker.min.js"></script> 
    
    <!-- REQUIRED: Bootstrap Prompt -->
    <script src="${request.contextPath}/js/include/bootbox.min.js"></script>
    
    <!-- REQUIRED: Bootstrap engine -->
    <script src="${request.contextPath}/js/include/bootstrap.min.js"></script>
    
    <!-- DO NOT REMOVE: Theme Config file -->
    <script src="${request.contextPath}/js/config.js"></script>
    
    <!-- d3 library placed at the bottom for better performance -->
    <!-- DISABLED  <script src="${request.contextPath}/js/include/d3.v3.min.js"></script> -->
    <!-- DISABLED  <script src="${request.contextPath}/js/include/adv_charts/d3-chart-1.js"></script> -->
    <!-- DISABLED  <script src="${request.contextPath}/js/include/adv_charts/d3-chart-2.js"></script> -->

    <!-- Google Geo Chart -->
    <!-- DISABLED <script src="http://maps.google.com/maps/api/js?sensor=true" type="text/javascript"></script> -->
    <!-- DISABLED <script type='text/javascript' src='https://www.google.com/jsapi'></script>-->
    <!-- DISABLED <script src="${request.contextPath}/js/include/adv_charts/geochart.js"></script> -->
    
    <!-- end scripts -->
  </body>
</html>
