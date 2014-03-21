<%@ page import="application.RH.Effectif" %>



<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="effectif.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${effectifInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="effectif.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${effectifInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="effectif.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${effectifInstance?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="effectif.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${effectifInstance?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="effectif.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${effectifInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: effectifInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="effectif.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${effectifInstance?.passwordExpired}" />

</div>

