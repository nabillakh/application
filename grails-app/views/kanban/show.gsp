<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Gestion projet</title>
                <g:javascript library="jquery" plugin="jquery" />
  </head>

 
 <g:render template="/menues/mainleft" />



				<!-- main content -->
				<div id="page-content">
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
                                                  <div class="row-fluid">
                                                    <article class="span12">
                                                      <center><label class="control-label"  for="nomKanban">
                                                          <h1 id="page-header"><g:message code="kanban.nomKanban.label" default="Projet : ${kanbanInstance?.nomKanban}" /></h1>
                                                        </label></center>
                                                    </article>
                                                  </div>
                                                  <div class="row-fluid">
                                                    <article class="span9">
                                                      <center>
                                                        
                                                        </br>
                                                        <label class="control-label"  for="description">
                                                          <pre><g:message code="kanban.description.label" default="Description : ${kanbanInstance?.description}" /></pre>
                                                        </label>
                                                        <label class="control-label"  for="phase">
                                                          <g:message code="kanban.phaseActuelle.label" default="Etat d'avancement du projet : ${kanbanInstance?.phaseActuelle.nom}" />
                                                        </label>
                                                        
                                                        <label class="control-label"  for="dateFinPlanifie">
                                                          Date de fin planifiée :  <g:formatDate code="kanban.dateFinPlanifie.label" format="dd-MM-yyyy" date="${kanbanInstance?.dateFinPlanifie}" />
                                                        </label>
                                                        
                                                        
                                                        <label class="control-label"  for="phase">
                                                          Charge planifiee : ${kanbanInstance?.chargePlanifiee}
                                                        </label>
                                                        
                                                        <label class="control-label"  for="phase">
                                                          Charge dans agenda : ${kanbanInstance?.getAvancementAgenda()}
                                                        </label>
                                                        
                                                        
                                                      </center>
                                                    </article>
                                                    <article class="span3">
                                                      <!-- easy pie chart -->
							<div class="easypie">
								<div class="percentage" data-percent=${kanbanInstance.getAvancementRealise()}>
									<span>${kanbanInstance.getAvancementRealise()}</span>%
								</div>
							</div>
                                                    </article>                     
                                                    
                                                    
                                                  </div>


                                                  
                                                  
                                                  
							<!-- row-fluid -->
							
                                                        <div class="row-fluid">
								
								<article class="span6">
									<!-- new widget -->
									
                                                                        
                                                    mettre courbe avancement
                                                      <div id="indicateurKanban"></div>
                                                      <g:hiddenField name="kanban" id="monKanban" value="${kanbanInstance.id}"/>
                                                      <g:hiddenField name="chargePlanifiee" id="chargePlanifiee" value="${kanbanInstance.chargePlanifiee}"/>
                                                      <g:hiddenField name="kanban" id="monKanban" value="${kanbanInstance.id}"/>
                                                      
                                                                        
                                                                        
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
                                                                  <g:each in="${ofs}" status="k" var="ofInstance">
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
                                                        
                                                </section>
                                                <section>
							<div class="row-fluid">
								<article class="span6">      
									    <header>
									        <h2>Ordonnancement du projet</h2>                           
									    </header>
									    <!-- wrap div -->
									    
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                
                                                                                <g:each in="${ofs}" status="i" var="ofInstance">
                                                                                  <div>
                                                                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                      <td>${ofInstance.kanban.nomKanban}</td
                                                                                      <td><g:formatDate format ='dd-MM-yyyy' date="${ofInstance.dateFinPlanifie}" /></td>
                                                                                      <td>${fieldValue(bean: ofInstance, field: "affectes")}</td
                                                                                      </tr>
                                                                                  </div>
                                                                                </g:each>
									</div>
                                                                </article>
                                                          
                                                        <article class="span6">
                                                          <div class="jarviswidget" id="widget-id-0" data-widget-collapsed="false">
									    <header>
									        <h2>Compte Rendu</h2>                           
									    </header> 
									    
									    <div>
                                                                                          
	
                                                                                    <!-- script de gestion des messages -->
                                                                                    
                                                                                    <div id="chatMessages">
                                                                                    </div>
                                                                                      <script type="text/javascript">
                                                                                        <g:remoteFunction controller="message" action="obtenirMessage" params="\'kanban=\' + ${kanbanInstance.id}" update="chatMessages"/>;
                                                                                      </script>
                                                                                      
                                                                                      
                                                                                    <input type="text" id="messageBox" name="message" onkeypress="messageKeyPress(this,event);"/>
                                                                                        <g:hiddenField name="kanban" id="monKanban" value="${kanbanInstance.id}"/>
                                                                                    <div id="temp"></div>
                                                                                    
                                                                                    
                                                                                    <script>
                                                                                      function messageKeyPress(field,event) {
                                                                                        var theCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
                                                                                        var message = $('#messageBox').val();
                                                                                        var kanban = $('#monKanban').val()
                                                                                        if (theCode == 13){
                                                                                    <g:remoteFunction controller = "message" action="posterMessageKanban" params="\'message=\'+message+ '&kanban=\' + kanban" update="temp"/>
                                                                                                $('#messageBox').val('');
                                                                                                return false;
                                                                                              } else {
                                                                                                return true;
                                                                                              }
                                                                                              }
                                                                                              function obtenirMessage() {
                                                                                              var kanban = $('#monKanban').val()
                                                                                              <g:remoteFunction controller = "message" action="obtenirMessage" params="\'kanban=\' + kanban" update="chatMessages"/>
                                                                                            }
                                                                                                function pollMessages() {
                                                                                                          obtenirMessage();
                                                                                                          setTimeout('pollMessages()', 25000);
                                                                                                        }
                                                                                                        pollMessages();
                                                                                                                                                                                          
                                                                                    </script>
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    <!-- end content -->	
									        
									    <!-- end widget div -->
									
                                                                            
                                                                            </article>
									</div>
                                                            </section>
</div>
                                                                        
                                                          
                                                        
                                                        				<!-- end main content -->
			
				<g:render template="/menues/mainright" />
