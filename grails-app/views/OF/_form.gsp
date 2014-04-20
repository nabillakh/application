<%@ page import="application.PP.OF" %>



<div class="fieldcontain ${hasErrors(bean: OFInstance, field: 'chargePlanifiee', 'error')} ">
	<label for="chargePlanifiee">
		<g:message code="OF.chargePlanifiee.label" default="Charge Planifiee" />
		
	</label>
	<g:field name="chargePlanifiee" value="${fieldValue(bean: OFInstance, field: 'chargePlanifiee')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: OFInstance, field: 'affectes', 'error')} ">
	<label for="affectes">
		<g:message code="OF.affectes.label" default="Affectes" />
		
	</label>
	<g:select name="affectes" from="${application.RH.Effectif.list()}" multiple="multiple" optionKey="id" size="5" value="${OFInstance?.affectes*.id}" class="many-to-many"/>

</div>

<div class="fieldcontain ${hasErrors(bean: OFInstance, field: 'dateDebutPlanifie', 'error')} required">
	<label for="dateDebutPlanifie">
		<g:message code="OF.dateDebutPlanifie.label" default="Date Debut Planifie" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateDebutPlanifie" precision="day"  value="${OFInstance?.dateDebutPlanifie}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: OFInstance, field: 'dateFinPlanifie', 'error')} required">
	<label for="dateFinPlanifie">
		<g:message code="OF.dateFinPlanifie.label" default="Date Fin Planifie" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateFinPlanifie" precision="day"  value="${OFInstance?.dateFinPlanifie}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: OFInstance, field: 'kanban', 'error')} required">
	<label for="kanban">
		<g:message code="OF.kanban.label" default="Kanban" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="kanban" name="kanban.id" from="${application.PP.Kanban.list()}" optionKey="id" required="" value="${OFInstance?.kanban?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: OFInstance, field: 'phase', 'error')} required">
	<label for="phase">
		<g:message code="OF.phase.label" default="Phase" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="phase" name="phase.id" from="${application.PP.Phase.list()}" optionKey="id" required="" value="${OFInstance?.phase?.id}" class="many-to-one"/>

</div>

