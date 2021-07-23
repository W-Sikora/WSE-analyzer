package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.Popularity;
import pl.wsikora.wseanalyzer.repositories.PopularityRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PopularityServiceImpl implements PopularityService {

    private final PopularityRepository repository;

    public PopularityServiceImpl(PopularityRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Popularity> getPart(Pageable pageable) {
        return null;
    }

    @Override
    public Optional<Popularity> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public Popularity create(Popularity popularity) {
        return null;
    }

    @Override
    public Popularity update(long id, Popularity popularity) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(popularity)))
                .orElseThrow(() -> new ResourceNotFoundException(Popularity.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(Popularity.class, id);
        }
    }
}
