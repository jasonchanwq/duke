public class Ui {

    public Ui(){
    }

    /**
     * Prints the welcome message
     */
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
    public void showListSize(int size){ System.out.println("Now you have " + size + " task(s) in the list");}
    /**
     * Prints error message for unknown command.
     */
    public void showUnknownCommand(){ System.out.println( "☹ OOPS!!! I'm sorry, but I don't know what that means :-("); }

    /**
     * Prints error message for when deadline not detected.
     */
    public void showNoDeadlineDetected(){
        System.out.println("Sorry no /by detected for deadline!");
    }

    /**
     * Prints error message for when event not detected
     */
    public void showNoEventDetected(){
        System.out.println("Sorry no /at detected for event!");
    }

    public void empty(String message){System.out.println("☹ OOPS!!! The description of a "+message+" cannot be empty.");}

    public void showBye(){ System.out.println("Thank you for using duke!");
    }



}
