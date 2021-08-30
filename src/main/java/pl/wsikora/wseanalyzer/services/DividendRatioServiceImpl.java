package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.DividendRatio;
import pl.wsikora.wseanalyzer.repositories.DividendRatioRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class DividendRatioServiceImpl extends CrudServiceImpl<DividendRatio> implements DividendRatioService {

    private final DividendRatioRepository repository;

    public DividendRatioServiceImpl(DividendRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public DividendRatio update(long id, DividendRatio dividendRatio) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, dividendRatio)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
