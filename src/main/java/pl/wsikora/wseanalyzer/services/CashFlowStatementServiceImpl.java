package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.CashFlowStatement;
import pl.wsikora.wseanalyzer.repositories.CashFlowStatementRepository;

@Service
public class CashFlowStatementServiceImpl extends CrudServiceImpl<CashFlowStatement> implements CashFlowStatementService {

    private final CashFlowStatementRepository repository;

    public CashFlowStatementServiceImpl(CashFlowStatementRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
