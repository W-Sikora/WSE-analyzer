package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.CashFlowStatement;
import pl.wsikora.wseanalyzer.repositories.CashFlowStatementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CashFlowStatementServiceImpl implements CashFlowStatementService {

    private final CashFlowStatementRepository repository;

    public CashFlowStatementServiceImpl(CashFlowStatementRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CashFlowStatement> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<CashFlowStatement> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public CashFlowStatement create(CashFlowStatement cashFlowStatement) {
        return repository.save(cashFlowStatement);
    }

    @Override
    public CashFlowStatement update(long id, CashFlowStatement cashFlowStatement) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(cashFlowStatement)))
                .orElseThrow(() -> new ResourceNotFoundException(CashFlowStatement.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(CashFlowStatement.class, id);
        }
    }

}
