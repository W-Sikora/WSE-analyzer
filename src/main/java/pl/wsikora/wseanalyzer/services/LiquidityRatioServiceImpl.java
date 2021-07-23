package pl.wsikora.wseanalyzer.services;


import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.LiquidityRatio;
import pl.wsikora.wseanalyzer.repositories.LiquidityRatioRepository;

import java.util.List;
import java.util.Optional;

public class LiquidityRatioServiceImpl implements LiquidityRatioService {

    private final LiquidityRatioRepository repository;

    public LiquidityRatioServiceImpl(LiquidityRatioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<LiquidityRatio> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<LiquidityRatio> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public LiquidityRatio create(LiquidityRatio liquidityRatio) {
        return repository.save(liquidityRatio);
    }

    @Override
    public LiquidityRatio update(long id, LiquidityRatio liquidityRatio) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(liquidityRatio)))
                .orElseThrow(() -> new ResourceNotFoundException(LiquidityRatio.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(LiquidityRatio.class, id);
        }
    }

}
