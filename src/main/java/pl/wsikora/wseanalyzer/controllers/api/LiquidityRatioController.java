package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.LiquidityRatio;
import pl.wsikora.wseanalyzer.services.LiquidityRatioService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/liquidity_ratios")
public class LiquidityRatioController implements REST<LiquidityRatio> {

    private final LiquidityRatioService service;

    public LiquidityRatioController(LiquidityRatioService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<LiquidityRatio>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<LiquidityRatio> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<LiquidityRatio> create(LiquidityRatio liquidityRatio) {
        LiquidityRatio newLiquidityRatio = service.create(liquidityRatio);
        return ResponseEntity.created(makeNewUri(newLiquidityRatio.getId()))
                .body(newLiquidityRatio);
    }

    @Override
    public ResponseEntity<LiquidityRatio> update(long id, LiquidityRatio liquidityRatio) {
        return ResponseEntity.ok(service.update(id, liquidityRatio));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
