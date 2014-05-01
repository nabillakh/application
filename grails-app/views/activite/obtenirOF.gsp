
<g:each in="${mesOF}" status="o" var="unOF">
  l'id est : ${unOF.kanban.id} et son nom est : ${unOF.kanban.nomKanban}
  <div class="control-group">
    <label class="control-label" for="nomPhase">Nom de l'activité</label>
    <div class="controls">
      ${unOF.phase.nom}
    </div>
    <label class="control-label" for="nomPhase">Charge</label>
    <div class="controls">
      ${unOF.chargePlanifiee}
    </div>
    <label class="control-label" for="nomPhase">Ressources</label>
    <div class="controls">
      ${unOF.affectes.nom}
    </div>
  </div>

  </g:each>





