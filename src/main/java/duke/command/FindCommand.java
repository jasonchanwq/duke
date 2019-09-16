package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class FindCommand extends Command {

    public FindCommand(String variable) {
        super(variable);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        for (int j = 0; j < tasks.getTaskListSize(); j++) {
            String find = tasks.getTaskName(j);   //very important
            int k = find.indexOf(variable);
            if (k != -1) {
                System.out.println("    " + (j + 1) + "." + tasks.getTask(j));
            }
        }
    }
}