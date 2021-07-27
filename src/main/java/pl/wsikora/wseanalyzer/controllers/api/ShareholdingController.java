package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.Shareholding;
import pl.wsikora.wseanalyzer.services.ShareholdingService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/shareholdings")
public class ShareholdingController implements REST<Shareholding> {

    private final ShareholdingService service;

    public ShareholdingController(ShareholdingService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Shareholding>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<Shareholding> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<Shareholding> create(Shareholding shareholding) {
        Shareholding newShareholding = service.create(shareholding);
        return ResponseEntity.created(makeNewUri(newShareholding.getId()))
                .body(newShareholding);
    }

    @Override
    public ResponseEntity<Shareholding> update(long id, Shareholding shareholding) {
        return ResponseEntity.ok(service.update(id, shareholding));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
