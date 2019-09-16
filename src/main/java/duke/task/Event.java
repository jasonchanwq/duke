package duke.task;

import java.time.LocalDateTime;

/**
 * duke.task.Event represents a event-type duke.task.Task
 * duke.task.Event is a child of duke.task.Task
 */
public class Event extends Task {

    protected LocalDateTime at;

    public Event(String name, LocalDateTime time){
        super(name);//super calls the parent class constructor
        this.at=time;
    }

    /**
     * Returns a string that represents the event timing when called
     * @return This returns the event timing
     */
    public LocalDateTime getEventAt(){
        return at;
    }
    public String showEventAt() {
        return getEventAt().format(outputFormatter);
    }
    /**
     * Returns a string that represents the object
     * @return This returns the task type, showDoneStatus and the name of object
     */
    @Override
    public String toString() {
        return "[E]["+showDoneStatus()+"]"+ getName() + " (at: "+showEventAt()+")";
    }
}
