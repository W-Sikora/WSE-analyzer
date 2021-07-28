package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.DividendRatio;
import pl.wsikora.wseanalyzer.services.DividendRatioService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/dividend_ratios")
public class DividendRatioController implements REST<DividendRatio> {

    private final DividendRatioService service;

    public DividendRatioController(DividendRatioService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<DividendRatio>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<DividendRatio> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<DividendRatio> create(DividendRatio dividendRatio) {
        DividendRatio newDividendRatio = service.create(dividendRatio);
        return ResponseEntity.created(makeNewUri(newDividendRatio))
                .body(newDividendRatio);
    }

    @Override
    public ResponseEntity<DividendRatio> update(long id, DividendRatio dividendRatio) {
        return ResponseEntity.ok(service.update(id, dividendRatio));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
