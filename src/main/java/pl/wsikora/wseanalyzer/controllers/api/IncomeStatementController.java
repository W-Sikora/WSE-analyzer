package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.IncomeStatement;
import pl.wsikora.wseanalyzer.services.IncomeStatementService;

@RestController
@RequestMapping(value = "/api/v1/income_statements")
public class IncomeStatementController extends CrudController<IncomeStatement> {

    private final IncomeStatementService service;

    public IncomeStatementController(IncomeStatementService service) {
        super(service);
        this.service = service;
    }

}
