/**
 * Author: Victor Tran
 * Date: 07/23/2024
 * Description: This class contains unit tests for the Task class.
 */
package ProjectOne;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    public void testTaskCreation() {
        Task task = new Task("12345", "Test Task", "This is a test task description.");

        assertEquals("12345", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test task description.", task.getDescription());
    }

    @Test
    public void testInvalidTaskId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Test Task", "This is a test task description.");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Test Task", "This is a test task description.");
        });
    }

    @Test
    public void testInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", null, "This is a test task description.");
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "This name is way too long for a task name", "This is a test task description.");
        });
    }

    @Test
    public void testInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Task", null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Test Task", "This description is way too long. It exceeds the maximum allowed length for a task description.");
        });
    }
}
