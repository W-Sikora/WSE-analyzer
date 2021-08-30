package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.MarketValueRatio;
import pl.wsikora.wseanalyzer.repositories.MarketValueRatioRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class MarketValueRatioServiceImpl extends CrudServiceImpl<MarketValueRatio> implements MarketValueRatioService {

    private final MarketValueRatioRepository repository;

    public MarketValueRatioServiceImpl(MarketValueRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public MarketValueRatio update(long id, MarketValueRatio marketValueRatio) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, marketValueRatio)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
