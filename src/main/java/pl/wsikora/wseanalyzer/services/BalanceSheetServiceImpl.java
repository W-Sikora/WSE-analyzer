package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.BalanceSheet;
import pl.wsikora.wseanalyzer.repositories.BalanceSheetRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class BalanceSheetServiceImpl extends CrudServiceImpl<BalanceSheet> implements BalanceSheetService {

    private final BalanceSheetRepository repository;

    public BalanceSheetServiceImpl(BalanceSheetRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public BalanceSheet update(long id, BalanceSheet balanceSheet) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, balanceSheet)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
