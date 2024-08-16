/**
 * Author: Victor Tran
 * Date: 07/23/2024
 * Description: This class contains unit tests for the TaskService class.
 */
package ProjectOne;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    public void setUp() {
        taskService = new TaskService();
    }

    @Test
    public void testAddTask() {
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        taskService.addTask(task);

        assertNotNull(taskService.getTask("12345"));
    }

    @Test
    public void testAddDuplicateTask() {
        Task task1 = new Task("12345", "Test Task", "This is a test task description.");
        Task task2 = new Task("12345", "Another Task", "This is another test task description.");
        taskService.addTask(task1);

        assertThrows(IllegalArgumentException.class, () -> {
            taskService.addTask(task2);
        });
    }

    @Test
    public void testDeleteTask() {
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        taskService.addTask(task);
        taskService.deleteTask("12345");

        assertNull(taskService.getTask("12345"));
    }

    @Test
    public void testUpdateTask() {
        Task task = new Task("12345", "Test Task", "This is a test task description.");
        taskService.addTask(task);

        taskService.updateTask("12345", "Updated Task", "This is an updated task description.");

        Task updatedTask = taskService.getTask("12345");
        assertEquals("Updated Task", updatedTask.getName());
        assertEquals("This is an updated task description.", updatedTask.getDescription());
    }
}
