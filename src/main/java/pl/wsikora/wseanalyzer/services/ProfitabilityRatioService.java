package pl.wsikora.wseanalyzer.services;


import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.ProfitabilityRatio;

import java.util.List;
import java.util.Optional;

public interface ProfitabilityRatioService {

    List<ProfitabilityRatio> getPart(Pageable pageable);

    Optional<ProfitabilityRatio> getSingle(long id);

    ProfitabilityRatio create(ProfitabilityRatio profitabilityRatio);

    ProfitabilityRatio update(long id, ProfitabilityRatio profitabilityRatio);

    void delete(long id);

}
