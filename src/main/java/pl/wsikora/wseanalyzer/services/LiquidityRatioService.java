package pl.wsikora.wseanalyzer.services;


import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.LiquidityRatio;

import java.util.List;
import java.util.Optional;

public interface LiquidityRatioService {

    List<LiquidityRatio> getPart(Pageable pageable);

    Optional<LiquidityRatio> getSingle(long id);

    LiquidityRatio create(LiquidityRatio incomeStatement);

    LiquidityRatio update(long id, LiquidityRatio incomeStatement);

    void delete(long id);

}
