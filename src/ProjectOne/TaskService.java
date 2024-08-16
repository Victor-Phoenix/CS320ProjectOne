/**
 * Author: Victor Tran
 * Date: 07/23/2024
 * Description: This class provides services to add, update, and delete tasks in an in-memory data structure.
 */
package ProjectOne;
import java.util.ArrayList;
import java.util.List;

public class TaskService {
    private List<Task> tasks;

    public TaskService() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (t.getTaskId().equals(task.getTaskId())) {
                throw new IllegalArgumentException("Task ID already exists");
            }
        }
        tasks.add(task);
    }

    public void deleteTask(String taskId) {
        tasks.removeIf(t -> t.getTaskId().equals(taskId));
    }

    public void updateTask(String taskId, String name, String description) {
        for (Task t : tasks) {
            if (t.getTaskId().equals(taskId)) {
                if (name != null && name.length() <= 20) {
                    t.setName(name);
                }
                if (description != null && description.length() <= 50) {
                    t.setDescription(description);
                }
                return;
            }
        }
    }

    public Task getTask(String taskId) {
        for (Task t : tasks) {
            if (t.getTaskId().equals(taskId)) {
                return t;
            }
        }
        return null;
    }
}
