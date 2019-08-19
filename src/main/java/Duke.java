import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
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

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        while (!str.equals("bye")){
            printLine();
            System.out.println(str);
            printLine();
            str = sc.nextLine();
        }
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    private static void printLine(){
        System.out.println("____________________________________________________________");
    }
}
