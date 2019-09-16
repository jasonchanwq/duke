package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class ByeCommand extends Command {

    public ByeCommand(String variable) {
        super(variable);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        isExit=true;
        storage.saveTaskList(tasks.getTaskList());
        ui.showBye();

//        ui.showTasks(tasks);
    }
}