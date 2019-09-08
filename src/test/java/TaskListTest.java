import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskListTest {
    TaskList taskList = new TaskList(new ArrayList<Task>());

    @Test
    public void createTaskTest(){
        String type = "todo";
        String desc = "read book";

        Task task = taskList.createTask(type, desc);
        assertEquals("[T][✘] read book", task.toString());

        type = "event";
        desc = "exam /at 10/10/2019 1000";

        task = taskList.createTask(type, desc);
        assertEquals("[E][✘] exam (at: 10 Oct 2019 10:00AM)", task.toString());

        type = "deadline";
        desc = "assignment /by 1/1/2019 2359";

        task = taskList.createTask(type, desc);
        assertEquals("[D][✘] assignment (by: 01 Jan 2019 11:59PM)", task.toString());
    }
}
