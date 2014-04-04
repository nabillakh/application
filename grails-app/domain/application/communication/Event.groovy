package application.communication

class Event {

    String title
    String location
    String description

    Date startTime
    Date endTime


    static constraints = {
        title(nullable: false, blank: false)
        location(nullable: true, blank:  true)
        description(nullable: true, blank: true)
        startTime(nullable: false)
        endTime(required: true, nullable: false, validator: {val, obj -> val > obj.startTime} )
    }
}