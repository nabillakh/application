<%@ page import="application.communication.Mail" %>



<div class="fieldcontain ${hasErrors(bean: mailInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="mail.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="author" name="author.id" from="${application.RH.Effectif.list()}" optionKey="id" required="" value="${mailInstance?.author?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mailInstance, field: 'message', 'error')} ">
	<label for="message">
		<g:message code="mail.message.label" default="Message" />
		
	</label>
	<g:textField name="message" value="${mailInstance?.message}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mailInstance, field: 'objet', 'error')} ">
	<label for="objet">
		<g:message code="mail.objet.label" default="Objet" />
		
	</label>
	<g:textField name="objet" value="${mailInstance?.objet}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: mailInstance, field: 'recepteur', 'error')} ">
	<label for="recepteur">
		<g:message code="mail.recepteur.label" default="Recepteur" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${mailInstance?.recepteur?}" var="r">
    <li><g:link controller="mailEffectif" action="show" id="${r.id}">${r?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="mailEffectif" action="create" params="['mail.id': mailInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'mailEffectif.label', default: 'MailEffectif')])}</g:link>
</li>
</ul>


</div>

