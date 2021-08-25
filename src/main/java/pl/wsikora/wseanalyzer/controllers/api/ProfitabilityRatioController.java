package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.ProfitabilityRatio;
import pl.wsikora.wseanalyzer.services.ProfitabilityRatioService;

@RestController
@RequestMapping(value = "/api/v1/profitability_ratios")
public class ProfitabilityRatioController extends CrudController<ProfitabilityRatio> {

    private final ProfitabilityRatioService service;

    public ProfitabilityRatioController(ProfitabilityRatioService service) {
        super(service);
        this.service = service;
    }

}
