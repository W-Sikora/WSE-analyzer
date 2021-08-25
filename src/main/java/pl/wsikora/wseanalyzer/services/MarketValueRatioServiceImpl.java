package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.MarketValueRatio;
import pl.wsikora.wseanalyzer.repositories.MarketValueRatioRepository;

@Service
public class MarketValueRatioServiceImpl extends CrudServiceImpl<MarketValueRatio> implements MarketValueRatioService {

    private final MarketValueRatioRepository repository;

    public MarketValueRatioServiceImpl(MarketValueRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
