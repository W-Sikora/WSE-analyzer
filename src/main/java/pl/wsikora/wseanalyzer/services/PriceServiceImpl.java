package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Price;
import pl.wsikora.wseanalyzer.repositories.PriceRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class PriceServiceImpl extends CrudServiceImpl<Price> implements PriceService {

    private final PriceRepository repository;

    public PriceServiceImpl(PriceRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Price update(long id, Price price) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, price)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
