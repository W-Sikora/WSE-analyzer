package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.Price;
import pl.wsikora.wseanalyzer.repositories.PriceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PriceServiceImpl implements PriceService {

    private final PriceRepository repository;

    public PriceServiceImpl(PriceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Price> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<Price> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public Price create(Price price) {
        return repository.save(price);
    }

    @Override
    public Price update(long id, Price price) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(price)))
                .orElseThrow(() -> new ResourceNotFoundException(Price.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(Price.class, id);
        }
    }

}
