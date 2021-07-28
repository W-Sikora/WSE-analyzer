package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.IncomeStatement;
import pl.wsikora.wseanalyzer.services.IncomeStatementService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/income_statements")
public class IncomeStatementController implements REST<IncomeStatement> {

    private final IncomeStatementService service;

    public IncomeStatementController(IncomeStatementService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<IncomeStatement>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<IncomeStatement> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<IncomeStatement> create(IncomeStatement incomeStatement) {
        IncomeStatement newIncomeStatement = service.create(incomeStatement);
        return ResponseEntity.created(makeNewUri(newIncomeStatement))
                .body(newIncomeStatement);
    }

    @Override
    public ResponseEntity<IncomeStatement> update(long id, IncomeStatement incomeStatement) {
        return ResponseEntity.ok(service.update(id, incomeStatement));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
