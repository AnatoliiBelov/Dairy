package structureOfTask;

import taskExeption.IncorrectArgumentException;

import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, Type type, LocalDateTime dateTime, String description)throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public LocalDateTime repeatabilityOfTask(LocalDateTime dateTime) {
        return dateTime.plusMonths(1);
    }
}
