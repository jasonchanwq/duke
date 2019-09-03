import java.util.Date;

public class Deadline extends Task {

    Date deadline;
    public Deadline(String name, Date deadline){
        super(name);//super calls the parent class constructor
        this.deadline=deadline;
    }

    @Override
    public String toString() {
        return "[D]["+showDoneStatus()+"]"+ getName() + " (by: "+deadline+")";
    }
}
