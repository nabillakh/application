
<input type="hidden"  name="monId"  value="${kanbanInstance?.id}">
<div class="control-group">
	<label for="nomKanban" class="control-label" >
		<g:message code="kanban.nomKanban.label" default="Nom du projet" />

	</label>
  <div class="controls"  size="16" >
	<g:textField name="nomKanban"  class="span12" value="${kanbanInstance?.nomKanban}" />

</div>
</div>


<div class="control-group">
	<label for="description" class="control-label" >
		<g:message code="kanban.description.label" default="Description" />

	</label>
  <div class="controls"  size="16" >
	<g:textField name="description" class="span12" value="${kanbanInstance?.description}" />

</div>
</div>


<div class="control-group">
  <label class="control-label" for="multiSelect">Chef de projet</label>
  <div class="controls"  size="16" >
	<g:select id="multiSelect" name="chefProjet"  value="${kanbanInstance.chefProjet?.id}"  from="${application.RH.Effectif.list()}" optionKey="id" required="" class="span12 with-search"/>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="multiSelect">Famille de projet</label>
  <div class="controls"  size="16" >
	<g:select id="multiSelect" name="famille" value="${kanbanInstance.famille?.id}" from="${application.PP.Famille.list()}" optionKey="id" required="" class="span12 with-search"/>
  </div>
</div>

<div class="control-group">
  <label class="control-label" for="multiSelect">sous famille</label>
  <div class="controls"  size="16" >
	<g:select id="multiSelect" name="ordo"  value="${kanbanInstance.ordo?.id}" from="${application.PP.Ordonnancement.list()}" optionKey="id" required="" class="span12 with-search"/>
  </div>
</div>

<div class="control-group">
  <label class="control-label">Date de lancement</label>

  <div class="controls" size="16" >
    <div class="input-append date" id="datepicker-js" data-date="${dateDeb}" data-date-format="dd/mm/yyyy">
      <input class="datepicker-input" size="16" type="text"  value="${dateDeb}" name="dateLancement" 
              placeholder="Select a date" />
      <span class="add-on"><i class="cus-calendar-2"></i></span>
    </div>
  </div>
</div>


<div class="control-group">
  <label class="control-label">Date de livraison prévisionnelle</label>

  <div class="controls" size="16" >
    <div class="input-append date" id="datepicker-js" data-date="${dateFin}" data-date-format="dd/mm/yyyy">
      <input class="datepicker-input" size="16" type="text"  value="${dateFin}" name="dateLivraison" 
              placeholder="Select a date" />
      <span class="add-on"><i class="cus-calendar-2"></i></span>
    </div>
  </div>
</div>

<div class="control-group">
	<label for="charge" class="control-label" >
		<g:message code="kanban.charge.label" default="Charge" />

	</label>
  <div class="controls"  size="16" >
	<g:field name="chargePlanifiee"  value="${kanbanInstance.chargePlanifiee}"  class="span12"  />

</div>
</div>
