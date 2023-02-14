package structureOfTask;

import java.time.LocalDateTime;

public class OneTimeTask extends Task {


    public OneTimeTask(String title, Type type, LocalDateTime dateTime, String description) {
        super(title, type, dateTime, description);
    }

    @Override
    public LocalDateTime repeatabilityOfTask(LocalDateTime dateTime) {
        return null;
    }
}
