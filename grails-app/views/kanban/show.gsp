<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Gestion projet</title>
                <g:javascript library="jquery" plugin="jquery" />
                  <style type="text/css">
        #chatMessages {
            border: 1px solid #000;
            height: 300px;
            width: 900px;
            overflow-y: auto;
        }
        #messageBox {
            width: 888px;
        }
        .nickname {
            color: #f00;
            font-weight: bold;
        }
        .msg {
            color: #444;
            font-weight: normal;
        }
    </style>
  </head>

 
 <g:render template="/menues/mainleft" />



				<!-- main content -->
				<div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Gestion du portefeuille</h1>	
					
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							

							<!-- row-fluid -->
							
                                                        <div class="row-fluid">
								
								<article class="span6">
									<!-- new widget -->
									
                                                                        <div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Fiche du projet : "${fieldValue(bean: kanbanInstance, field: "nomKanban")}"</h2>                           
									    </header>
									    <!-- wrap div -->
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
                                                                                <center>
                                                                                <div class="control-group" style=" text-align: left;">
                                                                                  <label class="control-label"  for="nomKanban">
                                                                                    <g:message code="kanban.nomKanban.label" default="Nom du projet : ${kanbanInstance?.nomKanban}" />
                                                                                  </label>
                                                                                </div>
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="description">
                                                                                    <g:message code="kanban.description.label" default="Description : ${kanbanInstance?.description}" />
                                                                                  </label>
                                                                                </div>
                                                                                <div class="control-group" style=" text-align: left;">
                                                                                  <label class="control-label"  for="phase">
                                                                                    <g:message code="kanban.phaseActuelle.label" default="Etat d'avancement du projet : ${kanbanInstance?.phaseActuelle}" />
                                                                                  </label>
                                                                                </div>
                                                                                <div class="control-group" style=" text-align: left;">
                                                                                  <label class="control-label"  for="dateFinPlanifie">
                                                                                    <g:message code="kanban.dateFinPlanifie.label" default="Date de fin planifiée : ${kanbanInstance?.dateFinPlanifie}" />
                                                                                  </label>
                                                                                </div>
                                                                                  </center>
                                                                                </div>
                                                                              
                                                                              
                                                                              
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div>
                                                                        
                                                                        
									<!-- end widget -->
								</article>
							
								<article class="span6">
									
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-5">
									    <header>
									        <h2>Avancement</h2>                           
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
									</div>
									<!-- end widget -->
								</article>
								
							</div>
                                                        
                                                        
                                                        
							<div class="row-fluid">
								<article class="span12">      
                                                                        <div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Ordonnancement du projet : "${fieldValue(bean: kanbanInstance, field: "nomKanban")}"</h2>                           
									    </header>
									    <!-- wrap div -->
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
                                                                                
                                                                                <g:each in="${ofs}" status="i" var="ofInstance">
                                                                                  <div>
                                                                                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                      <td>${ofInstance.kanban.nomKanban}</td
                                                                                      <td><g:formatDate format ='dd-MM-yyyy' date="${ofInstance.dateFinPlanifie}" /></td>
                                                                                      <td>${fieldValue(bean: ofInstance, field: "affectes")}</td
                                                                                      </tr>
                                                                                  </div>
                                                                                </g:each>
                                                                                
                                                                                
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div>
                                                                        </div></article></div>
                                                        <article>
                                                          <div class="jarviswidget" id="widget-id-0" data-widget-collapsed="false">
									    <header>
									        <h2>Compte Rendu</h2>                           
									    </header> 
									    
									    <div>
                                                                                          
	
                                                                                    <!-- script de gestion des messages -->
                                                                                    
                                                                                    <div id="chatMessages">
                                                                                    </div>
                                                                                      <script type="text/javascript">
                                                                                        <g:remoteFunction action="obtenirCompteRendu" params="\'kanban=\' + ${kanbanInstance.id}" update="chatMessages"/>;
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
                                                                                    <g:remoteFunction action="updateCompteRendu" params="\'message=\'+message+ '&kanban=\' + kanban" update="temp"/>
                                                                                                $('#messageBox').val('');
                                                                                                return false;
                                                                                              } else {
                                                                                                return true;
                                                                                              }
                                                                                              }
                                                                                              function obtenirCompteRendu() {
                                                                                        var kanban = $('#monKanban').val()
                                                                                              <g:remoteFunction action="obtenirCompteRendu" params="\'kanban=\' + kanban" update="chatMessages"/>
                                                                                                        }
                                                                                                        function pollMessages() {
                                                                                                          retrieveLatestMessages();
                                                                                                          setTimeout('pollMessages()', 5000);
                                                                                                        }
                                                                                                        pollMessages();
                                                                                                                                                                                          
                                                                                    </script>
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    
                                                                                    <!-- end content -->	
									        
									    <!-- end widget div -->
									
                                                                            
                                                                            </article>
									</div>
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        
                                                        </section>
                                                                        </div>
                                                                        
                                                          
                                                          
							</div>
                                                        
                                                        				<!-- end main content -->
			
				<g:render template="/menues/mainright" />
