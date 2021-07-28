package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.DebtRatio;
import pl.wsikora.wseanalyzer.services.DebtRatioService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/debt_ratios")
public class DebtRatioController implements REST<DebtRatio> {

    private final DebtRatioService service;

    public DebtRatioController(DebtRatioService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<DebtRatio>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<DebtRatio> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<DebtRatio> create(DebtRatio debtRatio) {
        DebtRatio newDebtRatio = service.create(debtRatio);
        return ResponseEntity.created(makeNewUri(newDebtRatio))
                .body(newDebtRatio);
    }

    @Override
    public ResponseEntity<DebtRatio> update(long id, DebtRatio debtRatio) {
        return ResponseEntity.ok(service.update(id, debtRatio));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
