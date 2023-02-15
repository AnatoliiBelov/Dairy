package structureOfTask;

import taskExeption.IncorrectArgumentException;

import java.time.LocalDateTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String title, Type type, LocalDateTime dateTime, String description)throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public LocalDateTime repeatabilityOfTask(LocalDateTime dateTime) {
        return dateTime.plusWeeks(1);
    }
}
