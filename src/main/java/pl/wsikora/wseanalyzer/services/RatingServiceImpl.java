package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Rating;
import pl.wsikora.wseanalyzer.repositories.RatingRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class RatingServiceImpl extends CrudServiceImpl<Rating> implements RatingService {

    private final RatingRepository repository;

    public RatingServiceImpl(RatingRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Rating update(long id, Rating rating) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, rating)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
