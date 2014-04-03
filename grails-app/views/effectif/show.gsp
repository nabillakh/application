
<%@ page import="application.RH.Effectif" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'effectif.label', default: 'Effectif')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-effectif" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-effectif" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list effectif">
			
				<g:if test="${effectifInstance?.username}">
				<li class="fieldcontain">
					<span id="username-label" class="property-label"><g:message code="effectif.username.label" default="Username" /></span>
					
						<span class="property-value" aria-labelledby="username-label"><g:fieldValue bean="${effectifInstance}" field="username"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${effectifInstance?.password}">
				<li class="fieldcontain">
					<span id="password-label" class="property-label"><g:message code="effectif.password.label" default="Password" /></span>
					
						<span class="property-value" aria-labelledby="password-label"><g:fieldValue bean="${effectifInstance}" field="password"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${effectifInstance?.mailEffectif}">
				<li class="fieldcontain">
					<span id="mailEffectif-label" class="property-label"><g:message code="effectif.mailEffectif.label" default="Mail Effectif" /></span>
					
						<span class="property-value" aria-labelledby="mailEffectif-label"><g:fieldValue bean="${effectifInstance}" field="mailEffectif"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${effectifInstance?.nom}">
				<li class="fieldcontain">
					<span id="nom-label" class="property-label"><g:message code="effectif.nom.label" default="Nom" /></span>
					
						<span class="property-value" aria-labelledby="nom-label"><g:fieldValue bean="${effectifInstance}" field="nom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${effectifInstance?.prenom}">
				<li class="fieldcontain">
					<span id="prenom-label" class="property-label"><g:message code="effectif.prenom.label" default="Prenom" /></span>
					
						<span class="property-value" aria-labelledby="prenom-label"><g:fieldValue bean="${effectifInstance}" field="prenom"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${effectifInstance?.equipe}">
				<li class="fieldcontain">
					<span id="equipe-label" class="property-label"><g:message code="effectif.equipe.label" default="Equipe" /></span>
					
						<span class="property-value" aria-labelledby="equipe-label"><g:link controller="equipe" action="show" id="${effectifInstance?.equipe?.id}">${effectifInstance?.equipe?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${effectifInstance?.accountExpired}">
				<li class="fieldcontain">
					<span id="accountExpired-label" class="property-label"><g:message code="effectif.accountExpired.label" default="Account Expired" /></span>
					
						<span class="property-value" aria-labelledby="accountExpired-label"><g:formatBoolean boolean="${effectifInstance?.accountExpired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${effectifInstance?.accountLocked}">
				<li class="fieldcontain">
					<span id="accountLocked-label" class="property-label"><g:message code="effectif.accountLocked.label" default="Account Locked" /></span>
					
						<span class="property-value" aria-labelledby="accountLocked-label"><g:formatBoolean boolean="${effectifInstance?.accountLocked}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${effectifInstance?.enabled}">
				<li class="fieldcontain">
					<span id="enabled-label" class="property-label"><g:message code="effectif.enabled.label" default="Enabled" /></span>
					
						<span class="property-value" aria-labelledby="enabled-label"><g:formatBoolean boolean="${effectifInstance?.enabled}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${effectifInstance?.passwordExpired}">
				<li class="fieldcontain">
					<span id="passwordExpired-label" class="property-label"><g:message code="effectif.passwordExpired.label" default="Password Expired" /></span>
					
						<span class="property-value" aria-labelledby="passwordExpired-label"><g:formatBoolean boolean="${effectifInstance?.passwordExpired}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:effectifInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${effectifInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
