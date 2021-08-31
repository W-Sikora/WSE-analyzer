package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Shareholding;
import pl.wsikora.wseanalyzer.repositories.ShareholdingRepository;

@Service
public class ShareholdingServiceImpl extends CrudServiceImpl<Shareholding> implements ShareholdingService {

    private final ShareholdingRepository repository;

    public ShareholdingServiceImpl(ShareholdingRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
