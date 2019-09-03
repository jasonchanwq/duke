public abstract class Task {
    private String name;
    private boolean isDone;

    /**
     * constuctor method
     */
    public Task(String name){
        this.name = name;   // this. refers to instance variable
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {//to change name
        this.name = name;
    }

    public void setDone(){
        this.isDone = true;
    }

    public String showDoneStatus(){
        return isDone?"✓":"✗";
    }
}


