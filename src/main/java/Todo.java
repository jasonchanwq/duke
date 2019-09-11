/**
 * Todo represents a todo-type Task
 * Todo is a child of Task
 */

public class Todo extends Task {

    Todo(String name){
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
