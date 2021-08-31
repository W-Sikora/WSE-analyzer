package pl.wsikora.wseanalyzer.controllers.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> handleResourceNotFoundException(ResourceNotFoundException exception) {
        return form(exception, HttpStatus.NOT_FOUND);
    }

    private static ResponseEntity<ErrorDetail> form(ResourceNotFoundException exception, HttpStatus httpStatus) {
        return new ResponseEntity<>(new ErrorDetail(exception, httpStatus), httpStatus);
    }

}
