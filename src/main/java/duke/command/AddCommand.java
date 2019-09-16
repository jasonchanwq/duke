package duke.command;

import duke.storage.Storage;
import duke.task.*;
import duke.ui.Ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class AddCommand extends Command {

    String commandWord;

    public AddCommand(String variable,String commandWord) {
        super(variable);
        this.commandWord = commandWord;
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage){
        int j;
        switch (commandWord) {
        case "todo":
            if (variable.length() == 0) {
                ui.empty("todo");
            } else {
                Task task = new Todo(variable);
                tasks.addTask(task);
                ui.showListSize(tasks.getTaskListSize());
            }
            break;

        case "deadline":
            if (variable.length() == 0) {
                ui.empty("deadline");
            }
            j = variable.indexOf("/by");

            try {
                String cinDeadline = variable.substring(j + 4);
                String cinDeadlineLessDate = variable.substring(0, j - 1);//less space

                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm", Locale.ENGLISH);
                LocalDateTime date1 = LocalDateTime.parse(cinDeadline, inputFormatter);
                Task task = new Deadline(cinDeadlineLessDate, date1);
                tasks.addTask(task);
                ui.showListSize(tasks.getTaskListSize());
            } catch (StringIndexOutOfBoundsException ex) {
                ui.showNoDeadlineDetected();
            }
            break;
        case "event": {
            if (variable.length() == 0) {
                ui.empty("event");
            }
            j = variable.indexOf("/at");
            try {
                String cinEvent = variable.substring(j + 4);
                String cinEventLessDate = variable.substring(0, j - 1);//less space
                DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm", Locale.ENGLISH);
                LocalDateTime date1 = LocalDateTime.parse(cinEvent, inputFormatter);
                Task task = new Event(cinEventLessDate, date1);
                tasks.addTask(task);
                ui.showListSize(tasks.getTaskListSize());
            } catch (StringIndexOutOfBoundsException ex) {
                ui.showNoEventDetected();
            }
            break;
        }
        default:
            ui.showUnknownCommand();
            break;
        }
    }

//        ui.showTasks(tasks);

}