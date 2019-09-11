import java.time.format.DateTimeFormatter;
import java.util.Locale;

public abstract class Task {
    protected String name;
    protected boolean isDone;
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm", Locale.ENGLISH);

    //constructor method
    Task(String name){
        this.name = name;
    }

    /**
     * Return the name of the task when called.
     * @return The name of the task.
     */
    public String getName() {
        return name;
    }

    /**
     * Used to set the name of the task.
     * @param name The name of the task.
     */
    public void setName(String name) {
        this.name = name;
        this.isDone = false;
    }

    /**
     * Used to set the isDone to true.
     */
    public void setDone(){
        this.isDone = true;
    }

    /**
     * Returns the status of the task, ✓ if the task is done, ✗ if the task is not done
     * @return The showDoneStatus of the task
     */
    public String showDoneStatus(){
        return isDone?"✓":"✗";
    }
}


