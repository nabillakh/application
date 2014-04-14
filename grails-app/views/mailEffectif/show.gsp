<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
 <g:render template="/menues/mainleft" />
				
				
				<div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Inbox</h1>	
					
					<div class="fluid-container">

						<div class="alert adjusted alert-info">
							<button class="close" data-dismiss="alert">×</button>
							<i class="cus-exclamation"></i>
							<strong>Info!</strong> Mobile version of this page is currently not supported.
						</div>
						<!-- NO WIDGETS ON THIS PAGE -->
							<div class="row-fluid">
								<article class="span12">
									
									<!-- new widget -->
									<div class="jarviswidget">

									    <!-- wrap div -->
									    
            							
								        <div class="inner-spacer"> 
								        <!-- content goes here -->
											<div class="inbox-body" id="inbox-body-js">
												<div class="inbox-control-panel">
													
												</div>
												<div class="inbox-body-content" id="inbox-loading-panel-js">
													<h2 class="message-title">Objet :  ${mailEffectifInstance.mail?.objet} </h2>
													<h3 class="message-from">From : ${mailEffectifInstance.mail.author.username}    </h3>
													 <h3 class="message-from">A:  ${mailEffectifInstance.mail.recepteur.recepteur.username}</h3>
													
													<div class="message-container"  >
														<div class="message-control-panel">
															<div class="btn-group">
																<a class="btn btn-primary medium" href="javascript:void(0);"><i class="icon-reply"></i> Reply</a>
																<a class="btn btn-primary medium dropdown-toggle" data-toggle="dropdown" href="javascript:void(0);"><span class="caret"></span></a>
																<ul class="dropdown-menu btn-small">
																	<li>
																		<a href="javascript:void(0);"><i class="cus-arrow-undo"></i> Reply All</a>
																	</li>
																	<li>
																		<a href="javascript:void(0);"><i class="cus-envelope"></i> Mark as unread</a>
																	</li>
																	<li>
																		<a href="javascript:void(0);"><i class=" cus-arrow-right"></i> Forward</a>
																	</li>
																	<li class="divider"></li>
																	<li>
																		<a href="javascript:void(0);"><i class="cus-cancel"></i> Cancel</a>
																	</li>
																</ul>
															</div>
                                                                                                                        
														<g:if test="${mailEffectifInstance.archive == false}"><g:link  action="Archiver" controller="mailEffectif" onclick="if(!window.confirm('Voulez-vous Supprimer')) return false;"  id="${mailEffectifInstance.id}" class="btn medium btn-primary pull-right"><i class="icon-trash"></i>  Mettre dans la corbeille </g:link></g:if>	
														<g:if test="${mailEffectifInstance.favoris == false} ${mailEffectifInstance.archive == false}"><g:link  action="Favoriser" controller="mailEffectif"  id="${mailEffectifInstance.id}" class="btn medium btn-primary pull-right"> <i class="icon-trash"></i>  favoris </g:link></g:if>
														<g:if test="${mailEffectifInstance.archive == true}"><g:link  action="delete" controller="mailEffectif" onclick="if(!window.confirm('Voulez-vous Supprimer')) return false;"  id="${mailEffectifInstance.id}" class="btn medium btn-primary pull-right"><i class="icon-trash"></i>  Supprimer </g:link></g:if>
														</div>
                                                                                                                <div class="message-body" style="height: 600px;">
															<p>${mailEffectifInstance.mail?.message}</p>
															
															
															
															
														</div>
													</div>
												</div>
												
											</div>
										                           <div class="inbox-menu">
                                                                          <div class="inbox-control-panel">
                                                                            
                                                                            <a href="#" OnClick="javascript:window.location.reload()" id='refresh-inbox-menu' class="btn medium pull-right"><i class="icon-refresh"></i> Refresh</a>
                                                                          </div>
									<g:set var="listcompteur" value="${1}" />  
                                                                            <messagerie:listMessagerie>
                                                                            </messagerie:listMessagerie>

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
			
				
							
					
				
				
<g:render template="/menues/mainright" />