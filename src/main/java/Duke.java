import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Duke {
    //instance fields
    //test line for sourceTree
    String taskType;
    boolean checkbox;
    List<Task> tasks = new ArrayList<>(); //create list

    //constructor method
    public Duke(){
    }

    //main method
    public static void main(String[] args){
        Duke duke = new Duke();
        //Ui ui = new Ui();
        duke.run();
    }

    private void run() {
        Ui ui = new Ui();//try to move this up
        Storage storage = new Storage();
        Parser parser = new Parser();
        TaskList taskList = new TaskList();
        ui.showWelcome();
        //storage.loadTask();
        Scanner s = new Scanner(System.in);
        String cinLine=" ";
        while(!cinLine.equals("bye")){
            cinLine = s.nextLine();
            int i = cinLine.indexOf(' ');//if (i==-1) or use if(i!=-1)

            if(i==-1)   //meaning the input consists of a single word
            {
                switch(cinLine){
                    case "list":
                        //method to print everything
                        for(int j=0;j<tasks.size();j++){
                            System.out.println("    " + (j+1) + "." + tasks.get(j));// do not need .getName() and .showDoneStatus because of toString
                        }
                        break;
                    case "bye":
                        System.out.println("Thank you for using duke!");
                        break;
                    default:
                        ui.showUnknownCommand();
                }
            }

            else    //meaning the input consists of more than a word
            {
                try{
                    //String cinFirstWord = cinLine.substring(0,i);
                    //String cinLineLessFirstWord = cinLine.substring(i+1);//less SPACE
                    String cinFirstWord = parser.getFirstWord(cinLine);
                    String cinLineLessFirstWord = parser.getCinLessFirstWord(cinLine);


                if(cinFirstWord.equals("done")){
                    int number = Integer.parseInt(cinLineLessFirstWord);
                    tasks.get(number-1).setDone();
                }

                else if(cinFirstWord.equals("find")){
                    for(int j=0;j<tasks.size();j++){
                        String find = tasks.get(j).getName();   //very important
                        int k = find.indexOf(cinLineLessFirstWord);
                        if(k!=-1) {
                            System.out.println("    " + (j + 1) + "." + tasks.get(j));
                        }
                    }
                }

                else if(cinFirstWord.equals("delete")){
                    int number = Integer.parseInt(cinLineLessFirstWord);
                    tasks.remove(number-1);
                }

                else if(cinFirstWord.equals("todo")) {
                    if(cinLineLessFirstWord.length()==0){
                        System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");
                    }
                    Task task = new Todo(cinLineLessFirstWord);
                    tasks.add(task);
                    System.out.println("Now you have " + tasks.size() + " task(s) in the list");
                    //System.out.println("☹ OOPS!!! The description of a todo cannot be empty.");

                }
                else if(cinFirstWord.equals("deadline")) {
                    int j = cinLineLessFirstWord.indexOf("/by");

                    try{
                        String cinDeadline = cinLineLessFirstWord.substring(j+4);
                        String cinDeadlineLessDate = cinLineLessFirstWord.substring(0,j-1);//less space

                        String sDate1=cinDeadline;
                        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy HHmm", Locale.ENGLISH);
                        LocalDateTime date1 = LocalDateTime.parse(sDate1, inputFormatter);
                        Task task = new Deadline(cinDeadlineLessDate,date1);
                        tasks.add(task);
                        System.out.println("Now you have " + tasks.size() + " task(s) in the list");
                    }
                    catch(StringIndexOutOfBoundsException ex){
                        ui.showNoDeadlineDetected();
                    }
                }
                else if(cinFirstWord.equals("event")) {
                    int j = cinLineLessFirstWord.indexOf("/at");
                    try{
                        String cinEvent = cinLineLessFirstWord.substring(j+4);
                        String cinEventLessDate = cinLineLessFirstWord.substring(0,j-1);//less space

                        Task task = new Event(cinEventLessDate,cinEvent);
                        tasks.add(task);
                        System.out.println("Now you have " + tasks.size() + " task(s) in the list");
                    }
                    catch(StringIndexOutOfBoundsException ex){
                        ui.showNoEventDetected();
                    }
                }
                else{
                    ui.showUnknownCommand();
                }
                }
                catch (StringIndexOutOfBoundsException ex){
                System.out.println("☹ OOPS!!! The description cannot be empty.");
                }

            }
        }
        storage.saveTask();
        /////////////////////////////////////////////////////////////////
        /*
        try(FileWriter fileWriter = new FileWriter("duke.txt")) {
            //inherited method from java.io.Writer
            for(int j=0;j<tasks.size();j++) {
                fileWriter.write("    " + (j + 1) + "." + tasks.get(j));
                fileWriter.write(System.lineSeparator()); //new line
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        */
        /////////////////////////////////////////////////////////////////
    }
}


/*
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Duke {
*/

    /*
    String name;
    boolean isDone;
    String tickCross;

    public void Task(String description){
        name = taskName;
        isDone = false;
    }
    */
    /*
    public void addToDo(String toDoTask){
        name= taskName;
        isDone = false;
        System.out.println("    ____________________________________________________________");
        System.out.println("    Got it. I've added this task:");
        System.out.println("    [T][✗] "+name);
        System.out.println("    ____________________________________________________________");
    }
    public void addDeadline(String deadlineTask, String date){
        name= taskName;
        isDone = false;
    }
    public void addEvent(String eventTask, String date, String time){
        name= taskName;
        isDone = false;
    }
    */







    //public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        *//*
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");
        Scanner scanner;
        String clone = "";
        String clone2 = "";
        int clone_2;
        String state = "✗";

        List<String> EntryList = new ArrayList<String>(); //create list
        List<String> stateList = new ArrayList<String>(); //create list

        scanner = new Scanner(System.in);

        while(!clone.equals("bye"))
        {
            clone = scanner.next();// the cin equivalent for c++
            if(!clone.equals("list") && !clone.equals("done"))
            {
                EntryList.add(clone);
                stateList.add("✗");
            }

            if(clone.equals("done"))
            {
                System.out.println("1");
                clone2 = scanner.next();
                clone_2 = Integer.parseInt(clone2);
                stateList.set((clone_2-1),"✓");
                System.out.println("    ____________________________________________________________");
                System.out.println("    Nice! I've marked this task as done: ");
                System.out.println("    ["+ stateList.get(clone_2-1) + "] "+ EntryList.get(clone_2-1));
                System.out.println("    ____________________________________________________________");
            }
            else if(clone.equals("list"))
            {
                System.out.println("    ____________________________________________________________");
                for(int i=0;i<EntryList.size();i++){
                    System.out.println("    " + (i+1) + ".[" + stateList.get(i) + "] " + EntryList.get(i));
                }
                System.out.println("    ____________________________________________________________");
            }
            else if(!clone.equals("bye"))
            {
                System.out.println("    ____________________________________________________________");
                System.out.println("    added: " + clone);
                System.out.println("    ____________________________________________________________");
            }
            else
            {
                System.out.println("    ____________________________________________________________");
                System.out.println("    Bye. Hope to see you again soon!");
                System.out.println("    ____________________________________________________________");
            }
        }
    }
}*/
