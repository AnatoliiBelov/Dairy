package structureOfTask;

import repeatabilityOfTask.RepeatabilityOfTask;
import taskExeption.IncorrectArgumentException;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Task implements RepeatabilityOfTask {
    private static int idGenerator = 0;
    private String title;
    private final Type type;
    private static int id;
    private final LocalDateTime dateTime;


    private String description;

    public Task(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        if (title.isEmpty() || title == null) {
            throw new IncorrectArgumentException("Заголовок задачи");
        }

        this.title = title;
        if (type == null) {
            throw new IncorrectArgumentException("Тип задачи");
        }
        this.type = type;
        if (dateTime == null) {
            throw new IncorrectArgumentException("дата и время должны быть обязательно");
        }
        this.dateTime = dateTime;
        if (description.isEmpty() || description == null) {
            throw new IncorrectArgumentException("Описание задачи");
        }
        this.description = description;
        id = idGenerator++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws IncorrectArgumentException {
        if (title.isEmpty() || title == null) {
            throw new IncorrectArgumentException("Заголовок задачи");
        }

        this.title = title;
    }

    public Type getType() {
        return type;
    }

    public static int getId() {
        return id;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) throws IncorrectArgumentException {
        if (description.isEmpty() || description == null) {
            throw new IncorrectArgumentException("Описание задачи");
        }
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, dateTime, description);
    }

    @Override
    public String toString() {
        return "Задача: " + title +
                ", Тип: " + type +
                ", Дата и время задачи: " + dateTime +
                ", Описание: " + description;

    }
}
