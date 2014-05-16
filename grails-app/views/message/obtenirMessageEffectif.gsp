  <header>
									        <h2>Journal</h2>                           
  </header> <div>
    <div class="inner-spacer chat-widget widget-content-padding"> 
									        	
									        	<!-- chat tabs -->
												<ul id="myChat" class="nav nav-tabs chat-tabs">
									            </ul>
									            <!-- end chat tabs -->
									            
									            <!-- chat box -->
									            <div id="myChatTab" class="tab-content chat-content">
									              
									              <!-- chat user1 -->	
									              <div class="tab-pane fade in active" id="monContenu">
									              	
									              	<!-- chat messages -->
									              	<div class="chat-messages">
									              		<g:each in="${mesMessages}" var="message">
  
  <g:if test="${message.auteur == moi}">
<p id="message-id-3" class="message-box you">
    </g:if>
  <g:else>
<p id="message-id-3" class="message-box">
  </g:else>
  
  <span class="message">
    <strong><g:link action="show" controller="Effectif" id="${message.auteur.id}">${message.auteur.nom} ${message.auteur.prenom}</g:link></strong> 
     <g:if test="${message.kanban}">
       <g:link action="show" controller="Kanban" id="${message.kanban.id}"> à propos du projet : ${message.kanban.nomKanban}</g:link>
       </g:if>
    <span class="message-time"><g:formatDate format="dd-MM-yyyy hh:mm a" date="${message.date}"/></span>
    <span class="message-text">${message.message}</span>
  </span>
</p>
  
</g:each>
									              	
									             	</div>
									              	<!-- end chat messages -->
									              	
									              </div>
									              <!-- end chat user1 -->
									              
									              <!-- chat user2 -->
									              
									              <!-- end chat user2 -->
									              
									            </div>
									            <!-- end chat box -->
									            
									            <div class="row-fluid chat-box">
									            	
									            	<textarea name="enter-message" rows="3" cols="1" placeholder="Enter your message..." id="chat-box-textarea"></textarea>
													<div class="row-fluid">
		                                                <div class="span6 type-effect" style="display:none"><img src="img/loaders/misc/16-2.gif" alt=""> Victoria is typing...</div>
		                                                <div class="span6 chat-box-buttons pull-right">
		                                                	<input type="submit" name="chat-box-textarea" class="btn medium btn-danger pull-right" value="Send" id="send-msg-js">
		                                                    <a href="javascript:void(0);" title="" class="pull-right"><i class="icon-camera"></i></a>
		                                                </div>
		                                            </div>

									            </div>
										       		
											
									        </div>
									        </div>
									        <!-- end content -->	
									        
									    