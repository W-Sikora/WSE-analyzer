package pl.wsikora.wseanalyzer.services;


import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.Shareholding;

import java.util.List;
import java.util.Optional;

public interface ShareholdingService {

    List<Shareholding> getPart(Pageable pageable);

    Optional<Shareholding> getSingle(long id);

    Shareholding create(Shareholding shareholding);

    Shareholding update(long id, Shareholding shareholding);

    void delete(long id);

}
