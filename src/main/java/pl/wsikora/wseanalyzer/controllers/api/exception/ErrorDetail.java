package pl.wsikora.wseanalyzer.controllers.api.exception;

import org.springframework.http.HttpStatus;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ErrorDetail {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public <T extends RuntimeException> ErrorDetail(T exception, HttpStatus httpStatus) {
        this.message = exception.getMessage();
        this.throwable = exception;
        this.httpStatus = httpStatus;
        this.timeStamp = ZonedDateTime.now(ZoneId.of("CET"));
    }

    public ErrorDetail(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

}
