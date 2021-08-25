package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.DebtRatio;
import pl.wsikora.wseanalyzer.repositories.DebtRatioRepository;

@Service
public class DebtRatioServiceImpl extends CrudServiceImpl<DebtRatio> implements DebtRatioService {

    private final DebtRatioRepository repository;

    public DebtRatioServiceImpl(DebtRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
