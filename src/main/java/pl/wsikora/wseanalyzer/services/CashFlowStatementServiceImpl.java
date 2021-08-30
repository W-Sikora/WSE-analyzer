package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.CashFlowStatement;
import pl.wsikora.wseanalyzer.repositories.CashFlowStatementRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class CashFlowStatementServiceImpl extends CrudServiceImpl<CashFlowStatement> implements CashFlowStatementService {

    private final CashFlowStatementRepository repository;

    public CashFlowStatementServiceImpl(CashFlowStatementRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public CashFlowStatement update(long id, CashFlowStatement cashFlowStatement) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, cashFlowStatement)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
