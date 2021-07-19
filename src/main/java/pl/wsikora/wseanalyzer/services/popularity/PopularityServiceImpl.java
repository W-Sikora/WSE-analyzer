package pl.wsikora.wseanalyzer.services.popularity;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.dividend.Dividend;
import pl.wsikora.wseanalyzer.model.popularity.Popularity;
import pl.wsikora.wseanalyzer.repositories.popularity.PopularityRepository;

import java.util.Optional;

@Service
public class PopularityServiceImpl implements PopularityService {

    private final PopularityRepository repository;

    public PopularityServiceImpl(PopularityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Popularity> getSingle(long id) {
        return repository.findById(id);
    }
}