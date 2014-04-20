<%@ page import="application.PP.Kanban" %>


<div class="control-group">
	<label for="nomKanban" class="control-label" >
		<g:message code="kanban.nomKanban.label" default="Nom du projet" />
		
	</label>
	<g:textField name="nomKanban" value="${kanbanInstance?.nomKanban}"  class="span12"  />

</div>


<div class="control-group">
	<label for="description" class="control-label" >
		<g:message code="kanban.description.label" default="Description" />
		
	</label>
	<g:textField name="description" value="${kanbanInstance?.description}" class="span12"  />

</div>


<div class="control-group">
  <label class="control-label" for="multiSelect">Famille de projet</label>
  <div class="controls"  size="16" >
	<g:select multiple="multiple" id="multiSelect" name="famille.id" from="${application.PP.Famille.list()}" optionKey="id" required="" value="${kanbanInstance?.famille?.id}" class="span12 with-search"/>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="multiSelect">sous famille</label>
  <div class="controls"  size="16" >
	<g:select multiple="multiple" id="multiSelect" name="ordo.id" from="${application.PP.Ordonnancement.list()}" optionKey="id" required="" value="${kanbanInstance?.ordo?.id}" class="span12 with-search"/>
  </div>
</div>

<div class="control-group">
  <label class="control-label">Date de lancement</label>

  
  <div class="controls" size="16" >
    <div>
      <g:datePicker name="dateLancement" value="${kanbanInstance?.dateLancement}"
              default="${new Date()}" precision="day"  />
    </div>
    
    
     <p class="help-block">
      99/99/9999
    </p>
  </div>
</div>


<div class="control-group">
  <label class="control-label">Date de livraison prévisionnelle</label>

  
  <div class="controls" size="16" >
    <div>
            <g:datePicker name="dateFinPlanifie" value="${kanbanInstance?.dateFinPlanifie}"
              default="${new Date()}" precision="day"  />
    </div>
     <p class="help-block">
      99/99/9999
    </p>
  </div>
</div>

<div class="control-group">
	<label for="charge" class="control-label" >
		<g:message code="kanban.charge.label" default="Charge" />
		
	</label>
	<g:field name="chargePlanifiee" value="${fieldValue(bean: kanbanInstance, field: 'chargePlanifiee')}" class="span12"  />

</div>

