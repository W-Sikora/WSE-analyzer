package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Shareholder;
import pl.wsikora.wseanalyzer.repositories.ShareholderRepository;

@Service
public class ShareholderServiceImpl extends CrudServiceImpl<Shareholder> implements ShareholderService {

    private final ShareholderRepository repository;

    public ShareholderServiceImpl(ShareholderRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
