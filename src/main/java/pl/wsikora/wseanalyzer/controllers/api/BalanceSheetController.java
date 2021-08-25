package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.BalanceSheet;
import pl.wsikora.wseanalyzer.services.BalanceSheetService;

@RestController
@RequestMapping(value = "/api/v1/balance_sheets")
public class BalanceSheetController extends CrudController<BalanceSheet> {

    private final BalanceSheetService service;

    public BalanceSheetController(BalanceSheetService service) {
        super(service);
        this.service = service;
    }

}
