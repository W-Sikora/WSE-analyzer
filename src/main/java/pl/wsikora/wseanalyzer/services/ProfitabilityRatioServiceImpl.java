package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.ProfitabilityRatio;
import pl.wsikora.wseanalyzer.repositories.ProfitabilityRatioRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class ProfitabilityRatioServiceImpl extends CrudServiceImpl<ProfitabilityRatio> implements ProfitabilityRatioService {

    private final ProfitabilityRatioRepository repository;

    public ProfitabilityRatioServiceImpl(ProfitabilityRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public ProfitabilityRatio update(long id, ProfitabilityRatio profitabilityRatio) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, profitabilityRatio)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
