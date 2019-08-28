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
}
