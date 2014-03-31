
<%@ page import="application.mail.MailEffectif" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mailEffectif.label', default: 'MailEffectif')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-mailEffectif" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-mailEffectif" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list mailEffectif">
			
				<g:if test="${mailEffectifInstance?.lu}">
				<li class="fieldcontain">
					<span id="lu-label" class="property-label"><g:message code="mailEffectif.lu.label" default="Lu" /></span>
					
						<span class="property-value" aria-labelledby="lu-label"><g:formatBoolean boolean="${mailEffectifInstance?.lu}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${mailEffectifInstance?.mail}">
				<li class="fieldcontain">
					<span id="mail-label" class="property-label"><g:message code="mailEffectif.mail.label" default="Mail" /></span>
					
						<span class="property-value" aria-labelledby="mail-label"><g:link controller="mail" action="show" id="${mailEffectifInstance?.mail?.id}">${mailEffectifInstance?.mail?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${mailEffectifInstance?.recepteur}">
				<li class="fieldcontain">
					<span id="recepteur-label" class="property-label"><g:message code="mailEffectif.recepteur.label" default="Recepteur" /></span>
					
						<span class="property-value" aria-labelledby="recepteur-label"><g:link controller="effectif" action="show" id="${mailEffectifInstance?.recepteur?.id}">${mailEffectifInstance?.recepteur?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:mailEffectifInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${mailEffectifInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
