<div id="popupEventForm" class="modal hide" style="display: none;">
   <div class="modal-header"><h3>Add new event</h3></div>
  <div class="modal-body">
    <form id="EventForm" class="well">
        <input type="hidden" id="eventID">
        <label>Event title</label>
        <input type="text" id="eventTitle" placeholder="Title here"><br />
        <label>Scheduled date</label>
        <input type="text" id="eventDate"><br />
        <label>Scheduled time</label>
        <input type="text" id="eventTime"><br />
        <label>Appointment length (minutes)</label>
        <input type="text" id="eventDuration" placeholder="15"><br />
    </form>
</div>
  <div class="modal-footer">
    <button type="button" id="btnPopupCancel" data-dismiss="modal" class="btn">Cancel</button>
    <button type="button" id="btnPopupSave" data-dismiss="modal" class="btn btn-primary">Save event</button>
  </div>
</div> 