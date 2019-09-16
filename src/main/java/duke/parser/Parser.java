package duke.parser;

import duke.command.*;
import duke.exception.DukeException;
import duke.ui.Ui;

public class Parser {
    boolean isExit=false;
    public Parser() {
    }

    public Command parseCommand(String cin, Ui ui) throws DukeException {
        String commandWord = getFirstWord(cin," ");
        String variable = getCinLessFirstWord(cin," ");
        switch (commandWord) {
        case "list":
            return new ListCommand(variable);
        case "bye":
            return new ByeCommand(variable);
        case "done":
            return new DoneCommand(variable);
        case "find":
            return new FindCommand(variable);
        case "delete":
            return new DeleteCommand(variable);
        case "todo":
        case "deadline":
        case "event":
            return new AddCommand(variable,commandWord);
        default:
            ui.showUnknownCommand();
            throw new DukeException("");
        }
    }

    public String getFirstWord(String cinLine, String delete){
        String str = cinLine;
        String[] arrOfStr = str.split(delete, 2);
        return arrOfStr[0];
    }
    public String getCinLessFirstWord(String cinLine, String delete){
        String str = cinLine;
        String[] arrOfStr = str.split(delete, 2);
        return arrOfStr.length > 1 ? arrOfStr[1] : "";
    }

}
