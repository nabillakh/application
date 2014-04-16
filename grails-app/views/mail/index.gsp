<!DOCTYPE html>
<%@ page import="application.MailService" %>
<%
    def myService = grailsApplication.classLoader.loadClass('application.MailService').newInstance()
%>
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
									    
            							
								       
								        <!-- content goes here -->
											<div class="inbox-body" id="inbox-body-js">
												<div class="inbox-control-panel">
                                                                                                  <g:link  action="create" controller="mail" class="btn medium btn-primary pull-right"><i class="icon-star"></i>  Nouveau message </g:link>
												</div>
                                                                                          
                                                                                                    <div class="jarviswidget" id="widget-id-4">

                                                                                                      <!-- widget div-->
                                                                                                      <div>

                                                                                                        <div class="inner-spacer"> 
                                                                                                            
                                                                                                            
                                                                                                               
                                                                                                    
                                                                                                       
                                                                                                                                                    
                                                                                                          <!-- content -->
                                                                                                          <g:each in="${mesConversations}" status="i" var="mesConversationsInstance">
                                                                                                          <div class="alert alert-info adjusted alert-block" style=" margin: 0px;">
											<p>
											<strong>  De : </strong>${mesConversationsInstance.lastmail.author.username} <strong> Objet :</strong> ${mesConversationsInstance.lastmail.objet} <strong> Contenu : </strong>${mesConversationsInstance.lastmail.message}
                                                                                        </p>
											
                                                                                                              
                                                                                                             
                                                                                                              
                                                                                                              <!-- gerer ce bout de code sous forme de taglib pour gerer la condition
                                                                                                              <div id="collapse${i}" class="accordion-body collapse" style="height: 0px; ">
                                                                                                                <g:each in="${mesEffectifsMails}" status="j" var="mailEffectifInstance">
                                                                                                                  <g:if test = "${mesConversations.mails.contains(mailEffectifInstance.mail)}" >
                                                                                                                <div class="accordion-inner"> 
                                                                                                               <g:link  controller="MailEffectif"  action="show"  id="${mailEffectifInstance.id}">  ${fieldValue(bean: mailEffectifInstance, field: "mail.message")} </g:link>
                                                                                                                </div>
                                                                                                                  </g:if>
                                                                                                                 </g:each>    -->
                                                                                                              
                                                                                                     </div>     
                                                                                                    </g:each>
                                                                                                            
                                                                                                            
                                                                                                          <!-- end content -->	
                                                                                                      

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