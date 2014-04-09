<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
 <g:render template="/menues/leftmail" />
				
				<!-- main content -->
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
                                                                                                  <g:link  action="create" controller="mail" class="btn medium btn-primary pull-right"><i class="icon-star"></i>  Ecrire nouveau message </g:link>
												</div>
                                                                                          
                                                                                                    <div class="jarviswidget" id="widget-id-4">

                                                                                                      <!-- widget div-->
                                                                                                      <div>

                                                                                                        <div class="inner-spacer"> 
                                                                                                          <!-- content -->
                                                                                                          <g:each in="${mesEffectifsMails}" status="i" var="mailEffectifInstance">
                                                                                                          <div class="accordion" id="accordion1">
                                                                                                            <div class="accordion-group">
                                                                                                              <div class="accordion-heading">
                                                                                                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#collapse${i}">
                                                                                                                  <i class="icon-plus-sign"></i> ${mailEffectifInstance.mail.objet} </a>
                                                                                                              </div>
                                                                                                              <div id="collapse${i}" class="accordion-body collapse" style="height: 0px; ">
                                                                                                                <div class="accordion-inner"> 
                                                                                                               <g:link  controller="MailEffectif"  action="show"  id="${mailEffectifInstance.id}">  ${fieldValue(bean: mailEffectifInstance, field: "mail.message")} </g:link>                                                                                                                
                                                                                                                
                                                                                                                ${mailEffectifInstance.lu}
                                                                                                                ${mailEffectifInstance.archive}
                                                                                                               favoris : ${mailEffectifInstance.favoris}
                                                                                                                </div>
                                                                                                              </div>
                                                                                                            </div>
                                                                                                          </div>
                                                                                                          
                                                                                                    </g:each>
                                                                                                            
                                                                                                            
                                                                                                          <!-- end content -->	
                                                                                                        </div>

                                                                                                      </div>
                                                                                                      <!-- end widget div -->
                                                                                                    </div>

                                                                                                    <!-- ajouter par NL -->
                                                                                                </div>
                                                                        
                                                                        <div class="inbox-menu">
                                                                          <div class="inbox-control-panel">
                                                                            
                                                                            <a href="#" OnClick="javascript:window.location.reload()" id='refresh-inbox-menu' class="btn medium pull-right"><i class="icon-refresh"></i> Refresh</a>
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
														<li><a href="${request.contextPath}/javascript:void(0);"><span>Inbox</span><span class="badge">${mailNonLu.size()}</span><i class="icon-angle-right"></i></a>
															<ul>
                                                                                                                          <g:each in="${mesEffectifsMails}" status="i" var="mailEffectifInstance">
																<li>
																	<g:link  controller="MailEffectif"  action="show"  id="${mailEffectifInstance.id}">  
																		<span class="tiny-sub">
																			From: ${mailEffectifInstance.mail.author.username}
                                                                                                                                                        Objet: ${mailEffectifInstance.mail.objet}
																			
																			<span class="tiny-des">${mailEffectifInstance.mail.message}</span>
																		</span>
																	</g:link>
																</li>
                                                                                                                          </g:each>
																
																<li>
																	<div class="push-down"></div>
																</li>
															</ul>
														</li>
														<li>
															<a href="${request.contextPath}/javascript:void(0);"><span>Envoyés</span><i class="icon-angle-right"></i></a>
															<ul>
															<g:each in="${mesMailsSent}" status="i" var="mailInstance">	
                                                                                                                            <li>
                                                                                                                                 <g:link  controller="Mail"  action="show"  id="${mailInstance.id}">
                                                                                                                              <span class="tiny-sub">
                                                                                                                                From :${mailInstance.recepteur.recepteur.username}                                                                                                                              
                                                                                                                                Objet : ${mailInstance.objet}
                                                                                                                               
                   <!--<i class="icon-paper-clip"></i>-->
                                                                                                                                <span class="tiny-des">${mailInstance.message}</span>
                                                                                                                              </span>
                                                                                                                               </g:link>
                                                                                                                        </li> 
                                                                                                                        </g:each>
															</ul>
														</li>
                                                                                                               
														<li>
															<a href="${request.contextPath}/javascript:void(0);"><span>Corbeille</span><i class="icon-angle-right"></i></a>
															<ul>
																 <g:each in="${mesEffectifMailsArchiver}" status="i" var="mailEffectifArchiverInstance">
																<li>
																	<g:link  controller="MailEffectif"  action="show"  id="${mailEffectifInstance.id}">  
																		<span class="tiny-sub">
																			From: ${mailEffectifArchiverInstance.mail.author.username}
                                                                                                                                                        Objet: ${mailEffectifArchiverInstance.mail.objet}
																			
																			<span class="tiny-des">${mailEffectifArchiverInstance.mail.message}</span>
																		</span>
																	</g:link>
																</li>
                                                                                                                          </g:each>
															</ul>
														</li>
														<li>
															<a href="${request.contextPath}/javascript:void(0);"><span>Fvoris</span><i class="icon-angle-right"></i></a>
															<ul>
																 <g:each in="${mesmailEffectifFavoris}" status="i" var="mesmailEffectifFavorisInstance">
																<li>
																	<g:link  controller="MailEffectif"  action="show"  id="${mesmailEffectifFavorisInstance.id}">  
																		<span class="tiny-sub">
																			From: ${mesmailEffectifFavorisInstance.mail.author.username}
                                                                                                                                                        Objet: ${mesmailEffectifFavorisInstance.mail.objet}
																			
																			<span class="tiny-des">${mesmailEffectifFavorisInstance.mail.message}</span>
																		</span>
																	</g:link>
																</li>
                                                                                                                          </g:each>
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
			
				<g:render template="/menues/mainright" />