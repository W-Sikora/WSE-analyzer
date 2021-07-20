package pl.wsikora.wseanalyzer.controllers.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(Class<?> entityClass, long id) {
        super(String.format("%s with id = %d not found", entityClass.getName(), id));
    }

}
