package structureOfTask;

import taskExeption.IncorrectArgumentException;

import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, LocalDateTime dateTime, String description) throws IncorrectArgumentException {
        super(title, type, dateTime, description);
    }

    @Override
    public LocalDateTime repeatabilityOfTask(LocalDateTime dateTime) {
        return dateTime.plusYears(1);
    }
}
