
<%@ page import="application.RH.Effectif" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'effectif.label', default: 'Effectif')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-effectif" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-effectif" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="username" title="${message(code: 'effectif.username.label', default: 'Username')}" />
					
						<g:sortableColumn property="password" title="${message(code: 'effectif.password.label', default: 'Password')}" />
					
						<g:sortableColumn property="accountExpired" title="${message(code: 'effectif.accountExpired.label', default: 'Account Expired')}" />
					
						<g:sortableColumn property="accountLocked" title="${message(code: 'effectif.accountLocked.label', default: 'Account Locked')}" />
					
						<g:sortableColumn property="enabled" title="${message(code: 'effectif.enabled.label', default: 'Enabled')}" />
					
						<g:sortableColumn property="passwordExpired" title="${message(code: 'effectif.passwordExpired.label', default: 'Password Expired')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${effectifInstanceList}" status="i" var="effectifInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${effectifInstance.id}">${fieldValue(bean: effectifInstance, field: "username")}</g:link></td>
					
						<td>${fieldValue(bean: effectifInstance, field: "password")}</td>
					
						<td><g:formatBoolean boolean="${effectifInstance.accountExpired}" /></td>
					
						<td><g:formatBoolean boolean="${effectifInstance.accountLocked}" /></td>
					
						<td><g:formatBoolean boolean="${effectifInstance.enabled}" /></td>
					
						<td><g:formatBoolean boolean="${effectifInstance.passwordExpired}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${effectifInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
