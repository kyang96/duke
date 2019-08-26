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
        List<Task> taskList = new ArrayList<Task>();
        String str;
        do {
            str = sc.nextLine();
            String[] strArr = str.split(" ",2);
            if (strArr[0].equals("list")){
                printLine();
                int count = 1;
                System.out.println("Here are the tasks in your list:");
                for (Task t : taskList){
                    System.out.println(count + "." + t.toString());
                    count++;
                }
                printLine();
            } else if (strArr[0].equals("done")) {
                int num = Integer.parseInt(strArr[1]) - 1;
                Task task = taskList.get(num);
                task.markAsDone();
                taskList.set(num, task);
                printLine();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(task.toString());
                printLine();
            } else if (strArr[0].equals("todo") || strArr[0].equals("deadline") || strArr[0].equals("event")) {
                printLine();
                Task task = addTask(strArr[0], strArr[1]);
                taskList.add(task);
                System.out.println("Got it. I've added this task:");
                System.out.println(task.toString());
                System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                printLine();
            } else {
                printLine();
                System.out.println("Invalid command");
                printLine();
            }
        } while (!str.equals("bye"));
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    private static void printLine(){
        System.out.println("____________________________________________________________");
    }

    private static Task addTask(String type, String description){
        String[] info;
        if (type.equals("todo")){
            return new Todo(description);
        } else if (type.equals("deadline")){
            info = description.split("/by");
            return new Deadline(info[0].trim(), info[1].trim());
        } else if (type.equals("event")){
            info = description.split("/at");
            return new Event(info[0].trim(), info[1].trim());
        }
        return null;
    }
}
