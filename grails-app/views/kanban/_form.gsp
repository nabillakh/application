<%@ page import="application.PP.Kanban" %>


<div class="control-group">
	<label for="nomKanban" class="control-label" >
		<g:message code="kanban.nomKanban.label" default="Nom du projet" />
		
	</label>
  <div class="controls"  size="16" >
	<g:textField name="nomKanban"  class="span12"  />

</div>
</div>


<div class="control-group">
	<label for="description" class="control-label" >
		<g:message code="kanban.description.label" default="Description" />
		
	</label>
  <div class="controls"  size="16" >
	<g:textField name="description" class="span12"/>

</div>
</div>


<div class="control-group">
  <label class="control-label" for="multiSelect">Famille de projet</label>
  <div class="controls"  size="16" >
	<g:select id="multiSelect" name="famille" from="${application.PP.Famille.list()}" optionKey="id" required="" class="span12 with-search"/>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="multiSelect">sous famille</label>
  <div class="controls"  size="16" >
	<g:select id="multiSelect" name="ordo" from="${application.PP.Ordonnancement.list()}" optionKey="id" required="" class="span12 with-search"/>
  </div>
</div>

<div class="control-group">
  <label class="control-label">Date de lancement</label>

  
  <div class="controls" size="16" >
    <div>
      <g:field type="date" name="dateLancement" 
              default="${new Date()}" precision="day"  />
    </div>
  </div>
</div>


<div class="control-group">
  <label class="control-label">Date de livraison prévisionnelle</label>

  
  <div class="controls" size="16" >
    <div>
            <g:field type="date"  name="dateFinPlanifie" value="dateFinPlanifie"
              default="${new Date()}" precision="day"  />
    </div>
  </div>
</div>

<div class="control-group">
	<label for="charge" class="control-label" >
		<g:message code="kanban.charge.label" default="Charge" />
		
	</label>
  <div class="controls"  size="16" >
	<g:field name="chargePlanifiee"  class="span12"  />

</div>
</div>

