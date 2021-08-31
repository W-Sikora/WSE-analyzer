package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.ProfitabilityRatio;
import pl.wsikora.wseanalyzer.repositories.ProfitabilityRatioRepository;

@Service
public class ProfitabilityRatioServiceImpl extends CrudServiceImpl<ProfitabilityRatio> implements ProfitabilityRatioService {

    private final ProfitabilityRatioRepository repository;

    public ProfitabilityRatioServiceImpl(ProfitabilityRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
