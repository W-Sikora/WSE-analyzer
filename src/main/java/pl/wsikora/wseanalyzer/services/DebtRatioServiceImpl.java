package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.DebtRatio;
import pl.wsikora.wseanalyzer.repositories.DebtRatioRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class DebtRatioServiceImpl extends CrudServiceImpl<DebtRatio> implements DebtRatioService {

    private final DebtRatioRepository repository;

    public DebtRatioServiceImpl(DebtRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public DebtRatio update(long id, DebtRatio debtRatio) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, debtRatio)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
