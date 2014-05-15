<!DOCTYPE html>
<%@ page import="application.MailService" %>
<%
    def myService = grailsApplication.classLoader.loadClass('application.MailService').newInstance()
%>
  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
                 <g:javascript library="jquery" plugin="jquery" />
  </head>

 <sec:ifLoggedIn>
 <g:render template="/menues/mainleft" />		
<div id="page-content">
    <div class="fluid-container">
<table >
    <tr> <td><img src="${request.contextPath}/img/start-icons/coucou.jpg" alt="" style="width: 100px; height: 100px;"> <h4>${effectifInstance?.prenom} ${effectifInstance?.nom}</h4> 
    <h4> Equipe: ${effectifInstance?.equipe.nom}</h4></td>
   
    
						<!-- start icons -->
        <td style="text-align: right">
            <div id="start">
							<ul>
								<li>
									
									<g:link  action="activite" controller="activite">
										<img src="${request.contextPath}/img/start-icons/orders.png" alt="">
										<span>Projets en cours</span>
									</g:link>
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

						</div></td></tr></table>
					<!-- page header -->
                                                                                <div class="jarviswidget" id="widget-id-0" style="margin-top: 50px;">
									    <header>
									        <h2>Publication</h2>                           
									    </header>

									    <!-- widget div-->
									   

									    <!-- widget div-->
									    <div>
									    	<!-- widget edit box -->

									        <!-- content -->	            
									        <div class="inner-spacer chat-widget widget-content-padding"> 

									        	<!-- chat tabs -->
												<ul id="myChat" class="nav nav-tabs chat-tabs">
									              <li class="active">
									              	<a href="#newsfeed" data-toggle="tab">Journal</a>
									              	</li>
									              <li>
									              	<a href="#activite" data-toggle="tab">Projets</a>
									              </li>
									              <li class="pull-right">

													


									              </li>
									            </ul>
									            <!-- end chat tabs -->

									            <!-- chat box -->
									            <div id="myChatTab" class="tab-content chat-content">

                                                                                      <div class="row-fluid chat-box">
                                                                                        
                                                                                      <div class="controls">
																	<div class="input-append span10">  
                                                                                    <input class="span12 type-effect"  type="text" id="messageBox"  placeholder="Tapez votre message..." name="message" onkeypress="messageKeyPress(this,event);"/> 
                                                                                    <div class="btn-group">
						                                                    <button class="btn dropdown-toggle medium" data-toggle="dropdown">Action <span class="caret"></span></button>
						                                                    <ul class="dropdown-menu btn-small pull-right">
						                                                        <li><a href="javascript:void(0);">Favorite it</a></li>
						                                                        <li><a href="javascript:void(0);">Reload page</a></li>
						                                                        <li><a href="javascript:void(0);">Attach something</a></li>
						                                                    </ul>
						                                                </div>
						                                            </div>
                                            					</div>  
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
									              	ccccc													

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
                                                                function maj() {
                                                                  obtenirMessage();
                                                                  setTimeout('pollMessages()', 25000);
                                                                }
                                                                maj();
                                                                                                                               
                                                        </script>
						</section>
					</div>		
				

<g:render template="/menues/mainright" />



 
</sec:ifLoggedIn>
  
  
  
  
  <sec:ifNotLoggedIn>
    <h2> <g:link  action="index" controller="login"> <font size="3" face="georgia" color="red"> Se connecter </font></g:link> <h2>
  </sec:ifNotLoggedIn>