package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Rating;
import pl.wsikora.wseanalyzer.repositories.RatingRepository;

@Service
public class RatingServiceImpl extends CrudServiceImpl<Rating> implements RatingService {

    private final RatingRepository repository;

    public RatingServiceImpl(RatingRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
