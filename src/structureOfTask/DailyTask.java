package structureOfTask;

import java.time.LocalDateTime;

public class DailyTask extends Task{
    public DailyTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public LocalDateTime repeatabilityOfTask(LocalDateTime dateTime) {
        return dateTime.plusDays(1);
    }
}
