
									    <header>
									        <h2>Grille d'imputation</h2>                           
									    </header>
									    <!-- wrap div -->
									    <div>
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                
												<table class="table hover table-bordered responsive">
													<thead>
														<tr>
                                                                                                                  <th>Nom du projet</th>
															<th>Lundi</th>
															<th>Mardi</th>
															<th>Mercredi</th>
															<th>Jeudi</th>
															<th>Vendredi</th>
														</tr>
													</thead>
													<tbody class="responsive"><g:each in="${kanbanInstanceList}" status="i" var="kanbanInstance">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><g:link action="show" controller="Kanban" id="${kanbanInstance.id}">${kanbanInstance.nomKanban}</g:link></td>
                                                                                                          
                                                                                                           <td>${kanbanInstance.getChargeAgenda()}</td>
                                                                                                           <td>${kanbanInstance.getChargeAgenda()}</td>
                                                                                                           <td>${kanbanInstance.getChargeAgenda()}</td>
                                                                                                           <td>${kanbanInstance.getChargeAgenda()}</td>
                                                                                                           <td>${kanbanInstance.getChargeAgenda()}</td>
                                                                                                          </tr>
                                                                                                          </g:each>
													</tbody>
												</table>
										        	
										    </div>
										    <!-- end content-->
									    </div>
                                                                            