package Exception;

public class InvalidInputDataException extends Exception {
    public InvalidInputDataException() {
        super("Invalid input data");
    }

    public InvalidInputDataException (String message) {
        super(message);
    }

}
