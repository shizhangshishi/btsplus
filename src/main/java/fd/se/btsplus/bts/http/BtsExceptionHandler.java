package fd.se.btsplus.bts.http;

import fd.se.btsplus.bts.exception.BtsForbiddenException;
import fd.se.btsplus.bts.exception.BtsNotFoundException;
import fd.se.btsplus.bts.exception.BtsUnauthorizedException;
import fd.se.btsplus.bts.exception.BtsUnknownException;
import fd.se.btsplus.model.response.BaseRes;
import fd.se.btsplus.model.response.ResWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static java.net.HttpURLConnection.*;
import static org.springframework.http.HttpStatus.*;

@Slf4j
@RestControllerAdvice
public class BtsExceptionHandler {
    @ExceptionHandler(BtsUnauthorizedException.class)
    public ResponseEntity<?> handleUnauthorizedException(BtsUnauthorizedException ex) {
        log.warn(ex.getMessage(), ex);
        return ResponseEntity.
                status(UNAUTHORIZED).
                body(ResWrapper.wrap(HTTP_UNAUTHORIZED, BaseRes.empty()));
    }

    @ExceptionHandler(BtsForbiddenException.class)
    public ResponseEntity<?> handleForbiddenException(BtsForbiddenException ex) {
        log.warn(ex.getMessage(), ex);
        return ResponseEntity.
                status(FORBIDDEN).
                body(ResWrapper.wrap(HTTP_FORBIDDEN, BaseRes.empty()));
    }

    @ExceptionHandler(BtsNotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(BtsNotFoundException ex) {
        log.warn(ex.getMessage(), ex);
        return ResponseEntity.
                status(NOT_FOUND).
                body(ResWrapper.wrap(HTTP_NOT_FOUND, BaseRes.empty()));
    }

    @ExceptionHandler(BtsUnknownException.class)
    public ResponseEntity<?> handleUnknownException(BtsUnknownException ex) {
        log.warn(ex.getMessage(), ex);
        return ResponseEntity.
                status(BAD_REQUEST).
                body(ResWrapper.wrap(HTTP_BAD_REQUEST, BaseRes.empty()));
    }
}
