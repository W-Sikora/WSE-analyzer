package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.DividendRatio;
import pl.wsikora.wseanalyzer.repositories.DividendRatioRepository;

@Service
public class DividendRatioServiceImpl extends CrudServiceImpl<DividendRatio> implements DividendRatioService {

    private final DividendRatioRepository repository;

    public DividendRatioServiceImpl(DividendRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
