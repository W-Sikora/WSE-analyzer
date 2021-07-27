package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.ProfitabilityRatio;
import pl.wsikora.wseanalyzer.services.ProfitabilityRatioService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/profitability_ratios")
public class ProfitabilityRatioController implements REST<ProfitabilityRatio> {

    private final ProfitabilityRatioService service;

    public ProfitabilityRatioController(ProfitabilityRatioService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<ProfitabilityRatio>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<ProfitabilityRatio> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<ProfitabilityRatio> create(ProfitabilityRatio profitabilityRatio) {
        ProfitabilityRatio newProfitabilityRatio = service.create(profitabilityRatio);
        return ResponseEntity.created(makeNewUri(newProfitabilityRatio.getId()))
                .body(newProfitabilityRatio);
    }

    @Override
    public ResponseEntity<ProfitabilityRatio> update(long id, ProfitabilityRatio profitabilityRatio) {
        return ResponseEntity.ok(service.update(id, profitabilityRatio));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
