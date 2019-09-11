/**
 * Event represents a event-type Task
 * Event is a child of Task
 */

public class Event extends Task {

    String at;
    public Event(String name, String time){
        super(name);//super calls the parent class constructor
        this.at=time;
    }

    /**
     * Returns a string that represents the event timing when called
     * @return This returns the event timing
     */
    public String getEventAt(){
        return at;
    }
    /**
     * Returns a string that represents the object
     * @return This returns the task type, showDoneStatus and the name of object
     */
    @Override
    public String toString() {
        return "[E]["+showDoneStatus()+"]"+ getName() + " (at: "+at+")";
    }
}
