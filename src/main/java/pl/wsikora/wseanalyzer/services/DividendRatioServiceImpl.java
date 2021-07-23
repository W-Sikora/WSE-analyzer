package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.DividendRatio;
import pl.wsikora.wseanalyzer.repositories.DividendRatioRepository;

import java.util.List;
import java.util.Optional;

public class DividendRatioServiceImpl implements DividendRatioService {

    private final DividendRatioRepository repository;

    public DividendRatioServiceImpl(DividendRatioRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<DividendRatio> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<DividendRatio> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public DividendRatio create(DividendRatio dividendRatio) {
        return repository.save(dividendRatio);
    }

    @Override
    public DividendRatio update(long id, DividendRatio dividendRatio) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(dividendRatio)))
                .orElseThrow(() -> new ResourceNotFoundException(DividendRatio.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(DividendRatio.class, id);
        }
    }

}
