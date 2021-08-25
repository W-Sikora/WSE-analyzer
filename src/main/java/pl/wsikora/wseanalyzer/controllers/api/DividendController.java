package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.Dividend;
import pl.wsikora.wseanalyzer.services.DividendService;

@RestController
@RequestMapping(value = "/api/v1/dividends")
public class DividendController extends CrudController<Dividend> {

    private final DividendService service;

    public DividendController(DividendService service) {
        super(service);
        this.service = service;
    }

}
