package services;

import structureOfTask.DailyTask;
import structureOfTask.Task;
import taskExeption.IncorrectArgumentException;
import taskExeption.TaskNotFoundException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TaskService {
    private static Map<Integer, Task> taskMap=new HashMap<>();
    private static HashSet removedTasks=new HashSet<>();

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
            if (task.getDateTime().toLocalDate().equals(date)||task.repeatabilityOfTask(task.getDateTime()).toLocalDate().equals(date)) {
                tasksOnDay.add(task);
            }
        }
        if (tasksOnDay.isEmpty()) {
            throw new TaskNotFoundException("На данную дату нет задач");
        }

        return tasksOnDay;

    }

    public static HashSet getRemovedTasks() {
        return removedTasks;
    }
    public static void updateTitle(int id, String title) throws IncorrectArgumentException {
        Task task = taskMap.get(id);
        task.setTitle(title);
        taskMap.remove(id, task);
    }
    public static void updateDescription(int id, String description) throws IncorrectArgumentException {
        Task task = taskMap.get(id);
        task.setDescription(description);
        taskMap.remove(id, task);
    }
    public static HashMap<LocalDate, Task> getAllGroupeByDate(){
        HashMap<LocalDate, Task> taskGroupeByDate = new HashMap<>();

        for (Task task:taskMap.values()
             ) {
            taskGroupeByDate.put(task.getDateTime().toLocalDate(), task);


        }
        return taskGroupeByDate;

    }
}
