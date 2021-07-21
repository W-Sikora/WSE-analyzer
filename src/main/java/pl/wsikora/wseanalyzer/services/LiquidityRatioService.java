package pl.wsikora.wseanalyzer.services;


import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.LiquidityRatio;

import java.util.List;
import java.util.Optional;

public interface LiquidityRatioService {

    List<LiquidityRatio> getPart(Pageable pageable);

    Optional<LiquidityRatio> getSingle(long id);

    LiquidityRatio create(LiquidityRatio liquidityRatio);

    LiquidityRatio update(long id, LiquidityRatio liquidityRatio);

    void delete(long id);

}
