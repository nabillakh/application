
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Gestion des activités</title>
  </head>

  
 <g:render template="/menues/mainleft" />
   				
     <!-- main content --><div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Management des ressources humaines</h1>	
                                        <!-- images avec données macro -->
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
										<img src="${request.contextPath}/img/start-icons/orders.png" alt="">
										<span>Projets cloturés</span>
									</a>
								</li>
								<li>
									<label>new</label>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/stats.png" alt="">
										<span>Indicateurs</span>
									</a>
								</li>
								<li>
									<label>657</label>
									<a href="javascript:void(0)" title="">
										<img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
										<span>Projets en retard</span>
									</a>
								</li>
							</ul>

						</div>
					
                                        
                                        
                                        <div class="row-fluid">
								
								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-2">
									    <header>
									        <h2>Gestion RH</h2>                           
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
            
									        <div class="inner-spacer widget-content-padding"> 
									        <!-- content -->	
												<ul id="myTab" class="nav nav-tabs default-tabs">
													<li class="active">
														<a href="#s1" data-toggle="tab">Effectif</a>
													</li>
													<li>
														<a href="#s2" data-toggle="tab">Equipe</a>
													</li>
                                                                                                        <li>
														<a href="#s3" data-toggle="tab">Compétence</a>
													</li>
                                                                                                        <li>
														<a href="#s4" data-toggle="tab">Droits</a>
													</li>
													
												</ul>
												<div id="myTabContent" class="tab-content">
													<div class="tab-pane fade in active" id="s1">
                                                                                                          <div>
                                                                                                            <div class="inner-spacer"> 
                                                                                                              <table class="table table-striped table-bordered responsive" id="dtable">
                                                                                                                <thead>
                                                                                                                  <tr>
                                                                                                                    <th>Nom</th>
                                                                                                                    <th>prenom</th>
                                                                                                                    <th>Equipe</th>
                                                                                                                    <th>Compte expiré</th>
                                                                                                                     <th>Compte Bloqué</th>
                                                                                                                  </tr>
                                                                                                                </thead>
                                                                                                                <tbody>

                                                                                                                <g:each in="${effectifInstanceList}" status="i" var="EffectifInstance">
                                                                                                                  <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                                    <td><g:link action="show" controller="Effectif" id="${EffectifInstance.id}">${fieldValue(bean: EffectifInstance, field: "nom")}</g:link></td>
                                                                                                                <td>${EffectifInstance.prenom}</td>
                                                                                                                <td>${EffectifInstance.equipe}</td>
                                                                                                                <td>${EffectifInstance.accountExpired}</td>
                                                                                                                <td>${EffectifInstance.accountLocked}</td>
                                                                                                                </tr>
                                                                                                                </g:each>
                                                                                                              </tbody>
                                                                                                              </table>


                                                                                                            </div>
                                                                                                            <!-- end content-->
                                                                                                          </div>
                                                                                                          <!-- end wrap div -->
                                                                                                        </div>
                                                                                                  <div class="tab-pane fade" id="s2">
                                                                                                    <div>
                                                                                                      <div class="inner-spacer"> 
                                                                                                        <table class="table table-striped table-bordered responsive" id="dtable">
													<thead>
                                                                                                          <tr>
                                                                                                            <th>Nom</th>
                                                                                                            
                                                                                                          </tr>
                                                                                                        </thead>
													<tbody>
                                                                                                        
                                                                                                       
                                                                                                        </tbody>
												</table>
										
										        	
										    </div>
										    <!-- end content-->
									    </div>
													</div>
													<div class="tab-pane fade" id="s3">
													 <div>
									    
									        
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                
												<table class="table table-striped table-bordered responsive" id="dtable">
													<thead>
														<tr>
															<th>Nom</th>
															<th>Nb D'Effectifs associée</th>
															
														</tr>
													</thead>
													<tbody>
                                                                                                        
                                                                                                        <g:each in="${competenceInstanceList}" status="i" var="competenceInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><g:link action="show" controller="Competence" id="${competenceInstance.id}">${fieldValue(bean: competenceInstance, field: "nom")}</g:link></td>
                                                                                                          
                                                                                                          <td>${competenceInstance.effectifs.size()}</td>
                                                                                                          </tr>
                                                                                                          </g:each>
                                                                                                        </tbody>
												</table>
										
										        	
										    </div>
										    <!-- end content-->
									    </div>
													</div>
													<div class="tab-pane fade" id="s4">
														<div>
									    
									        
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                
												<table class="table table-striped table-bordered responsive" id="dtable">
													<thead>
														<tr>
															<th>Authority</th>
															
														</tr>
													</thead>
													<tbody>
                                                                                                        
                                                                                                        <g:each in="${droitInstanceList}" status="i" var="droitInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><g:link action="show" controller="Droit" id="${droitInstance.id}">${fieldValue(bean: droitInstance, field: "authority")}</g:link></td>
                                                                                                         
                                                                                                          </tr>
                                                                                                          </g:each>
                                                                                                        </tbody>
												</table>
										
										        	
										    </div>
										    <!-- end content-->
									    </div>
                                                                                                        </div>
												</div>
											<!-- end content -->	
									        </div>
									        
									    </div>
									    <!-- end widget div -->
									</div>
									<!-- end widget -->
								</article>
								
								
							</div>
                                        
                                        
                                        <!-- fin tableau superieru -->
                                        
						<!-- end widget grid -->
					</div>	

<g:render template="/menues/mainright" />



 
