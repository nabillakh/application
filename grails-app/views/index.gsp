
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
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

<g:render template="/menues/mainright" />



 
