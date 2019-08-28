import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        /*
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        */
        System.out.println("    ____________________________________________________________");
        System.out.println("    Hello! I'm Duke");
        System.out.println("    What can I do for you?");
        System.out.println("    ____________________________________________________________");
        Scanner scanner;
        String clone = "";
        while(!clone.equals("bye"))
        {
            scanner = new Scanner(System.in);
            clone = scanner.next();
            if(!clone.equals("bye")) {
                System.out.println("    ____________________________________________________________");
                System.out.println("    " + clone);
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
}
