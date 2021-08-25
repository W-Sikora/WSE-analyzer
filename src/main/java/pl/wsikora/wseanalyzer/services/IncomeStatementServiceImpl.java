package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.IncomeStatement;
import pl.wsikora.wseanalyzer.repositories.IncomeStatementRepository;

@Service
public class IncomeStatementServiceImpl extends CrudServiceImpl<IncomeStatement> implements IncomeStatementService {

    private final IncomeStatementRepository repository;

    public IncomeStatementServiceImpl(IncomeStatementRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
