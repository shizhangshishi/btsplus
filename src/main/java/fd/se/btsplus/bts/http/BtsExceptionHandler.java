package fd.se.btsplus.bts.http;

import fd.se.btsplus.bts.exception.BtsForbiddenException;
import fd.se.btsplus.bts.exception.BtsNotFoundException;
import fd.se.btsplus.bts.exception.BtsUnauthorizedException;
import fd.se.btsplus.bts.exception.BtsUnknownException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BtsExceptionHandler {
    @ExceptionHandler(BtsUnauthorizedException.class)
    public ResponseEntity<?> handleUnauthorizedException(BtsUnauthorizedException ex) {
        return null;
    }

    @ExceptionHandler(BtsForbiddenException.class)
    public ResponseEntity<?> handleForbiddenException(BtsForbiddenException ex) {
        return null;
    }

    @ExceptionHandler(BtsNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(BtsNotFoundException ex) {
        return null;
    }

    @ExceptionHandler(BtsUnknownException.class)
    public ResponseEntity<?> handleUnknownException(BtsUnknownException ex) {
        return null;
    }
}
