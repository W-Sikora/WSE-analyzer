package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.IncomeStatement;
import pl.wsikora.wseanalyzer.repositories.IncomeStatementRepository;

import java.util.List;
import java.util.Optional;

public class IncomeStatementServiceImpl implements IncomeStatementService {

    private final IncomeStatementRepository repository;

    public IncomeStatementServiceImpl(IncomeStatementRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<IncomeStatement> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<IncomeStatement> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public IncomeStatement create(IncomeStatement incomeStatement) {
        return repository.save(incomeStatement);
    }

    @Override
    public IncomeStatement update(long id, IncomeStatement incomeStatement) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(incomeStatement)))
                .orElseThrow(() -> new ResourceNotFoundException(IncomeStatement.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(IncomeStatement.class, id);
        }
    }

}
