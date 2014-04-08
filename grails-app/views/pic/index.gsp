
<%@ page import="application.pilotage.Pic" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pic.label', default: 'Pic')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pic" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pic" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dateVersion" title="${message(code: 'pic.dateVersion.label', default: 'Date Version')}" />
					
						<g:sortableColumn property="dateMaj" title="${message(code: 'pic.dateMaj.label', default: 'Date Maj')}" />
					
						<g:sortableColumn property="annee" title="${message(code: 'pic.annee.label', default: 'Annee')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${picInstanceList}" status="i" var="picInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${picInstance.id}">${fieldValue(bean: picInstance, field: "dateVersion")}</g:link></td>
					
						<td><g:formatDate date="${picInstance.dateMaj}" /></td>
					
						<td>${fieldValue(bean: picInstance, field: "annee")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${picInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
