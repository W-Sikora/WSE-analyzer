package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.MarketValueRatio;
import pl.wsikora.wseanalyzer.services.MarketValueRatioService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/market_value_ratios")
public class MarketValueRatioController implements REST<MarketValueRatio> {

    private final MarketValueRatioService service;

    public MarketValueRatioController(MarketValueRatioService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<MarketValueRatio>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<MarketValueRatio> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<MarketValueRatio> create(MarketValueRatio marketValueRatio) {
        MarketValueRatio newMarketValueRatio = service.create(marketValueRatio);
        return ResponseEntity.created(makeNewUri(marketValueRatio.getId()))
                .body(newMarketValueRatio);
    }

    @Override
    public ResponseEntity<MarketValueRatio> update(long id, MarketValueRatio marketValueRatio) {
        return ResponseEntity.ok(service.update(id, marketValueRatio));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
