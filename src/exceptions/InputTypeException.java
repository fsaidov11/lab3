package exceptions;

public class InputTypeException extends IllegalArgumentException {

    public InputTypeException(String dataType, String message) {
        super(message + " - Error!! " + dataType);
    }
}
