
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
                                                                                                                  <th>Phase</th>
															<th>Lundi</th>
															<th>Mardi</th>
															<th>Mercredi</th>
															<th>Jeudi</th>
															<th>Vendredi</th>
														</tr>
													</thead>
													<tbody class="responsive"><g:each in="${lignes}" status="i" var="ligne">
                                                                                                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                                                                                                              <td><g:link action="show" controller="Kanban" id="${ligne.get("Of").kanban.id}">${ligne.get("Of").kanban.nomKanban}</g:link></td>
                                                                                                          
                                                                                                              <td>${ligne.get("Of").phase.nom}</td>
                                                                                                          
                                                                                                           <td>${ligne.get("Lundi")*.eventEffectif.event.dureeHeures.sum()}</td>
                                                                                                           <td>${ligne.get("Mardi")*.eventEffectif.event.dureeHeures.sum()}</td>
                                                                                                           <td>${ligne.get("Mercredi")*.eventEffectif.event.dureeHeures.sum()}</td>
                                                                                                           <td>${ligne.get("Jeudi")*.eventEffectif.event.dureeHeures.sum()}</td>
                                                                                                           <td>${ligne.get("Vendredi")*.eventEffectif.event.dureeHeures.sum()}</td>
                                                                                                          </tr>
                                                                                                          </g:each>
													</tbody>
												</table>
										        	
										    </div>
										    <!-- end content-->
									    </div>
                                                                            