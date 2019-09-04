public class TaskList extends Duke {// might have to remove extends
    public TaskList(){

    }
    public void doneTask(int index){
        int number = index;
        tasks.get(index-1).setDone();
    }
    public void deleteTask(int index){
        int number = index;
        tasks.remove(index-1);
    }
}
