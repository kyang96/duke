import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    private String path;

    public FileIO(String path){
        this.path = path;
    }

    /**
     * Attempts to load save file on the local computer and populate the task list with its data.
     *
     * @return The list of task loaded from save file
     */
    public List<Task> loadFile(){
        List<Task> taskList = new ArrayList<Task>();

        try {
            RandomAccessFile raf = new RandomAccessFile(path, "r");
            String str;
            while (raf.getFilePointer() != raf.length()){
                str = raf.readLine();
                String[] strArr = str.split(",");
                String[] info;
                if (strArr[0].trim().equals("T")){
                    Todo todo = new Todo(strArr[2].trim());
                    if (strArr[1].trim().equals("1")){
                        todo.markAsDone();
                    }
                    taskList.add(todo);
                } else if (strArr[0].trim().equals("D")){
                    Deadline deadline = new Deadline(strArr[2].trim(), strArr[3].trim());
                    if (strArr[1].trim().equals("1")){
                        deadline.markAsDone();
                    }
                    taskList.add(deadline);
                } else if (strArr[0].trim().equals("E")) {
                    Event event = new Event(strArr[2].trim(), strArr[3].trim());
                    if (strArr[1].trim().equals("1")) {
                        event.markAsDone();
                    }
                    taskList.add(event);
                }
                System.out.println(str);
            }
            raf.close();
        } catch (FileNotFoundException e){
            System.out.println("No saved tasks found.");
        } catch (IOException e){
            System.out.println("End of file.");
        }

        return taskList;
    }

    /**
     * Attempts to write newly added task into a save file on the local computer.
     *
     * @param task The new task that is added
     * @param type The type of task added
     */
    public void writeFile(Task task, String type){
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "rws");
            raf.seek(raf.length());
            if (type.equals("todo")) { type = "T"; }
            else if (type.equals("event")) { type = "E"; }
            else if (type.equals("deadline")) { type = "D";}
            if (raf.length() != 0) {
                raf.writeBytes("\r\n");
            }
            raf.writeBytes(task.writeToFile());
            raf.close();
        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }

    /**
     * Updates the save file on the local computer when a task is marked as done.
     *
     * @param task The task to be marked as done
     * @param index The index of the task in the list
     */
    public void updateFile(Task task, int index){
        try {
            RandomAccessFile raf = new RandomAccessFile(path, "rws");
            while (index != 0){
                raf.readLine();
                index--;
            }
            raf.seek(raf.getFilePointer() + 2);
            raf.writeBytes("1");
            raf.close();
        } catch (IOException e){
            System.out.println("IOException: " + e.getMessage());
        }
    }
}
