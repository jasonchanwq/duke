public class Ui {
    // instance fields
    String errorType;
    // constructor method

    public Ui(){
    }

    public void showWelcome(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");
    }
    public void showUnknownCommand(){
        System.out.println( "☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
    }

    public void showNoDeadlineDetected(){
        System.out.println("Sorry no /by detected for deadline!");
    }
    public void showNoEventDetected(){
        System.out.println("Sorry no /at detected for event!");
    }



}
