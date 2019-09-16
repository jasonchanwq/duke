package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class DeleteCommand extends Command {
    int index;

    public DeleteCommand(String variable) {
        super(variable);

        /*
        if (variable is not positive int) {
            do something;
        }*/

        this.index = Integer.parseInt(variable);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        tasks.deleteTask(index);
    }
}