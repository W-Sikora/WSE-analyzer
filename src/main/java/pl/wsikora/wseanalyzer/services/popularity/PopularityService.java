package pl.wsikora.wseanalyzer.services.popularity;

import pl.wsikora.wseanalyzer.model.dividend.Dividend;
import pl.wsikora.wseanalyzer.model.popularity.Popularity;

import java.util.Optional;

public interface PopularityService {

    Optional<Popularity> getSingle(long id);

}
