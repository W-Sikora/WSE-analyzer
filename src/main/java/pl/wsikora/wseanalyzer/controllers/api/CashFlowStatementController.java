package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.CashFlowStatement;
import pl.wsikora.wseanalyzer.services.CashFlowStatementService;

@RestController
@RequestMapping(value = "/api/v1/cash_flow_statements")
public class CashFlowStatementController extends CrudController<CashFlowStatement> {

    private final CashFlowStatementService service;

    public CashFlowStatementController(CashFlowStatementService service) {
        super(service);
        this.service = service;
    }

}
