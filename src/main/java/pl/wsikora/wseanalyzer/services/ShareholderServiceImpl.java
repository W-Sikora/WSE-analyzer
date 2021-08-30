package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Shareholder;
import pl.wsikora.wseanalyzer.repositories.ShareholderRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class ShareholderServiceImpl extends CrudServiceImpl<Shareholder> implements ShareholderService {

    private final ShareholderRepository repository;

    public ShareholderServiceImpl(ShareholderRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Shareholder update(long id, Shareholder Shareholder) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, Shareholder)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
