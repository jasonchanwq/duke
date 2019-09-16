package duke.task;

/**
 * duke.task.Todo represents a todo-type duke.task.Task
 * duke.task.Todo is a child of duke.task.Task
 */

public class Todo extends Task {

    public Todo(String name){
        super(name);//super calls the parent class constructor
    }

    /**
     * Returns a string that represents the object
     * @return This returns the task type, showDoneStatus and the name of object
     */
    @Override
    public String toString() {
        return "[T]["+showDoneStatus()+"]"+ getName();
    }
}
