import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Parser {
    boolean isExit=false;
    public Parser(){
    }

    public boolean getIsExit() {
        return isExit;
    }

    public void parseCommand(String commandType, TaskList tasks, Ui ui, Storage storage, int i){
        if(i==-1) {
            switch (commandType) {
                case "list":
                    //method to print everything
                    for (int j = 0; j < tasks.getTaskListSize(); j++) {
                        System.out.println("    " + (j + 1) + "." + tasks.getTask(j));
                        //System.out.println("    " + (j+1) + "." + tasks.getTask(j));// do not need .getName() and .showDoneStatus because of toString
                    }
                    break;
                case "bye":
                    isExit=true;
                    storage.saveTaskList(tasks.getTaskList());
                    ui.showBye();
                    break;
                default:
                    ui.showUnknownCommand();
            }
        }
        else{
            String cinFirstWord = getFirstWord(commandType," ");
            String cinLineLessFirstWord = getCinLessFirstWord(commandType," ");

            switch (cinFirstWord) {
                case "done": {
                    Command command = new DoneCommand();
                    command.execute(commandType,tasks,ui,storage,i);

//                    int number = Integer.parseInt(cinLineLessFirstWord);
//                    tasks.doneTask(number);

                    break;
                }
                case "find":
                    for (int j = 0; j < tasks.getTaskListSize(); j++) {
                        String find = tasks.getTaskName(j);   //very important
                        int k = find.indexOf(cinLineLessFirstWord);
                        if (k != -1) {
                            System.out.println("    " + (j + 1) + "." + tasks.getTask(j));
                        }
                    }
                    break;
                case "delete": {
                    int number = Integer.parseInt(cinLineLessFirstWord);
                    tasks.deleteTask(number);
                    break;
                }
                case "todo":
                    if (cinLineLessFirstWord.length() == 0) {
                        ui.empty("todo");
                    } else {
                        Task task = new Todo(cinLineLessFirstWord);
                        tasks.addTask(task);
                        ui.showListSize(tasks.getTaskListSize());
                    }

                    break;
                case "deadline": {
                    if (cinLineLessFirstWord.length() == 0) {
                        ui.empty("deadline");
                    }
                    int j = cinLineLessFirstWord.indexOf("/by");

                    try {
                        String cinDeadline = cinLineLessFirstWord.substring(j + 4);
                        String cinDeadlineLessDate = cinLineLessFirstWord.substring(0, j - 1);//less space

                        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm", Locale.ENGLISH);
                        LocalDateTime date1 = LocalDateTime.parse(cinDeadline, inputFormatter);
                        Task task = new Deadline(cinDeadlineLessDate, date1);
                        tasks.addTask(task);
                        ui.showListSize(tasks.getTaskListSize());
                    } catch (StringIndexOutOfBoundsException ex) {
                        ui.showNoDeadlineDetected();
                    }
                    break;
                }
                case "event": {
                    if (cinLineLessFirstWord.length() == 0) {
                        ui.empty("event");
                    }
                    int j = cinLineLessFirstWord.indexOf("/at");
                    try {
                        String cinEvent = cinLineLessFirstWord.substring(j + 4);
                        String cinEventLessDate = cinLineLessFirstWord.substring(0, j - 1);//less space
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
    }

    public String getFirstWord(String cinLine, String delete){
        String str = cinLine;
        String[] arrOfStr = str.split(delete, 2);
        return arrOfStr[0];
    }
    public String getCinLessFirstWord(String cinLine, String delete){
        String str = cinLine;
        String[] arrOfStr = str.split(delete, 2);
        return arrOfStr[1];
    }

}
