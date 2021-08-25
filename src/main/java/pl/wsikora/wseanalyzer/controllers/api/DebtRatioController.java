package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.DebtRatio;
import pl.wsikora.wseanalyzer.services.DebtRatioService;

@RestController
@RequestMapping(value = "/api/v1/debt_ratios")
public class DebtRatioController extends CrudController<DebtRatio> {

    private final DebtRatioService service;

    public DebtRatioController(DebtRatioService service) {
        super(service);
        this.service = service;
    }

}
