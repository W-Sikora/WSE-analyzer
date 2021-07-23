package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.Rating;
import pl.wsikora.wseanalyzer.repositories.RatingRepository;

import java.util.List;
import java.util.Optional;

public class RatingServiceImpl implements RatingService {

    private final RatingRepository repository;

    public RatingServiceImpl(RatingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Rating> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<Rating> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    @Override
    public Rating update(long id, Rating rating) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(rating)))
                .orElseThrow(() -> new ResourceNotFoundException(Rating.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(Rating.class, id);
        }
    }

}
