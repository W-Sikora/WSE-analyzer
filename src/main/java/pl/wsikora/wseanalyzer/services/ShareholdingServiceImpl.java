package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Shareholding;
import pl.wsikora.wseanalyzer.repositories.ShareholdingRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class ShareholdingServiceImpl extends CrudServiceImpl<Shareholding> implements ShareholdingService {

    private final ShareholdingRepository repository;

    public ShareholdingServiceImpl(ShareholdingRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Shareholding update(long id, Shareholding shareholding) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, shareholding)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
