package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Popularity;
import pl.wsikora.wseanalyzer.repositories.PopularityRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class PopularityServiceImpl extends CrudServiceImpl<Popularity> implements PopularityService {

    private final PopularityRepository repository;

    public PopularityServiceImpl(PopularityRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Popularity update(long id, Popularity popularity) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, popularity)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
