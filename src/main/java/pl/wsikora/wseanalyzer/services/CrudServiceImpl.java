package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.EntityClass;
import pl.wsikora.wseanalyzer.util.Utils;
import pl.wsikora.wseanalyzer.util.entities.Merger;

import java.util.List;
import java.util.Optional;

public abstract class CrudServiceImpl<T extends EntityClass> implements CrudService<T> {
    private final JpaRepository<T, Long> repository;
    private final Class<T> entityType;

    protected CrudServiceImpl(JpaRepository<T, Long> repository) {
        this.repository = repository;
        this.entityType = Utils.getEntityType(this);
    }

    public List<T> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    public Optional<T> getSingle(long id) {
        return repository.findById(id);
    }

    public T create(T t) {
        return repository.save(t);
    }

    public T update(long id, T t) {
        return repository.findById(id)
                .map(e -> repository.save(Merger.merge(e, t)))
                .orElseThrow(() -> new ResourceNotFoundException(entityType, id));
    }

    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(entityType, id);
        }
    }

}
