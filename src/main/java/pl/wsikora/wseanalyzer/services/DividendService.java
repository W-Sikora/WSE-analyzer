package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.Dividend;

import java.util.List;
import java.util.Optional;

public interface DividendService {

    List<Dividend> getPart(Pageable pageable);

    Optional<Dividend> getSingle(long id);

    Dividend create(Dividend dividend);

    Dividend update(long id, Dividend dividend);

    void delete(long id);

}
