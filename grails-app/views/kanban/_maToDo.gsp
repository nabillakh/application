
 
<g:if test="${affichageToDo == 1}">
  <g:set var="affichageToDo" value="$affichageToDo+1}" />

<!-- aside progress bars -->
					<ul class="indented aside-progress-stats">
		                <li>
                                <center><span>TO DO LIST:</span></center>
		                </li>
						<li>
							<!-- easy pie chart -->
							<div class="easypie">
								<div class="percentage" data-percent="68">
									<span>68</span>%
								</div>
								<div class="easypie-text">
									Avancement de la To Do
								</div>
							</div>
							<!-- end easy pie chart -->
						</li>
                                                
                                                       <g:each in="${maToDo}" status="i" var="monOF">
		                <li>
		                    <strong>${monOF.kanban.nomKanban} : </br> ${monOF.phase.nom}</strong><strong class="pull-right">${monOF.getChargeRealisee() / monOF.chargePlanifiee *100}%</strong>
		                    <div class="progress progress-danger slim"><div class="bar" data-percentage=${monOF.getChargeRealisee() / monOF.chargePlanifiee *100}%></div></div>
		                </li>
		                
                                                       </g:each>
		            </ul>

</g:if>