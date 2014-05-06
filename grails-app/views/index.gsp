
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
                <g:javascript library="jquery" plugin="jquery" />
  </head>

  
                                          <sec:ifLoggedIn>
 <g:render template="/menues/mainleft" />
   				
     <!-- main content -->
				<div id="page-content">
					<!-- breadcrumb -->
					
					<!-- end breadcrumb -->
					
					<!-- page header
                                        
                                        <sec:ifLoggedIn>
					<div class="alert adjusted alert-info">
						<button class="close" data-dismiss="alert">×</button>
						<i class="cus-exclamation"></i>
						<strong>Welcome to  <sec:username/></strong> 
					</div>
					</sec:ifLoggedIn> -->
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
									
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-0">
									    <header>
									        <h2>ok</h2>                           
									    </header>
									    
									    <!-- widget div-->
									    <div>
									    	<!-- widget edit box -->
									        
									        <!-- content -->	            
									        <div class="inner-spacer chat-widget widget-content-padding"> 
									        	
									        	<!-- chat tabs -->
												<ul id="myChat" class="nav nav-tabs chat-tabs">
									              <li class="active">
									              	<a href="#newsfeed" data-toggle="tab"><i class="online"></i>Principal</a>
									              	</li>
									              <li>
									              	<a href="#activite" data-toggle="tab"><i class="away"></i>Activités</a>
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
									              
                                                                                      <div class="row-fluid chat-box">
                                                                                        
                                                                                        
                                                                                        
                                                                                    <input class="span12 type-effect"  type="text" id="messageBox"  placeholder="Tapez votre message..." name="message" onkeypress="messageKeyPress(this,event);"/> 
                                                                                    
                                                                                    <g:hiddenField name="kanban" id="monKanban"/>
                                                                                    <div id="temp"></div>
                                                                                        
                                                                                      </div>
                                                                                      <!-- chat user1 -->	
                                                                                      <div class="tab-pane fade in active" id="newsfeed">
                                                                                        
									              	<!-- chat messages -->
									              	<div class="newsfeed1"></div>
									              	<!-- end chat messages -->
									              	
									              </div>
                                                                                      <script type="text/javascript">
                                                                                        <g:remoteFunction controller="message" action="obtenirMessage" update="newsfeed1"/>;
                                                                                      </script>
									              <!-- end chat user1 -->
									              
									              <!-- chat user2 -->
									              <div class="tab-pane fade" id="activite">
									              	
									              	<!-- chat messages -->
									              	<div class="chat-messages">														
														
									              	</div>
									              	<!-- end chat messages -->
									              	
									              </div>
                                                                                      
									              <!-- end chat user2 -->
									              
									            </div>
									            <!-- end chat box -->
									            
									            
										       		
											
									        </div>
									        <!-- end content -->	
									        
									    </div>
									    <!-- end widget div -->
									</div>
                                                                        
									<!-- end widget -->
									
								</article>
								
							</div>
                                                        
                                                        <script>
                                                          function messageKeyPress(field,event) {
                                                            var theCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
                                                            var message = $('#messageBox').val();
                                                            if (theCode == 13){
                                                        <g:remoteFunction controller = "message" action="posterMessage" params="\'message=\'+message" update="temp"/>
                                                                    $('#messageBox').val('');
                                                                    return false;
                                                                  } else {
                                                                    return true;
                                                                  }
                                                                  }
                                                                  function obtenirMessage() {
                                                                  // var kanban = $('#monKanban').val()
                                                                          <g:remoteFunction controller="message" action="obtenirMessage" update="newsfeed"/>
                                                                        }
                                                                function pollMessages() {
                                                                  obtenirMessage();
                                                                  setTimeout('pollMessages()', 25000);
                                                                }
                                                                pollMessages();
                                                                                                                               
                                                        </script>
						</section>
					</div>		
				</div>

<g:render template="/menues/mainright" />



 
</sec:ifLoggedIn>
  
  
  
  
  <sec:ifNotLoggedIn>
    <h2> <g:link  action="index" controller="login"> <font size="3" face="georgia" color="red"> Se connecter </font></g:link> <h2>
  </sec:ifNotLoggedIn>