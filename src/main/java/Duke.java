/**
 * Duke.java
 * @author Chan Wei Qiang Jason
 */
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
            cinLine = s.nextLine();
            int i = cinLine.indexOf(' ');//checks if the input is one word
            parser.parseCommand(cinLine,tasks,ui,storage,i);
            isExit=parser.getIsExit();
        }
    }
}