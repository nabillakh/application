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
													<a href="javascript:void(0)" id='compose-mail' class="btn medium btn-primary pull-right"><i class="icon-star"></i> Compose Message</a>
												</div>
												<div class="inbox-body-content" id="inbox-loading-panel-js">
													<h1 class="message-title">Objet :  ${mailEffectifInstance.mail?.objet} </h1>
													<h3 class="message-from">From ${mailEffectifInstance.mail.author.username}</h3>
													 <h3 class="message-from">A: <g:each in="${mesmailEffectifRecepteurs}" status="i" var="mesmailEffectifRecepteursInstance"> ${mesmailEffectifRecepteursInstance.recepteur.username} </g:each> </h3>
													
													<div class="message-container">
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
															<g:link  action="Archiver" controller="mailEffectif" onclick="return confirm('Etes vous sure de vouloir envoyer ce message à la corbeille? ');" id="${mailEffectifInstance.id}" class="btn medium btn-primary pull-right"><i class="icon-trash"></i>  Delete Message </g:link>	
														  <g:link  action="Favoriser" controller="mailEffectif"  id="${mailEffectifInstance.id}" class="btn medium btn-primary pull-right"><i class="icon"></i>  favoris </g:link>
														</div>
														<div class="message-body">
															<p>${mailEffectifInstance.mail?.message}</p>
															
															
															
															
														</div>
													</div>
												</div>
												
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
														<li><a href="${request.contextPath}/javascript:void(0);"><span>Inbox</span><span class="badge"></span><i class="icon-angle-right"></i></a>
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
                                                                                                                              <span class="tiny-sub">
                                                                                                                                From :${mailInstance.recepteur.recepteur.username}                                                                                                                              
                                                                                                                                <g:link  controller="Mail"  action="show"  id="${mailInstance.id}">
                                                                                                                                  Objet : ${mailInstance.objet}
                                                                                                                                </g:link>
                   <!--<i class="icon-paper-clip"></i>-->
                                                                                                                                <span class="tiny-des">${mailInstance.message}</span>
                                                                                                                              </span>
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