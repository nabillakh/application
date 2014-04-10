<%@ page import="application.PP.Famille" %>



<div class="fieldcontain ${hasErrors(bean: familleInstance, field: 'chargeStandard', 'error')} required">
	<label for="chargeStandard">
		<g:message code="famille.chargeStandard.label" default="Charge Standard" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="chargeStandard" value="${fieldValue(bean: familleInstance, field: 'chargeStandard')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: familleInstance, field: 'nom', 'error')} ">
	<label for="nom">
		<g:message code="famille.nom.label" default="Nom" />
		
	</label>
	<g:textField name="nom" value="${familleInstance?.nom}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: familleInstance, field: 'ordo', 'error')} required">
	<label for="ordo">
		<g:message code="famille.ordo.label" default="Ordo" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="ordo" name="ordo.id" from="${application.PP.Ordonnancement.list()}" optionKey="id" required="" value="${familleInstance?.ordo?.id}" class="many-to-one"/>

</div>

