package taskExeption;

public class IncorrectArgumentException extends Exception {
    private String argument;

    public IncorrectArgumentException(String argument) {
        this.argument = argument;
        System.out.println("Введен некорректный формат данных: " + argument);
    }
}
