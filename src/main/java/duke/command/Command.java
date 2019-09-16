package duke.command;

import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public abstract class Command {
    String variable;
    boolean isExit = false;

    public Command(String variable) {
        this.variable = variable;
    }
    public boolean getIsExit() {
        return isExit;
    }
    public abstract void execute (TaskList tasks, Ui ui, Storage storage);

}
