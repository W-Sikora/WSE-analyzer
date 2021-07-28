package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.CashFlowStatement;
import pl.wsikora.wseanalyzer.services.CashFlowStatementService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cash_flow_statements")
public class CashFlowStatementController implements REST<CashFlowStatement> {

    private final CashFlowStatementService service;

    public CashFlowStatementController(CashFlowStatementService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<CashFlowStatement>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<CashFlowStatement> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<CashFlowStatement> create(CashFlowStatement cashFlowStatement) {
        CashFlowStatement newCashFlowStatement = service.create(cashFlowStatement);
        return ResponseEntity.created(makeNewUri(newCashFlowStatement))
                .body(newCashFlowStatement);
    }

    @Override
    public ResponseEntity<CashFlowStatement> update(long id, CashFlowStatement cashFlowStatement) {
        return ResponseEntity.ok(service.update(id, cashFlowStatement));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
