package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.Shareholder;
import pl.wsikora.wseanalyzer.repositories.ShareholderRepository;

import java.util.List;
import java.util.Optional;

public class ShareholderServiceImpl  implements ShareholderService {

    private final ShareholderRepository repository;

    public ShareholderServiceImpl(ShareholderRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Shareholder> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<Shareholder> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public Shareholder create(Shareholder shareholder) {
        return repository.save(shareholder);
    }

    @Override
    public Shareholder update(long id, Shareholder shareholder) {
        return repository.findById(id)
                .map(updatedShareholder -> {
                    return updatedShareholder;
                })
                .orElseThrow(() -> new ResourceNotFoundException(Shareholder.class, id));
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
