package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.MarketValueRatio;
import pl.wsikora.wseanalyzer.services.MarketValueRatioService;

@RestController
@RequestMapping(value = "/api/v1/market_value_ratios")
public class MarketValueRatioController extends CrudController<MarketValueRatio> {

    private final MarketValueRatioService service;

    public MarketValueRatioController(MarketValueRatioService service) {
        super(service);
        this.service = service;
    }

}
