/**
 * Duke.java
 * @author Chan Wei Qiang Jason
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Duke {
    protected Ui ui;
    protected TaskList tasks;

    //constructor method
    public Duke(){
        ui = new Ui();
        tasks = new TaskList();
    }

    //main method
    public static void main(String[] args){
        Duke duke = new Duke();
        duke.run();
    }

    private void run() {
        Storage storage = new Storage();
        Parser parser = new Parser();
        ui.showWelcome();
        //storage.loadTask();
        Scanner s = new Scanner(System.in);
        String cinLine=" ";
        while(!cinLine.equals("bye")){
            cinLine = s.nextLine();
            int i = cinLine.indexOf(' ');//if (i==-1) or use if(i!=-1)

            if(i==-1)   //meaning the input consists of a single word
            {
                singleWordEntered(cinLine);
            }

            else    //meaning the input consists of more than a word
            {

                    //String cinFirstWord = cinLine.substring(0,i);
                    //String cinLineLessFirstWord = cinLine.substring(i+1);//less SPACE
                    String cinFirstWord = parser.getFirstWord(cinLine);
                    String cinLineLessFirstWord = parser.getCinLessFirstWord(cinLine);


                    switch (cinFirstWord) {
                        case "done": {
                            int number = Integer.parseInt(cinLineLessFirstWord);
                            //TaskList.getTaskList(number - 1).setDone();
                            tasks.doneTask(number);
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
        storage.saveTask();
    }

    public void singleWordEntered(String cinLine) {
        switch(cinLine){
            case "list":
                //method to print everything
                for(int j=0;j<tasks.getTaskListSize();j++){
                    System.out.println("    " + (j+1) + "." + tasks.getTask(j));// do not need .getName() and .showDoneStatus because of toString
                }
                break;
            case "bye":
                ui.showBye();
                break;
            default:
                ui.showUnknownCommand();
        }
    }
}


