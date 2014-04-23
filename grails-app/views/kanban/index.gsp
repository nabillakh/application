
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
 <g:render template="/menues/mainleft" />



				<div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Gestion du portefeuille</h1>	
					
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							

							<!-- row-fluid -->
							
							<div class="row-fluid">
								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Portefeuille</h2>                           
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
									        
												<table class="table table-striped table-bordered responsive" id="col-filter">
													<thead>
														<tr>
															<th>Nom du projet</th>
															<th>Description</th>
															<th>Phase du projet</th>
															<th>Date de fin planifiée</th>
															<th>Charge associée</th>
														</tr>
														<tr class="second">
															<td>
																<input type="text" name="nomKanban" value="Nom du projet" class="search_init">
															</td>
															<td>
																<input type="text" name="description" value="Description" class="search_init">
															</td>
															<td>
																<input type="text" name="phase" value="Phase du projet" class="search_init">
															</td>
															<td>
																<input type="text" name="dateFinPlanifie" value="Date de fin planifiée" class="search_init">
															</td>
															<td>
																<input type="text" name="charge" value="Charge associée" class="search_init">
															</td>
														</tr>
													</thead>
													<tbody>
                                                                                                          <g:each in="${kanbanInstanceList}" status="i" var="kanbanInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><g:link action="show" controller="Kanban" id="${kanbanInstance.id}">${fieldValue(bean: kanbanInstance, field: "nomKanban")}</g:link></td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "description")}</td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "phaseActuelle")}</td>
                                                                                                          <td><g:formatDate date="${kanbanInstance.dateFinPlanifie}" /></td>
                                                                                                          <td>${fieldValue(bean: kanbanInstance, field: "chargePlanifiee")}</td>
                                                                                                          </tr>
                                                                                                          </g:each>
                                                                                                          
                                                                                                          </tbody>
												</table>
										        	
										    </div>
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div>
									<!-- end widget -->
								</article>
							</div>
							
							<!-- end row-fluid -->
                                                        <g:link  action="create" controller="Kanban" class="btn medium">Ajouter un Kanban</g:link>
                                                        
                                                        

						</section>
						<!-- end widget grid -->
					</div>		
				</div>
 
 
 
<g:render template="/menues/mainright" />