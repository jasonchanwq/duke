import java.time.LocalDateTime;

public class Deadline extends Task {

    private LocalDateTime dateBy;
    public Deadline(String name, LocalDateTime deadline){
        super(name);//super calls the parent class constructor
        this.dateBy =deadline;
    }

    public LocalDateTime getDateBy() {
        return dateBy;
    }

    public void setDateBy(LocalDateTime dateBy) {
        this.dateBy = dateBy;
    }

    public String showDateBy() {
        return getDateBy().format(outputFormatter);
    }

    @Override
    public String toString() {
        return "[D]["+showDoneStatus()+"]"+ getName() + " (by: "+ dateBy.format(outputFormatter)+")";
    }
}
