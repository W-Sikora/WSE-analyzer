package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.LiquidityRatio;
import pl.wsikora.wseanalyzer.repositories.LiquidityRatioRepository;

@Service
public class LiquidityRatioServiceImpl extends CrudServiceImpl<LiquidityRatio> implements LiquidityRatioService {

    private final LiquidityRatioRepository repository;

    public LiquidityRatioServiceImpl(LiquidityRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
