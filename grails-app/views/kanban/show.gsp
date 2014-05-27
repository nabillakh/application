<!DOCTYPE html>

  <head>
		<meta name="layout" content="main"/>
		<title>Gestion projet</title>
                <g:javascript library="jquery" plugin="jquery" />
  </head>

 
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
    <h4> Projet : ${kanbanInstance?.nomKanban} </h4> 
   <g:link  action="show" controller="Famille" id=" ${kanbanInstance.famille.id}"> <h4> Famille : ${kanbanInstance?.famille.nom}</h4></g:link>
    
    <div id="start">
      <ul>
        
      <li>
        <a href="javascript:information(${kanbanInstance.id})" title="Informations">
          <img src="${request.contextPath}/img/start-icons/mass.png" alt="">
          <span>Informations</span>
        </a>
      </li>
        <li>
        <a href="javascript:voirJournal(${kanbanInstance.id})" title="Journal">
          <img src="${request.contextPath}/img/start-icons/pending-message.png" alt="">
          <span>Journal</span>
        </a>
      </li>
      
        <li>
          
        <a href="javascript:voirProjets(${kanbanInstance.id})" title="Projets">
          <img src="${request.contextPath}/img/start-icons/orders.png" alt="">
          <span>Projets en cours</span>
        </a>
      </li>
      <li>
        
        <a href="javascript:voirIndicateurs(${kanbanInstance.id})" title="Indicateurs">
          <img src="${request.contextPath}/img/start-icons/stats.png" alt="">
          <span>Indicateurs</span>
        </a>
      </li>
      </ul>
      
    </div>
                                                      </center>
                                                    </article>
                                                  </div>
                                                  
      <div class="row-fluid">
        <article class="span12">
        
        <div id="temp">
          
      </div>
        
<div class="jarviswidget" id="contenu2" data-widget-collapsed="false">
        </div>
          <script type="text/javascript">
       <g:remoteFunction controller="kanban" action="information"   params ="\'kanban=\' + ${kanbanInstance.id}" update="contenu2"/>;
          </script>
        
        </article>       
        
      </div>
                                                </section>
      
      
      
									    <!-- end widget div -->
									</div>

							</div>
 
 
 <script>
                                                          function voirJournal(monId) {
                                                                 <g:remoteFunction controller="kanban" action="obtenirJournal"  params ="\'kanban=\' + monId" update="contenu2"/>;   
                                                          }        
                                                          function voirProjets(monId) {
                                                                 <g:remoteFunction controller="kanban" action="obtenirKanbanEffectif"   params ="\'effectif=\' + monId" update="contenu2"/>;   
                                                          }        
                                                          function voirIndicateurs(monId) {
                                                                 <g:remoteFunction controller="kanban" action="indicateurKanban"   params ="\'kanban=\' + monId" update="contenu2"/>;   
                                                          }        
                                                          function information(monId) {
                                                                 <g:remoteFunction controller="kanban" action="information"   params ="\'kanban=\' + monId" update="contenu2"/>;   
                                                          }  
                                                                                   
                                                  
                                                        </script>
 
 
                                                                        
                                                          
                                                        
                                                        				<!-- end main content -->
			
				<g:render template="/menues/mainright" />
