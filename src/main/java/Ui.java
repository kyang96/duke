import java.util.Scanner;

public class Ui {
    private Scanner sc;

    public Ui(){
        sc = new Scanner(System.in);
    }

    public void welcomeMsg(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        printLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can I do for you?");
        printLine();
    }

    public void byeMsg(){
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    public String readLine(){
        return sc.nextLine();
    }

    public void printLine(){
        System.out.println("____________________________________________________________");
    }
}
