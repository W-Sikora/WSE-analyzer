package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.BalanceSheet;
import pl.wsikora.wseanalyzer.services.BalanceSheetService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/balance_sheets")
public class BalanceSheetController implements REST<BalanceSheet> {

    private final BalanceSheetService service;

    public BalanceSheetController(BalanceSheetService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<BalanceSheet>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<BalanceSheet> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<BalanceSheet> create(BalanceSheet balanceSheet) {
        BalanceSheet newBalanceSheet = service.create(balanceSheet);
        return ResponseEntity.created(makeNewUri(newBalanceSheet))
                .body(newBalanceSheet);
    }

    @Override
    public ResponseEntity<BalanceSheet> update(long id, BalanceSheet balanceSheet) {
        return ResponseEntity.ok(service.update(id, balanceSheet));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
