package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.Price;

import java.util.List;
import java.util.Optional;

public interface PriceService {

    List<Price> getPart(Pageable pageable);

    Optional<Price> getSingle(long id);

    Price create(Price price);

    Price update(long id, Price price);

    void delete(long id);

}
