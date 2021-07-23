package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.MarketValueRatio;
import pl.wsikora.wseanalyzer.repositories.MarketValueRatioRepository;

import java.util.List;
import java.util.Optional;

public class MarketValueRatioServiceImpl implements MarketValueRatioService {

    private final MarketValueRatioRepository repository;

    public MarketValueRatioServiceImpl(MarketValueRatioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MarketValueRatio> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<MarketValueRatio> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public MarketValueRatio create(MarketValueRatio marketValueRatio) {
        return repository.save(marketValueRatio);
    }

    @Override
    public MarketValueRatio update(long id, MarketValueRatio marketValueRatio) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(marketValueRatio)))
                .orElseThrow(() -> new ResourceNotFoundException(MarketValueRatio.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(MarketValueRatio.class, id);
        }
    }

}
