
 
<g:if test="${affichageKanban == 1}">
  <g:set var="affichageKanban" value="$affichageKanban+1}" />

<div class="btn-group hidden-phone">
								<a href="javascript:void(0)" class="btn btn-inverse btn-small">Mes actions</a>
								<a href="javascript:void(0)" class="btn btn-inverse dropdown-toggle btn-small" data-toggle="dropdown"><span class="caret"></span></a>
					
								<div class="dropdown-menu toolbar pull-right">
									<h3>Afficher toutes mes tâches</h3>
									<ul class="progressbox">
                                                                          
                                                                          <g:each in="${mesOF}" status="i" var="monOF">
						                <li>
						                    <strong><i class="online pull-left"></i>${monOF.phase.nom}</strong><b>Complete</b>
						                    <div class="progress progress-success slim"><div class="bar" style="width: 100%;"></div></div>
						                </li>
                                                                          </g:each>
						                
						            </ul>
								</div>

							</div></g:if>