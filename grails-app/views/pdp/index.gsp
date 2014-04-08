
<%@ page import="application.pilotage.Pdp" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'pdp.label', default: 'Pdp')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-pdp" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-pdp" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dateVersion" title="${message(code: 'pdp.dateVersion.label', default: 'Date Version')}" />
					
						<g:sortableColumn property="dateMaj" title="${message(code: 'pdp.dateMaj.label', default: 'Date Maj')}" />
					
						<g:sortableColumn property="uniteActivite" title="${message(code: 'pdp.uniteActivite.label', default: 'Unite Activite')}" />
					
						<g:sortableColumn property="mois" title="${message(code: 'pdp.mois.label', default: 'Mois')}" />
					
						<th><g:message code="pdp.picFamille.label" default="Pic Famille" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${pdpInstanceList}" status="i" var="pdpInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${pdpInstance.id}">${fieldValue(bean: pdpInstance, field: "dateVersion")}</g:link></td>
					
						<td><g:formatDate date="${pdpInstance.dateMaj}" /></td>
					
						<td>${fieldValue(bean: pdpInstance, field: "uniteActivite")}</td>
					
						<td>${fieldValue(bean: pdpInstance, field: "mois")}</td>
					
						<td>${fieldValue(bean: pdpInstance, field: "picFamille")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${pdpInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
