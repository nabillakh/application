
                                                          <div class="jarviswidget" id="widget-id-0" data-widget-collapsed="false">
									    <header>
									        <h2>Compte Rendu</h2>                           
									    </header> 
									    
									    <div>
                                                                              
                                                                              <div class="row-fluid chat-box">
                                                                                    <input class="span12 type-effect" type="text" id="messageBox" name="message" placeholder="Tapez votre message..." onkeypress="messageKeyPress(this,event);"/>
                                                                                        <g:hiddenField name="kanban" id="monKanban" value="${kanbanInstance.id}"/>
                                                                                    <div id="temp"></div>
                                                                                    <!-- script de gestion des messages -->
                                                                                    </div>
                                                                                    <div id="chatMessages">
                                                                                    </div>
                                                                                      <script type="text/javascript">
                                                                                        <g:remoteFunction controller="message" action="obtenirMessage" params="\'kanban=\' + ${kanbanInstance.id}" update="chatMessages"/>;
                                                                                      </script>
                                                                                      
                                                                                      
                                                                                    
                                                                                    
                                                                                    <script>
                                                                                      function messageKeyPress(field,event) {
                                                                                        var theCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
                                                                                        var message = $('#messageBox').val();
                                                                                        var kanban = $('#monKanban').val()
                                                                                        if (theCode == 13){
                                                                                    <g:remoteFunction controller = "message" action="posterMessageKanban" params="\'message=\'+message+ '&kanban=\' + kanban" update="temp"/>
                                                                                                $('#messageBox').val('');
                                                                                                return false;
                                                                                              } else {
                                                                                                return true;
                                                                                              }
                                                                                              }
                                                                                              function obtenirMessage() {
                                                                                        var kanban = $('#monKanban').val();
                                                                                              <g:remoteFunction controller = "message" action="obtenirMessage" params="\'kanban=\' + kanban" update="chatMessages"/>
                                                                                            }
                                                                                                function pollMessages() {
                                                                                                          obtenirMessage();
                                                                                                          setTimeout('pollMessages()', 25000);
                                                                                                        }
                                                                                                        pollMessages();                                                                                                       
                                                                                    </script>
                                                                                    
                                                                                    
                                                                                    
                                                                                    
									</div>
									</div>