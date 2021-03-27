package fd.se.btsplus.bts.exception;

public class BtsNotFoundException extends RuntimeException{
    public BtsNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
