package application.communication

import org.joda.time.DateTime
import org.joda.time.Minutes

class Event {

    String title
    String location
    String description

    Date startTime
    Date endTime
    
    
    
    static transients = ['durationMinutes']


    static constraints = {
        title(nullable: false, blank: false)
        location(nullable: true, blank:  true)
        description(nullable: true, blank: true)
        startTime(nullable: false)
        endTime(required: true, nullable: false, validator: {val, obj -> val > obj.startTime} )
       
        
    }

    public int getDurationMinutes() {
        Minutes.minutesBetween(new DateTime(startTime), new DateTime(endTime)).minutes
    }

}