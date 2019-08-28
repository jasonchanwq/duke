import java.util.ArrayList;
import java.util.List;
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

        List<String> EntryList = new ArrayList<String>(); //create list

        while(!clone.equals("bye"))
        {
            scanner = new Scanner(System.in);
            clone = scanner.next();
            EntryList.add(clone);

            if(clone.equals("list"))
            {
                System.out.println("    ____________________________________________________________");
                for(int i=0;i<(EntryList.size()-1);i++){
                    System.out.println("    " + (i+1) + ". " + EntryList.get(i));
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
}
