package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.Popularity;

import java.util.List;
import java.util.Optional;

public interface PopularityService {

    List<Popularity> getPart(Pageable pageable);

    Optional<Popularity> getSingle(long id);

    Popularity create(Popularity popularity);

    Popularity update(long id, Popularity popularity);

    void delete(long id);

}
