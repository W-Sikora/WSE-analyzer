package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.IncomeStatement;
import pl.wsikora.wseanalyzer.repositories.IncomeStatementRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class IncomeStatementServiceImpl extends CrudServiceImpl<IncomeStatement> implements IncomeStatementService {

    private final IncomeStatementRepository repository;

    public IncomeStatementServiceImpl(IncomeStatementRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public IncomeStatement update(long id, IncomeStatement incomeStatement) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, incomeStatement)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
