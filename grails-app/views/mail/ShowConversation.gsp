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
												
													 
													<div class="message-container">
												<div class="message-control-panel" >
															
                                                                                                                      
                                                                                                    <h4>	Objet :  ${conversationInstance.lastmail.objet} </h4>
														
                                                                                                                          
                                                                                                          </div>                    
														  
														 <g:set var="last" value=" ${conversationInstance.lastmail.id}" />  
                                                                                                                   
                                                                                                                      
                                                                                                                     <g:each in="${Listmail}" status="i" var="ListmailInstance">
                                                                                                                          <g:set var="courant" value=" ${ListmailInstance.id}" /> 
                                                                                                                               <g:if test="${courant != last}"> 
                                                                                                                         <div class="alert alert-info adjusted alert-block" style=" margin: 0px;">
                                                                                                                        <!-- <div class="alert adjusted alert-success" style=" height: 50px; margin-bottom: 0px;"> -->
                                                                                                                        
                                                                                                                            
					
					
                                                                                                                         ${conversationInstance.id}
                                                                                                                      De : ${ListmailInstance.author.username}
                                                                                                                     A :  ${ListmailInstance.recepteur.recepteur.username} 
                                                                                                                        ${ListmailInstance.message}
                                                                                                                      ${ListmailInstance.dateCreated} 
                                                                                                                    
                                                                                                                  
															</div>
                                                                                                                        </g:if>
                                                                                                        
                                                                                                                          <g:else>
                                                                                                                               <g:set var="rep" value=" ${ListmailInstance.recepteur.size()}" /> 
                                                                                                                                 <g:set var="tous" value=" ${1}" /> 
                                                                                                                         
                                                                                                                <div class="message-body" >
														<table style=" margin-top : 0px; width: 700px;">
                                                                                                                        <tr>  <td> <h5>       De : ${ListmailInstance.author.username} </h5></td> 
                                                                                                                              <td style="text-align: right;"> <h5> ${ListmailInstance.dateCreated} </h5></td></tr>
                                                                                                                        <tr>  <td>   à :  ${ListmailInstance.recepteur.recepteur.username} </td> </tr>
                                                                                                                        <tr>  <td>  <span> ${ListmailInstance.message}</span> </td></tr> 
                                                                                                                        <tr>  <td>   <g:if test="${ListmailInstance.author != currentLoggedInUser }" > Cliquez ici pour <a href="javascript:Replay()">Répondre </a>  </g:if>
                                                                                                                                                            <g:if test="${rep != tous}">  ou ici pour <a href="javascript:Replay()">Répondre à tous ${rep}</a> </g:if> </td></tr>
                                                                                                                            
                                                                                                                </table>
														</div>     
                                                                                                                            </g:else>
															  </g:each>
                                                                                                                          
															
														
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
													
                                                                                                                 
                                                                                                                  
													
												<g:set var="listcompteur" value="${1}" />  
											</div>
                                                                                        <messagerie:listMessagerie>
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