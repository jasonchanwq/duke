/**
 * Duke.java
 * @author Chan Wei Qiang Jason
 */
import duke.command.Command;
import duke.exception.DukeException;
import duke.parser.Parser;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

import java.util.*;

public class Duke {
    protected Ui ui;
    protected TaskList tasks;
    protected Storage storage;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadTaskList());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public static void main(String[] args){
        new Duke("data/tasks.txt").run();
    }

    private void run() {
        Parser parser = new Parser();
        ui.showWelcome();
        Scanner s = new Scanner(System.in);
        String cinLine;
        boolean isExit = false;
        while(!isExit){
            try {
                cinLine = s.nextLine();
                Command command = parser.parseCommand(cinLine, ui);
                command.execute(tasks,ui,storage);
                isExit=command.getIsExit();
            } catch (DukeException e) {
                //print error
            }
        }
    }
}