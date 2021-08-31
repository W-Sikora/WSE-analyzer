package pl.wsikora.wseanalyzer.controllers.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public <T> ResourceNotFoundException(Class<T> entityClass, long id) {
        super(String.format("%s with id = %d not found", entityClass.getSimpleName(), id));
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
