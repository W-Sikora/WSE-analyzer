package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Price;
import pl.wsikora.wseanalyzer.repositories.PriceRepository;

@Service
public class PriceServiceImpl extends CrudServiceImpl<Price> implements PriceService {

    private final PriceRepository repository;

    public PriceServiceImpl(PriceRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
