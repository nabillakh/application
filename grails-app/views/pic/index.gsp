
<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
 <g:render template="/menues/mainleft" />



				<div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Gestion du PIC</h1>	
					
					
                                        <div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							

							<!-- row-fluid -->
							
							<div class="row-fluid">
                                                          <article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-4">
									    <header>
									        <h2>Plan industriel et commercial</h2>                           
									    </header>
									    <!-- wrap div -->
									    <div>
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                
												<table class="table table-bordered table-responsive table-condensed " id="just-table">
													<thead>
														<tr>
                                                                                                                        <th class="col-md-4">Annee : </th>
															<th class="col-md-2">${year-1}</th>
															<th class="col-md-2">${year}</th>
															<th class="col-md-2">${year+1}</th>
															<th class="col-md-2">${year+2}</th>
														</tr>
													</thead>
													<tbody class="responsive">
                                                                                                        <g:each in="${mesFamilles}" status="j" var="fam">
                                                                                                            <tr class="alert">
                                                                                                              <td class="col-md-4"><g:link action="show" controller="Famille" id="${fam.id}">${fieldValue(bean: fam, field: "nom")}</g:link></td>
                                                                                                          <td class="col-md-2"></td>
                                                                                                          <td class="col-md-2"></td>
                                                                                                          <td class="col-md-2"></td>
                                                                                                          <td class="col-md-2"></td>
                                                                                                          </tr>
                                                                                                          <g:each in="${fam.ordo}" status="k" var="ordo">
                                                                                                          <tr>
                                                                                                              <td><g:link action="show" controller="Ordonnancement" id="${ordo.id}">${fieldValue(bean: ordo, field: "nom")} <p align="right"> Planifie :</br></p> <p align="right"> Réalisé :</p></g:link></td>
                                                                                                          <td class="span2">
                                                                                                            </br>
                                                                                                          <g:each in="${pic1.picFamille}" status="p" var="pf">
                                                                                                          <g:if test="${pf.ordo == ordo}">
                                                                                                           ${pf.uniteActivite}
                                                                                                          </g:if>
                                                                                                          </g:each>
                                                                                                          </td>
                                                                                                          <td class="span2">
                                                                                                            </br>
                                                                                                          <g:each in="${pic2.picFamille}" status="p" var="pf">
                                                                                                          <g:if test="${pf.ordo == ordo}">
                                                                                                           ${pf.uniteActivite}
                                                                                                          </g:if>
                                                                                                          </g:each></td>
                                                                                                          <td class="span2">
                                                                                                            </br>
                                                                                                          <g:each in="${pic3.picFamille}" status="p" var="pf">
                                                                                                          <g:if test="${pf.ordo == ordo}">
                                                                                                           ${pf.uniteActivite}
                                                                                                          </g:if>
                                                                                                          </g:each></td>
                                                                                                          <td class="span2">
                                                                                                            </br>
                                                                                                          <g:each in="${pic4.picFamille}" status="p" var="pf">
                                                                                                          <g:if test="${pf.ordo == ordo}">
                                                                                                           ${pf.uniteActivite}
                                                                                                          </g:if>
                                                                                                          </g:each></td>
                                                                                                          </tr>
                                                                                                          
                                                                                                          </g:each>
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
                                                          <article>
                                                          <pic:mesPics>
                                                          </pic:mesPics>
                                                          </article>
                                                          
                                                          
                                                          
							</div>                                                    
                                                        

						</section>
                                                
                                                
						<!-- end widget grid -->
					</div>
				</div>
 
 
 
<g:render template="/menues/mainright" />