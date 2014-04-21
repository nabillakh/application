<!DOCTYPE html>
<%@ page import="application.MailService" %>
<%
    def myService = grailsApplication.classLoader.loadClass('application.MailService').newInstance()
%>
  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
  </head>

 
 <g:render template="/menues/mainleft" />		
<div id="page-content">
					<!-- page header -->
					<h1 id="page-header"> Effectif  </h1>	
					
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							

							<!-- row-fluid -->
							
							<div class="row-fluid">
								<article class="span12">
                                                                   
									<!-- new widget -->
									<table>
									<!-- new widget -->
									<tr><td style=" width:500px;"><div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Fiche de l'Ordonnancement : </h2>                           
									    </header>
									    <!-- wrap div -->
									    <div>
									    
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                <center>
                                                                                    
                                                                                                                     <g:if test="${effectifInstance?.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="nom">
                                                                                   <g:message code="Effectif.nom.label" default="Nom : " /><g:fieldValue bean="${effectifInstance}" field="nom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                    <g:if test="${effectifInstance?.prenom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="nom">
                                                                                   <g:message code="Effectif.prenom.label" default="Prenom : " /><g:fieldValue bean="${effectifInstance}" field="prenom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                     
                                                                                    <g:if test="${effectifInstance?.equipe}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="equipe">
                                                                                   <g:message code="effectif.equipe.label" default="Equipe : " /><g:fieldValue bean="${effectifInstance}" field="equipe"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                     
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="equipe">
                                                                                   <g:message code="effectif.accountExpired.label" default="Compte expiré : " /><g:fieldValue bean="${effectifInstance}" field="accountExpired"/>
                                                                                  </label>
                                                                                </div>
                                                                                 
                                                                                
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="accountLocked">
                                                                                   <g:message code="effectif.accountLocked.label" default="Compte bloqué : " /><g:fieldValue bean="${effectifInstance}" field="accountLocked"/>
                                                                                  </label>
                                                                                </div>
                                                                                 
                                                                                 
                                                                               
                                                                                
                                                                                  </center>
                                                                                </div>
                                                                              
                                                                              
                                                                              
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div></td>
                                                                          <td style=" width:500px;"><div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Effectif : </h2>                           
									    </header>
									    <!-- wrap div -->
									    <div>
									    
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
                                                                                <center>
                                                                                    
                                                                                    
                                                                                    <g:if test="${effectifInstance?.nom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="nom">
                                                                                   <g:message code="Effectif.nom.label" default="Nom : " /><g:fieldValue bean="${effectifInstance}" field="nom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                    <g:if test="${effectifInstance?.prenom}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="nom">
                                                                                   <g:message code="Effectif.prenom.label" default="Prenom : " /><g:fieldValue bean="${effectifInstance}" field="prenom"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                      
                                                                                    <g:if test="${effectifInstance?.equipe}">
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="equipe">
                                                                                   <g:message code="effectif.equipe.label" default="Equipe : " /><g:fieldValue bean="${effectifInstance}" field="equipe"/>
                                                                                  </label>
                                                                                </div>
                                                                                 </g:if>
                                                                                     
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="equipe">
                                                                                   <g:message code="effectif.accountExpired.label" default="Compte expiré : " /><g:fieldValue bean="${effectifInstance}" field="accountExpired"/>
                                                                                  </label>
                                                                                </div>
                                                                             
                                                                                
                                                                                <div class="control-group"style=" text-align: left;">
                                                                                  <label class="control-label"  for="accountLocked">
                                                                                   <g:message code="effectif.accountLocked.label" default="Compte bloqué : " /><g:fieldValue bean="${effectifInstance}" field="accountLocked"/>
                                                                                  </label>
                                                                                </div>
                                                                              
                                                                                 
                                                                               
                                                                                
                                                                                  </center>
                                                                                </div>
                                                                              
                                                                              
                                                                              
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div></td></tr></table>
                                                              
                                                                   
                                            <g:link  action="ressource" controller="administration"  class="btn medium">Retour</g:link>                                 
                                                                            
                                                                      
							
<g:render template="/menues/mainright" />