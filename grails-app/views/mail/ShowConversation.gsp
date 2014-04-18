<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

  
 <g:render template="/menues/mainleft" />
				
				
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
												<g:link  action="create" controller="mail" class="btn medium btn-primary pull-right"><i class="icon-star"></i>  Nouveau message </g:link>
												</div>
												<div class="inbox-body-content" id="inbox-loading-panel-js">
													<h1 class="message-title">Objet :  ${conversationInstance.lastmail.objet} </h1>
													<div class="message-container">
												<div class="message-control-panel">
															<div class="btn-group">
																<a class="btn btn-primary medium" href='javascript: Replay()'><i class="icon-reply"></i> Reply</a>
																<a class="btn btn-primary medium dropdown-toggle" data-toggle="dropdown" href="javascript:void(0);"><span class="caret"></span></a>
																<ul class="dropdown-menu btn-small">
																	<li>
																		<a href='javascript: ReplayALL()'><i class="cus-arrow-undo"></i> Reply All</a>
																	</li>
																	<li>
																		<a href="javascript:void(0);"><i class="cus-envelope"></i> Mark as unread</a>
																	</li>
																	<li>
																		<a href="javascript:void(0);"><i class=" cus-arrow-right"></i> Forward</a>
																	</li>
																	<li class="divider"></li>
																	<li>
																		<a href="javascript:void(0);"><i class="cus-cancel"></i> Cancel</a>
																	</li>
																</ul>
															</div>
                                                                                                                        
														
														</div>
                                                                                                                          
                                                                                                                              
														  <div class="message-body">
                                                                                                                    <table style="width: 700px;">   
                                                                                                                     <g:each in="${Listmail}" status="i" var="ListmailInstance">
                                                                                                                         <tr  style="  border-bottom: 1px solid red; height:40px;"><td>${conversationInstance.id}</td>
                                                                                                                     <td> De : ${ListmailInstance.author.username}</td>
                                                                                                                     <td>   A :  ${ListmailInstance.recepteur.recepteur.username} </td>
                                                                                                                     <td>    ${ListmailInstance.message}</td>
                                                                                                                      <td style="text-align: right;">   ${ListmailInstance.dateCreated} </td></tr>
                                                                                                                    
                                                                                                                  
															
															  </g:each>
															</table>
														
                                                                                                                      </div> 
                                                                                                                      <div style="display: none;" id='ReplayALL' >
                                                                                                                    <g:form url="[action:'RelierALL',controller:'Mail']">
                                                                                                                        <g:hiddenField name="conversation" value="${conversationInstance.id}" /> <g:hiddenField name="author" value="${conversationInstance.lastmail.author?.id}" />
                                                                                                     A :</br> <input name="recepteur" value="${conversationInstance.lastmail.recepteur.recepteur?.id}" class="many-to-many" style="width: 80%; height: 20px;">  ${conversationInstance.lastmail?.dateCreated}
                                                                                                                        <g:hiddenField name="objet"  value="${conversationInstance.lastmail?.objet}"  placeholder="Objet..." style="width: 100%; height: 20px;"/>              
                                                                                                                        <textArea id="wysihtml5" name="message"   value="${conversationInstance.lastmail?.message}"  placeholder="Enter text ..."  style="width: 80%; height: 100px;" ></textArea>               
                                                                                                                        <fieldset class="buttons">
                                                                                                                        <g:submitButton name="create" controller="Mail" class="btn medium btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                                                                                                                        </fieldset>                      
                                                                                                                     </g:form>
                                                                                                 </div>
                                                                                                   <div style="display: none;" id='Replay' >
                                                                                                                    <g:form url="[action:'Relier',controller:'Mail']">
                                                                                                                        <g:hiddenField name="conversation" value="${conversationInstance.id}" />
                                                                                                     A :</br> <input name="recepteur" value="${conversationInstance.lastmail.author?.id}" class="many-to-many" style="width: 80%; height: 20px;">
                                                                                                                        <g:hiddenField name="objet"  value="${conversationInstance.lastmail?.objet}"  placeholder="Objet..." style="width: 100%; height: 20px;"/>              
                                                                                                                        <textArea id="wysihtml5" name="message"   value="${conversationInstance.lastmail?.message}"  placeholder="Enter text ..."  style="width: 80%; height: 100px;" ></textArea>               
                                                                                                                        <fieldset class="buttons">
                                                                                                                        <g:submitButton name="create" controller="Mail" class="btn medium btn-primary" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                                                                                                                        </fieldset>                      
                                                                                                                     </g:form>
                                                                                                 </div>
													
                                                                                                                 
                                                                                                                  
													</div>
												</div>
												<g:set var="listcompteur" value="${1}" />  
											</div><messagerie:listMessagerie>
                                                                            </messagerie:listMessagerie>
											</div>


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
			
				
	<!-- ---------------------------------------------------------------------------- -->                                                                   
 <script>
function ReplayALL(){
		if(document.getElementById('ReplayALL').style.display == 'none'){
    	document.getElementById('ReplayALL').style.display = 'block';
  		}
  		else {
    	document.getElementById('ReplayALL').style.display = 'none';
		}
}
function Replay(){
if(document.getElementById('Replay').style.display == 'none'){
    	document.getElementById('Replay').style.display = 'block';
  		}
  		else {
    	document.getElementById('Replay').style.display = 'none';
		}
}
</script>			
 <!-- ---------------------------------------------------------------------------- --> 						
					
				
				
<g:render template="/menues/mainright" />