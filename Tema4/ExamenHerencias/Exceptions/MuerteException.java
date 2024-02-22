package Tema4.ExamenHerencias.Exceptions;

public class MuerteException extends Exception{
    public MuerteException() {
    }

    public MuerteException(String message) {
        super(message);
    }

    public MuerteException(String message, Throwable cause) {
        super(message, cause);
    }

    public MuerteException(Throwable cause) {
        super(cause);
    }

    public MuerteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
