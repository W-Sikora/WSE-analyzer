package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.MarketValueRatio;

import java.util.List;
import java.util.Optional;

public interface MarketValueRatioService {

    List<MarketValueRatio> getPart(Pageable pageable);

    Optional<MarketValueRatio> getSingle(long id);

    MarketValueRatio create(MarketValueRatio marketValueRatio);

    MarketValueRatio update(long id, MarketValueRatio marketValueRatio);

    void delete(long id);


}
