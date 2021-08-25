package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.BalanceSheet;
import pl.wsikora.wseanalyzer.repositories.BalanceSheetRepository;

@Service
public class BalanceSheetServiceImpl extends CrudServiceImpl<BalanceSheet> implements BalanceSheetService {

    private final BalanceSheetRepository repository;

    public BalanceSheetServiceImpl(BalanceSheetRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
