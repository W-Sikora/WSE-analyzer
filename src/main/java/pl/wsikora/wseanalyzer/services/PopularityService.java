package pl.wsikora.wseanalyzer.services;

import pl.wsikora.wseanalyzer.model.Popularity;

import java.util.Optional;

public interface PopularityService {

    Optional<Popularity> getSingle(long id);

}
