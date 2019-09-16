package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class ListCommand extends Command {

    public ListCommand(String variable) {
        super(variable);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        for (int j = 0; j < tasks.getTaskListSize(); j++) {
            System.out.println("    " + (j + 1) + "." + tasks.getTask(j));
        }

//        ui.showTasks(tasks);
    }
}