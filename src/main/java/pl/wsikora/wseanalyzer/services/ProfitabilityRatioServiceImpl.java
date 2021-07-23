package pl.wsikora.wseanalyzer.services;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.ProfitabilityRatio;
import pl.wsikora.wseanalyzer.repositories.ProfitabilityRatioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfitabilityRatioServiceImpl implements ProfitabilityRatioService {

    private final ProfitabilityRatioRepository repository;

    public ProfitabilityRatioServiceImpl(ProfitabilityRatioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProfitabilityRatio> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<ProfitabilityRatio> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public ProfitabilityRatio create(ProfitabilityRatio profitabilityRatio) {
        return repository.save(profitabilityRatio);
    }

    @Override
    public ProfitabilityRatio update(long id, ProfitabilityRatio profitabilityRatio) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(profitabilityRatio)))
                .orElseThrow(() -> new ResourceNotFoundException(ProfitabilityRatio.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(ProfitabilityRatio.class, id);
        }
    }

}
