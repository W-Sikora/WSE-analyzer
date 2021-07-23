package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.Dividend;
import pl.wsikora.wseanalyzer.repositories.DividendRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DividendServiceImpl implements DividendService {

    private final DividendRepository repository;

    public DividendServiceImpl(DividendRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Dividend> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<Dividend> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public Dividend create(Dividend dividend) {
        return repository.save(dividend);
    }

    @Override
    public Dividend update(long id, Dividend dividend) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(dividend)))
                .orElseThrow(() -> new ResourceNotFoundException(Dividend.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(Dividend.class, id);
        }
    }
}
