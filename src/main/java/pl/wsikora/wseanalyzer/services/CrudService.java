package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.EntityClass;

import java.util.List;
import java.util.Optional;

public interface CrudService <T extends EntityClass> {

    List<T> getPart(Pageable pageable);

    Optional<T> getSingle(long id);

    T create(T t);

    T update(long id, T t);

    void delete(long id);

}
