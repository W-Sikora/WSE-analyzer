package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CrudService <T> {

    List<T> getPart(Pageable pageable);

    Optional<T> getSingle(long id);

    T create(T t);

    T update(long id, T t);

    void delete(long id);

}
