
<%@ page import="application.PP.OF" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'OF.label', default: 'OF')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-OF" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-OF" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="charge" title="${message(code: 'OF.charge.label', default: 'Charge')}" />
					
						<g:sortableColumn property="dateDebutPlanifie" title="${message(code: 'OF.dateDebutPlanifie.label', default: 'Date Debut Planifie')}" />
					
						<g:sortableColumn property="dateFinPlanifie" title="${message(code: 'OF.dateFinPlanifie.label', default: 'Date Fin Planifie')}" />
					
						<th><g:message code="OF.kanban.label" default="Kanban" /></th>
					
						<th><g:message code="OF.phase.label" default="Phase" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${OFInstanceList}" status="i" var="OFInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${OFInstance.id}">${fieldValue(bean: OFInstance, field: "charge")}</g:link></td>
					
						<td><g:formatDate date="${OFInstance.dateDebutPlanifie}" /></td>
					
						<td><g:formatDate date="${OFInstance.dateFinPlanifie}" /></td>
					
						<td>${fieldValue(bean: OFInstance, field: "kanban")}</td>
					
						<td>${fieldValue(bean: OFInstance, field: "phase")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${OFInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
