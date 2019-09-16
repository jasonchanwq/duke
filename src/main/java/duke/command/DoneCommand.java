package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class DoneCommand extends Command {
    int index;

    public DoneCommand(String variable) {
        super(variable);

        /*
        if (variable is not positive int) {
            do something;
        }*/

        this.index = Integer.parseInt(variable);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        tasks.doneTask(index);
    }
}
