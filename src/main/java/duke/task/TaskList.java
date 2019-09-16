package duke.task;

import java.util.ArrayList;

public class TaskList{

    public ArrayList<Task> tasks;
    public TaskList(ArrayList<Task> tasks) { this.tasks = tasks; }
    public TaskList() {
        tasks = new ArrayList<>();
    }
    public ArrayList<Task> getTaskList() {
        return tasks;
    }
    public int getTaskListSize() {
        return tasks.size();
    }
    public String getTaskName(int j){
        return tasks.get(j).getName();
    }
    public String getTask(int j){
        return tasks.get(j).toString();
    }
    public void doneTask(int index){
        int number = index;
        tasks.get(index-1).setDone();
    }
    public void deleteTask(int index){
        int number = index;
        tasks.remove(index-1);
    }
    public void addTask(Task t){
        tasks.add(t);
    }
}
