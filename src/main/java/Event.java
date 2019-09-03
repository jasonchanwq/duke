public class Event extends Task {

    String event;
    public Event(String name, String event){
        super(name);//super calls the parent class constructor
        this.event=event;
    }

    @Override
    public String toString() {
        return "[E]["+showDoneStatus()+"]"+ getName() + " (at: "+event+")";
    }
}
