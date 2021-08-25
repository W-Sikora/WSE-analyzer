package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Popularity;
import pl.wsikora.wseanalyzer.repositories.PopularityRepository;

@Service
public class PopularityServiceImpl extends CrudServiceImpl<Popularity> implements PopularityService {

    private final PopularityRepository repository;

    public PopularityServiceImpl(PopularityRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
