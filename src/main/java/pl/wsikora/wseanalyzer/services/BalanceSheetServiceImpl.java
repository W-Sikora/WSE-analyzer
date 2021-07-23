package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.BalanceSheet;
import pl.wsikora.wseanalyzer.repositories.BalanceSheetRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BalanceSheetServiceImpl implements BalanceSheetService {

    private final BalanceSheetRepository repository;

    public BalanceSheetServiceImpl(BalanceSheetRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BalanceSheet> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<BalanceSheet> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public BalanceSheet create(BalanceSheet balanceSheet) {
        return repository.save(balanceSheet);
    }

    @Override
    public BalanceSheet update(long id, BalanceSheet balanceSheet) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(balanceSheet)))
                .orElseThrow(() -> new ResourceNotFoundException(BalanceSheet.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(BalanceSheet.class, id);
        }
    }

}
