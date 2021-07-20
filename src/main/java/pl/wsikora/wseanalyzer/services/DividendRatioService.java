package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.DividendRatio;

import java.util.List;
import java.util.Optional;

public interface DividendRatioService {

    List<DividendRatio> getPart(Pageable pageable);

    Optional<DividendRatio> getSingle(long id);

    DividendRatio create(DividendRatio dividendRatio);

    DividendRatio update(long id, DividendRatio dividendRatio);

    void delete(long id);

}
