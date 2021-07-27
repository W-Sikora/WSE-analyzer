package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.Shareholder;
import pl.wsikora.wseanalyzer.services.ShareholderService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/shareholders")
public class ShareholderController implements REST<Shareholder> {

    private final ShareholderService service;

    public ShareholderController(ShareholderService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Shareholder>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<Shareholder> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<Shareholder> create(Shareholder shareholder) {
        Shareholder newShareholder = service.create(shareholder);
        return ResponseEntity.created(makeNewUri(newShareholder.getId()))
                .body(newShareholder);
    }

    @Override
    public ResponseEntity<Shareholder> update(long id, Shareholder shareholder) {
        return ResponseEntity.ok(service.update(id, shareholder));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
