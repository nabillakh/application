<!DOCTYPE html>
<%@ page import="application.MailService" %>
<%
    def myService = grailsApplication.classLoader.loadClass('application.MailService').newInstance()
%>
  <head>
		<meta name="layout" content="main"/>
		<title>Sysprod</title>
                 <g:javascript library="jquery" plugin="jquery" />
  </head>

 <sec:ifLoggedIn>
 <g:render template="/menues/mainleft" />		
<div id="page-content">
    <div class="fluid-container">
						<section id="widget-grid" class="well light">
                                                  <div class="row-fluid">
                                                    <article class="span3">
    <img src="${request.contextPath}/img/start-icons/coucou.jpg" alt="" style="width: 160px; height: 160px;">
    
                                                    </article>
                                                    <article class="span9">
                                                      
                                                      <center>
    <h4>${effectifInstance?.prenom} ${effectifInstance?.nom}</h4> 
    <h4> Equipe: ${effectifInstance?.equipe.nom}</h4>
    
    <div id="start">
      <ul>
        <li>
        <a href="javascript:voirJournal(${effectifInstance.id})" title="">
          <img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
          <span>Journal</span>
        </a>
      </li>
      
        <li>
          
        <a href="javascript:voirProjets(${effectifInstance.id})" title="">
          <img src="${request.contextPath}/img/start-icons/orders.png" alt="">
          <span>Projets en cours</span>
        </a>
      </li>
      <li>
        
        <a href="javascript:void(0)" title="">
          <img src="${request.contextPath}/img/start-icons/stats.png" alt="">
          <span>Indicateurs</span>
        </a>
      </li>
      <li>
        <a href="javascript:void(0)" title="">
          <img src="${request.contextPath}/img/start-icons/mass.png" alt="">
          <span>Broadcast</span>
        </a>
      </li>
      <li>
        <a href="javascript:void(0)" title="">
          <img src="${request.contextPath}/img/start-icons/upgrade.png" alt="">
          <span>Service Upgrade</span>
        </a>
      </li>
      </ul>
      
    </div>
                                                      </center>
                                                    </article>
                                                  </div>
                                                  
                                                </section>
      <section>
      <div class="row-fluid">
        <article class="span12">
        
        <div id="temp">
          
      </div>
        
<div class="jarviswidget" id="contenu2" data-widget-collapsed="false">
        </div>
          <script type="text/javascript">
      <g:remoteFunction controller="message" action="obtenirMessageEffectif" update="contenu2"/>;
          </script>
        
        </article>       
        
      </div>
      </section>
      
      
									    <!-- end widget div -->
									</div>

							</div>
 
 
 <script>
                                                          function voirJournal(monId) {
                                                                 <g:remoteFunction controller="message" action="obtenirMessageEffectif" update="contenu2"/>;   
                                                          }        
                                                          function voirProjets(monId) {
                                                                 <g:remoteFunction controller="kanban" action="obtenirKanbanEffectif"   params ="\'effectif=\' + monId" update="contenu2"/>;   
                                                          }       
                                                          function gererOf(monId) {
                                                                    window.location = "gestionOf/"+monId;
                                                          }       
                                                          function supprimer(monId) {
                                                                    bootbox.confirm("'Voulez vous confirmer la suppression du projet?" , function(result) {
					 //console.log("Confirm result: "+result);
                                        
                                                                                   <g:remoteFunction controller = "kanban" action="delete"   params ="\'kanban=\' + monId" />
                                         					  // toastr.info("Confirm result: "+result);
                                                                                });
                                                          }                                                                                                                                    
                                                        </script>
				

<g:render template="/menues/mainright" />



 
</sec:ifLoggedIn>
  
  
  
  
  <sec:ifNotLoggedIn>
    <h2> <g:link  action="index" controller="login"> <font size="3" face="georgia" color="red"> Se connecter </font></g:link> <h2>
  </sec:ifNotLoggedIn>