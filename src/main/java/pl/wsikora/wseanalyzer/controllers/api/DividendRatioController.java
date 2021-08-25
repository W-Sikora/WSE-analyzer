package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.DividendRatio;
import pl.wsikora.wseanalyzer.services.DividendRatioService;

@RestController
@RequestMapping(value = "/api/v1/dividend_ratios")
public class DividendRatioController extends CrudController<DividendRatio> {

    private final DividendRatioService service;

    public DividendRatioController(DividendRatioService service) {
        super(service);
        this.service = service;
    }

}
