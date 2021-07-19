package pl.wsikora.wseanalyzer.controllers.api.dividend;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.controllers.api.REST;
import pl.wsikora.wseanalyzer.model.dividend.Dividend;
import pl.wsikora.wseanalyzer.services.dividend.DividendService;

import java.util.List;

import static pl.wsikora.wseanalyzer.util.Utils.makeNewUri;

@RestController
@RequestMapping(value = "/api/v1/dividends")
public class DividendController implements REST<Dividend> {

    private final DividendService service;

    public DividendController(DividendService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Dividend>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<Dividend> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<Dividend> create(Dividend dividend) {
        Dividend createdDividend = service.create(dividend);
        return ResponseEntity.created(makeNewUri(createdDividend.getId()))
                .body(createdDividend);
    }

    @Override
    public ResponseEntity<Dividend> update(long id, Dividend dividend) {
        return ResponseEntity.ok(service.update(id, dividend));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
