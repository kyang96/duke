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

        FileIO fileIO = new FileIO(".\\data\\duke.txt");
        taskList = fileIO.loadFile();
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
                printLine();
                try {
                    int num = Integer.parseInt(strArr[1]) - 1;
                    Task task = taskList.get(num);
                    task.markAsDone();
                    taskList.set(num, task);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(task.toString());
                    fileIO.updateFile(task, num);
                } catch (IndexOutOfBoundsException e){
                    System.out.println("☹ OOPS!!! I'm sorry, but this task does not exist");
                }
                printLine();
            } else if (strArr[0].equals("todo") || strArr[0].equals("deadline") || strArr[0].equals("event")) {
                printLine();
                try {
                    Task task = createTask(strArr[0], strArr[1]);
                    if (task != null){
                        taskList.add(task);
                        System.out.println("Got it. I've added this task:");
                        System.out.println(task.toString());
                        System.out.println("Now you have " + taskList.size() + " tasks in the list.");
                        fileIO.writeFile(task, strArr[0]);
                    }
                } catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("☹ OOPS!!! The description of a " + strArr[0] + " cannot be empty");
                }
                printLine();
            } else {
                if (!str.equals("bye")){
                    printLine();
                    System.out.println("☹ OOPS!!! I'm sorry, but I don't know what that means :-(");
                    printLine();
                }
            }
        } while (!str.equals("bye"));
        printLine();
        System.out.println("Bye. Hope to see you again soon!");
        printLine();
    }

    private static void printLine(){
        System.out.println("____________________________________________________________");
    }

    /**
     * Creates and populate a corresponding task object given its type.
     *
     * @param type The type of task to be created
     * @param description The description of the task
     * @return The task object with corresponding values
     */
    private static Task createTask(String type, String description) {
        String[] info;
        try {
            if (type.equals("todo")) {
                return new Todo(description);
            } else if (type.equals("deadline")) {
                info = description.split("/by");
                return new Deadline(info[0].trim(), info[1].trim());
            } else if (type.equals("event")) {
                info = description.split("/at");
                return new Event(info[0].trim(), info[1].trim());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("☹ OOPS!!! The date/time of a " + type + " cannot be empty");
        }
        return null;
    }
}
