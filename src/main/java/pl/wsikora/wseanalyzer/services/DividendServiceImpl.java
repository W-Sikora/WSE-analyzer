package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Dividend;
import pl.wsikora.wseanalyzer.repositories.DividendRepository;

@Service
public class DividendServiceImpl extends CrudServiceImpl<Dividend> implements DividendService {

    private final DividendRepository repository;

    public DividendServiceImpl(DividendRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
