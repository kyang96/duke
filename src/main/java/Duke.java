import java.util.*;

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
        List<Task> taskList = new ArrayList<Task>();
        while (!str.equals("bye")){
            if (str.equals("list")){
                printLine();
                int count = 1;
                System.out.println("Here are the tasks in your list:");
                for (Task t : taskList){
                    System.out.println(count + ".[" + t.getStatusIcon() + "] " + t.getDescription());
                    count++;
                }
                printLine();
            } else if (str.length() >= 5 && str.substring(0,4).equals("done")) {
                String[] strArr = str.split(" ");
                int num = Integer.parseInt(strArr[1]) - 1;
                Task task = taskList.get(num);
                task.markAsDone();
                taskList.set(num, task);
                printLine();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("[" + task.getStatusIcon() + "] " + task.getDescription());
                printLine();
            }
            else {
                printLine();
                Task task = new Task(str);
                taskList.add(task);
                System.out.println("added: " + str);
                printLine();
            }
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
