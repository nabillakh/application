<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

 
 <g:render template="/menues/mainleft" />
				
				<!-- main content -->
				<div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Inbox</h1>	
					
					<div class="fluid-container">

						<div class="alert adjusted alert-info">
							<button class="close" data-dismiss="alert">×</button>
							<i class="cus-exclamation"></i>
							<strong>Info!</strong> Mobile version of this page is currently not supported.
						</div>

                                          
						<!-- NO WIDGETS ON THIS PAGE -->
							<div class="row-fluid">
								<article class="span12">
									
									<!-- new widget -->
									<div class="jarviswidget">

									    <!-- wrap div -->
									    
            							
								        <div class="inner-spacer"> 
								        <!-- content goes here -->
											<div class="inbox-body" id="inbox-body-js">
												<div class="inbox-control-panel">
                                                                                                  <g:link  action="create" controller="mail" class="btn medium btn-primary pull-right"><i class="icon-star"></i>  Ecrire nouveau message </g:link>
												</div>
                                                                                          
                                                                                                    <div class="jarviswidget" id="widget-id-4">

                                                                                                      <!-- widget div-->
                                                                                                      <div>

                                                                                                        <div class="inner-spacer"> 
                                                                                                          <!-- content -->
                                                                                                          <g:each in="${mesEffectifsMails}" status="i" var="mailEffectifInstance">
                                                                                                          <div class="accordion" id="accordion1">
                                                                                                            <div class="accordion-group">
                                                                                                              <div class="accordion-heading">
                                                                                                                <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion1" href="#collapse${i}">
                                                                                                                  <i class="icon-plus-sign"></i> ${mailEffectifInstance.mail.objet} </a>
                                                                                                              </div>
                                                                                                              <div id="collapse${i}" class="accordion-body collapse" style="height: 0px; ">
                                                                                                                <div class="accordion-inner"> 
                                                                                                               <g:link  controller="MailEffectif"  action="show"  id="${mailEffectifInstance.id}">  ${fieldValue(bean: mailEffectifInstance, field: "mail.message")} </g:link>                                                                                                                
                                                                                                                
                                                                                                                ${mailEffectifInstance.lu}
                                                                                                                ${mailEffectifInstance.archive}
                                                                                                               favoris : ${mailEffectifInstance.favoris}
                                                                                                                </div>
                                                                                                              </div>
                                                                                                            </div>
                                                                                                          </div>
                                                                                                          
                                                                                                    </g:each>
                                                                                                            
                                                                                                            
                                                                                                          <!-- end content -->	
                                                                                                        </div>

                                                                                                      </div>
                                                                                                      <!-- end widget div -->
                                                                                                    </div>

                                                                                                    <!-- ajouter par NL -->
                                                                                                </div>
                                                                         <g:set var="listcompteur" value="${1}" />  
                                                                            <messagerie:listMessagerie>
                                                                            </messagerie:listMessagerie>


										</div>
									    <!-- end content-->
									   
									    <!-- end wrap div -->
									</div>
									
									
									<!-- end widget -->
								</article>
							</div>
					</div>		
				</div>
				<!-- end main content -->
			
				<g:render template="/menues/mainright" />