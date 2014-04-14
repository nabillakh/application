<g:if test="${countkanban == 1}"> 
      <g:set var="countkanban" value="$countkanban+1}" />
<div id='external-events'>										<!-- calnedar container -->
  <h4>Kanbans</h4>             
 <g:each in="${meskanbans}" status="i" var="meskanbansInstance">                                                                                           
 <div class='external-event'>${meskanbansInstance.nomKanban}</div>
 </g:each>

 </div>
 </g:if>
