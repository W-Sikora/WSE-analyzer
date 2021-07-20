package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Popularity;
import pl.wsikora.wseanalyzer.repositories.PopularityRepository;

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
