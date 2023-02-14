import structureOfTask.Task;
import taskExeption.TaskNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TaskService {
    private static Map<Integer, Task> taskMap;
    private static HashSet removedTasks;

    public void addTask(Task task) {
        taskMap.put(Task.getId(), task);
    }

    public Task removeTask(Integer id) throws TaskNotFoundException {

        Task task = taskMap.get(id);
        if (task == null) {
            throw new TaskNotFoundException("Введен неверный ID");
        } else {
            removedTasks.add(task);
            taskMap.remove(id);
        }
        return task;

    }

    public static ArrayList<Task> getAllByDate(LocalDate date) throws TaskNotFoundException {
        ArrayList<Task> tasksOnDay = new ArrayList<>();
        for (Task task :
                taskMap.values()) {
            if (task.getDateTime().toLocalDate() == date) {
                tasksOnDay.add(task);
            }
        }
        if (tasksOnDay.isEmpty()) {
            throw new TaskNotFoundException("На данную дату нет задач");
        }

        return tasksOnDay;

    }


}
