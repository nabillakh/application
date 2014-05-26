
	<link rel="stylesheet" href="${request.contextPath}/css/theme.css?v=1">
	<link rel="stylesheet" href="${request.contextPath}/css/theme-responsive.css?v=1">
                <g:javascript library="jquery" plugin="jquery" />

<div class="row-fluid">
								
								<article class="span6">
									<!-- new widget -->
									         
                                                    mettre courbe avancement
                                                      <div id="indicateurKanban"></div>
                                                      <g:hiddenField name="kanban" id="monKanban" value="${kanbanInstance.nomKanban}"/>
                                                      <g:hiddenField name="chargePlanifiee" id="chargePlanifiee" value="${kanbanInstance.chargePlanifiee}"/>
                                                      
                                                                        
                                                                        
									<!-- end widget -->
								</article>
							
								<article class="span6">
									
									<!-- new widget -->
                                                                        avancement par phase
									    <div>
									    
									       
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
												<div class="progress-stats">
			                                        <div class="widget-content-padding">
                                                                  <g:each in="${kanbanInstance.of}" status="k" var="ofInstance">
			                                            <div class="semi-block">
			                                                <strong>${ofInstance.phase.nom}</strong><strong class="pull-right">${ofInstance.chargeAgenda / ofInstance.chargePlanifiee * 100} %</strong>
			                                                <div class="progress progress-info value"><div class="bar" data-percentage="40" data-amount-part="${ofInstance.chargeAgenda}" data-amount-total="${ofInstance.chargePlanifiee}">456 / 631</div></div>
			                                            </div>
                                                                  </g:each>
			                                        </div>
			                                    </div>
									        <!-- end content -->
									        </div>
									        
									        
									    </div>
									<!-- end widget -->
								</article>
								
							</div>
                
                
                
                
    <script src="${request.contextPath}/js/include/morris.min.js"></script> 
    <script src="${request.contextPath}/js/include/morris-chart-settings.js"></script> 