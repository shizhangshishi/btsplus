package fd.se.btsplus.bts.exception;

public class BtsUnauthorizedException extends RuntimeException{
    public BtsUnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
}
