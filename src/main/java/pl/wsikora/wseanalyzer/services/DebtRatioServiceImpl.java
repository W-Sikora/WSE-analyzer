package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.DebtRatio;
import pl.wsikora.wseanalyzer.repositories.DebtRatioRepository;

import java.util.List;
import java.util.Optional;

public class DebtRatioServiceImpl implements DebtRatioService {

    private final DebtRatioRepository repository;

    public DebtRatioServiceImpl(DebtRatioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DebtRatio> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<DebtRatio> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public DebtRatio create(DebtRatio debtRatio) {
        return repository.save(debtRatio);
    }

    @Override
    public DebtRatio update(long id, DebtRatio debtRatio) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(debtRatio)))
                .orElseThrow(() -> new ResourceNotFoundException(DebtRatio.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(DebtRatio.class, id);
        }
    }


}
