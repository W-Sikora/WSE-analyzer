package pl.wsikora.wseanalyzer.services;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.Shareholder;
import pl.wsikora.wseanalyzer.model.Shareholding;
import pl.wsikora.wseanalyzer.repositories.ShareholdingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShareholdingServiceImpl implements ShareholdingService {

    private final ShareholdingRepository repository;

    public ShareholdingServiceImpl(ShareholdingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Shareholding> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<Shareholding> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public Shareholding create(Shareholding shareholding) {
        return repository.save(shareholding);
    }

    @Override
    public Shareholding update(long id, Shareholding shareholding) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(shareholding)))
                .orElseThrow(() -> new ResourceNotFoundException(Shareholding.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(Shareholder.class, id);
        }
    }

}
