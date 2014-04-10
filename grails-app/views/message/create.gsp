<div class="tab-content">
															<!-- step 1-->
                                                                                                                        <g:form url="[resource:kanbanInstance, action:'save']" >
														    <fieldset class="tab-pane" id="inverse-tab1">
                                                                                                                      
                                                                                                                      <div class="control-group">
                                                                                                                        <label class="control-label"  for="nomKanban">
                                                                                                                          <g:message code="kanban.nomKanban.label" default="Nom du projet" />                                                                                                                          
                                                                                                                        </label>
                                                                                                                        <g:textField name="nomKanban" value="${kanbanInstance?.nomKanban}" class="span12" id="name" />
                                                                                                                        
                                                                                                                      </div>
                                                                                                                      
                                                                                                                      
	                                                                                                                      <div class="control-group">
                                                                                                                        <label class="control-label"  for="description">
                                                                                                                          <g:message code="kanban.description.label" default="Description" />                                                                                                                          
                                                                                                                        </label>
                                                                                                                        <g:textField name="description" value="${kanbanInstance?.description}" class="span12" />
                                                                                                                        
                                                                                                                      </div>
                                                                                                                      
                                                                                                                      <div class="control-group">
                                                                                                                        <label class="control-label"  for="famille">
                                                                                                                          <g:message code="kanban.famille.label" default="Famille de projet" />       
                                                                                                                          <span class="required-indicator">*</span>
                                                                                                                        </label>
                                                                                                                        <g:select  id="famille" name="famille.id" from="${application.PP.Famille.list()}" optionKey="id" required="" value="${kanbanInstance?.famille?.id}" class="span12"/>
                                                                                                                        
                                                                                                                      </div>
                                                                                                                      
                                                                                                                      
                                                                                                                      <div class="control-group">
                                                                                                                        <div class="controls">
                                                                                                                          <div>
                                                                                                                        <label class="input-append date" id="datepicker-js" data-date-format="dd-mm-yyyy"  for="dateFinPlanifie" value="${kanbanInstance?.dateFinPlanifie}" >
                                                                                                                          <g:message code="kanban.dateFinPlanifie.label" default="Date de fin prévisionnelle" />                                                                                                                          
                                                                                                                        </label>
                                                                                                                          </div>
																<div class="input-append date" id="datepicker-js" data-date-format="dd-mm-yyyy">
																	<input class="datepicker-input" size="16" type="text" value="${kanbanInstance?.dateFinPlanifie}" placeholder="Select a date" />
																	<span class="add-on"><i class="cus-calendar-2"></i></span>
																</div>                                                                                                                        
                                                                                                                      </div>
                                                                                                                        </div>
                                                                                                                      
                                                                                                                      
	                                                                                                                      <div class="control-group">
                                                                                                                        <label class="control-label"  for="charge">
                                                                                                                          <g:message code="kanban.charge.label" default="Charge planifiée" />                                                                                                                          
                                                                                                                        </label>
                                                                                                                        <g:textField name="charge" value="${kanbanInstance?.charge}" class="span12" />
                                                                                                                        
                                                                                                                      </div>
                                                                                                                      
														    </fieldset>
                                                                                                                          </g:form>
														    <!-- step 2-->
														    <fieldset class="tab-pane" id="inverse-tab2">
																<div class="control-group">
																	<label class="control-label" for="s1">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s1">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s2">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s2">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s3">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s3">
																	</div>
																</div>
														    </fieldset>
														    <!-- step 3-->
														    <fieldset class="tab-pane" id="inverse-tab3">
																<div class="control-group">
																	<label class="control-label" for="s4">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s4">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s5">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s5">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s6">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s6">
																	</div>
																</div>
														    </fieldset>
														    <!-- step 4-->
														    <fieldset class="tab-pane" id="inverse-tab4">
																<div class="control-group">
																	<label class="control-label" for="s7">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s7">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s8">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s8">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s9">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s9">
																	</div>
																</div>
														    </fieldset>
														    <!-- step 5-->
														    <fieldset class="tab-pane" id="inverse-tab5">
																<div class="control-group">
																	<label class="control-label" for="s10">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s10">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s11">Sample Input</label>
																	<div class="controls">
																		<input type="text" class="span12" id="s11">
																	</div>
																</div>
																<div class="control-group">
																	<label class="control-label" for="s12">Sample Input</label>
																	<div class="controls">
																		