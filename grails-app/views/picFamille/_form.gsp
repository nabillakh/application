<%@ page import="application.pilotage.PicFamille" %>



<div class="fieldcontain ${hasErrors(bean: picFamilleInstance, field: 'dateVersion', 'error')} ">
	<label for="dateVersion">
		<g:message code="picFamille.dateVersion.label" default="Date Version" />
		
	</label>
	<g:datePicker name="dateVersion" precision="day"  value="${picFamilleInstance?.dateVersion}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: picFamilleInstance, field: 'dateMaj', 'error')} ">
	<label for="dateMaj">
		<g:message code="picFamille.dateMaj.label" default="Date Maj" />
		
	</label>
	<g:datePicker name="dateMaj" precision="day"  value="${picFamilleInstance?.dateMaj}" default="none" noSelection="['': '']" />

</div>

<div class="fieldcontain ${hasErrors(bean: picFamilleInstance, field: 'famille', 'error')} required">
	<label for="famille">
		<g:message code="picFamille.famille.label" default="Famille" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="famille" name="famille.id" from="${application.PP.Famille.list()}" optionKey="id" required="" value="${picFamilleInstance?.famille?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: picFamilleInstance, field: 'pdp', 'error')} ">
	<label for="pdp">
		<g:message code="picFamille.pdp.label" default="Pdp" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${picFamilleInstance?.pdp?}" var="p">
    <li><g:link controller="pdp" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="pdp" action="create" params="['picFamille.id': picFamilleInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'pdp.label', default: 'Pdp')])}</g:link>
</li>
</ul>


</div>

<div class="fieldcontain ${hasErrors(bean: picFamilleInstance, field: 'uniteActivite', 'error')} required">
	<label for="uniteActivite">
		<g:message code="picFamille.uniteActivite.label" default="Unite Activite" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="uniteActivite" value="${fieldValue(bean: picFamilleInstance, field: 'uniteActivite')}" required=""/>

</div>

