package Tema4.DeepSpaceConqueror;

public class CancelarException extends Exception{
    public CancelarException() {
    }

    public CancelarException(String message) {
        super(message);
    }

    public CancelarException(String message, Throwable cause) {
        super(message, cause);
    }

    public CancelarException(Throwable cause) {
        super(cause);
    }

    public CancelarException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
