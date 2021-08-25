package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.Price;
import pl.wsikora.wseanalyzer.services.PriceService;

@RestController
@RequestMapping(value = "/api/v1/prices")
public class PriceController extends CrudController<Price> {

    private final PriceService service;

    public PriceController(PriceService service) {
        super(service);
        this.service = service;
    }

}
