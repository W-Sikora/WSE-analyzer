package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.Price;
import pl.wsikora.wseanalyzer.services.PriceService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/prices")
public class PriceController implements REST<Price> {

    private final PriceService service;

    public PriceController(PriceService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Price>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<Price> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<Price> create(Price price) {
        Price newPrice = service.create(price);
        return ResponseEntity.created(makeNewUri(newPrice.getId()))
                .body(newPrice);
    }

    @Override
    public ResponseEntity<Price> update(long id, Price price) {
        return ResponseEntity.ok(service.update(id, price));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
