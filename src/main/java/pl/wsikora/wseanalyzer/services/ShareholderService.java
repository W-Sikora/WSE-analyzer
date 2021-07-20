package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.Shareholder;

import java.util.List;
import java.util.Optional;

public interface ShareholderService {

    List<Shareholder> getPart(Pageable pageable);

    Optional<Shareholder> getSingle(long id);

    Shareholder create(Shareholder shareholder);

    Shareholder update(long id, Shareholder shareholder);

    void delete(long id);

}
