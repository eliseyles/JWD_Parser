package by.training.khoroneko.exception;

public class CalculateException extends Exception {
    public CalculateException() {
        super();
    }

    public CalculateException(String message) {
        super(message);
    }

    public CalculateException(String message, Throwable cause) {
        super(message, cause);
    }

    public CalculateException(Throwable cause) {
        super(cause);
    }
}
