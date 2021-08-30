package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Dividend;
import pl.wsikora.wseanalyzer.repositories.DividendRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class DividendServiceImpl extends CrudServiceImpl<Dividend> implements DividendService {

    private final DividendRepository repository;

    public DividendServiceImpl(DividendRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Dividend update(long id, Dividend dividend) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, dividend)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
