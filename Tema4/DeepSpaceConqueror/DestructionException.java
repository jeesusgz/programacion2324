package Tema4.DeepSpaceConqueror;

public class DestructionException extends Exception{
    private static final long serialversionUID = 1L;

    public DestructionException() {
    }

    public DestructionException(String message) {
        super(message);
    }

    public DestructionException(Throwable cause) {
        super(cause);
    }

    public DestructionException(String message, Throwable cause) {
        super(message, cause);
    }

    public DestructionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
