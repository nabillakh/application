                                          

<div class="row-fluid">

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


                                                  <div class="row-fluid">                                
                                                          <article class="span12">    
                                                            <header>
                                                              <center><h3>Organisation du projet du projet</h3>   </center>                        
									    </header>
									    <!-- wrap div -->
									    
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                
                                                                                  <table class="table table-responsive" >
                                                                                    <center><h4>Chef de projet : ${kanbanInstance.chefProjet.nom} ${kanbanInstance.chefProjet.prenom}</h4>  </center>
                                                                                <g:each in="${kanbanInstance.of}" status="i" var="ofInstance">
                                                                                  <td><center>Phase : <g:link controller="OF" action="show" id="${ofInstance.id}">${ofInstance.phase.nom} </g:link></br>
                                                                                      Livraison : <g:formatDate format ='dd-MM-yyyy' date="${ofInstance.dateFinPlanifie}" /> </br>
                                                                                      <g:if test="${ofInstance.affectes}">
                                                                                        Affecté à : 
                                                                                      <g:each in="${ofInstance.affectes}" status="j" var="aff">
                                                                                     <g:link controller="Effectif" action="show" id="${aff.effectif.id}"> ${aff.effectif.nom} ${aff.effectif.prenom},</g:link>
                                                                                </g:each></g:if></center></td>
                                                                                </g:each>
                                                                                      </table>
									</div>
                                                                </article>
							</div>