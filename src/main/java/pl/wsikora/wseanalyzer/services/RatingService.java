package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.Rating;

import java.util.List;
import java.util.Optional;

public interface RatingService {

    List<Rating> getPart(Pageable pageable);

    Optional<Rating> getSingle(long id);

    Rating create(Rating rating);

    Rating update(long id, Rating rating);

    void delete(long id);

}
