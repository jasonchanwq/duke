package duke.task;

import java.time.LocalDateTime;

/**
 * duke.task.Deadline represents a deadline-type duke.task.Task
 * duke.task.Deadline is a child of duke.task.Task
 */
public class Deadline extends Task {

    protected LocalDateTime dateBy;

    public Deadline(String name, LocalDateTime deadline){
        super(name);
        this.dateBy =deadline;
    }

    /**
     * Returns the date of the deadline
     * @return The dateBy of the dateline
     */
    public LocalDateTime getDateBy() {
        return dateBy;
    }

    /**
     * Sets the date of the deadline
     * @param dateBy This is the dateBy in d/MM/yyyy HHmm
     */
    public void setDateBy(LocalDateTime dateBy) {
        this.dateBy = dateBy;
    }

    /**
     * Returns the date of the deadline in d/MM/yyyy HHmm format
     * @return The date of the deadline in d/MM/yyyy HHmm format
     */
    public String showDateBy() {
        return getDateBy().format(outputFormatter);
    }
    /**
     * Returns a string that represents the object
     * @return This returns the task type, showDoneStatus and the name of object
     */
    @Override
    public String toString() {
        return "[D]["+showDoneStatus()+"]"+ getName() + " (by: "+ dateBy.format(outputFormatter)+")";
    }
}
