package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public abstract class CrudServiceImpl<T> implements CrudService<T> {

    private final JpaRepository<T, Long> repository;

    protected CrudServiceImpl(JpaRepository<T, Long> repository) {
        this.repository = repository;
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
                .map(repository::save)
                .orElseThrow(() -> new IllegalArgumentException(""));
    }

    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("");
        }
    }

}
