<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
  <td>
<g:link action="show" controller="Kanban" id="${kanbanInstance.id}">${kanbanInstance.nomKanban}</g:link>
</td>
<td>${kanbanInstance.getChargeAgenda()}</td>
<td>${kanbanInstance.getChargeAgenda()}</td>
<td>${kanbanInstance.getChargeAgenda()}</td>
<td>${kanbanInstance.getChargeAgenda()}</td>
<td>${kanbanInstance.getChargeAgenda()}</td>
</tr>