
<%@ page import="application.communication.Mail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'mail.label', default: 'Mail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-mail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-mail" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="mail.author.label" default="Author" /></th>
					
						<g:sortableColumn property="dateCreated" title="${message(code: 'mail.dateCreated.label', default: 'Date Created')}" />
					
						<g:sortableColumn property="message" title="${message(code: 'mail.message.label', default: 'Message')}" />
					
						<g:sortableColumn property="objet" title="${message(code: 'mail.objet.label', default: 'Objet')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${mailInstanceList}" status="i" var="mailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${mailInstance.id}">${fieldValue(bean: mailInstance, field: "author")}</g:link></td>
					
						<td><g:formatDate date="${mailInstance.dateCreated}" /></td>
					
						<td>${fieldValue(bean: mailInstance, field: "message")}</td>
					
						<td>${fieldValue(bean: mailInstance, field: "objet")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${mailInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
