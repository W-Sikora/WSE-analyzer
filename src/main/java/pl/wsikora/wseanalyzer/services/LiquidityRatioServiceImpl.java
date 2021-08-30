package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.LiquidityRatio;
import pl.wsikora.wseanalyzer.repositories.LiquidityRatioRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class LiquidityRatioServiceImpl extends CrudServiceImpl<LiquidityRatio> implements LiquidityRatioService {

    private final LiquidityRatioRepository repository;

    public LiquidityRatioServiceImpl(LiquidityRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public LiquidityRatio update(long id, LiquidityRatio liquidityRatio) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, liquidityRatio)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
