package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.LiquidityRatio;
import pl.wsikora.wseanalyzer.services.LiquidityRatioService;

@RestController
@RequestMapping(value = "/api/v1/liquidity_ratios")
public class LiquidityRatioController extends CrudController<LiquidityRatio> {

    private final LiquidityRatioService service;

    public LiquidityRatioController(LiquidityRatioService service) {
        super(service);
        this.service = service;
    }

}
