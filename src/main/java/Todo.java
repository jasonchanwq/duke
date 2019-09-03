public class Todo extends Task {

    public Todo(String name){
        super(name);//super calls the parent class constructor
    }

    @Override
    public String toString() {
        return "[T]["+showDoneStatus()+"]"+ getName();
    }
}
