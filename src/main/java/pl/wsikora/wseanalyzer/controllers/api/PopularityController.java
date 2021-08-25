package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.Popularity;
import pl.wsikora.wseanalyzer.services.PopularityService;
import pl.wsikora.wseanalyzer.services.PopularityServiceImpl;

@RestController
@RequestMapping(value = "/api/v1/popularities")
public class PopularityController extends CrudController<Popularity> {

    private final PopularityService service;

    public PopularityController(PopularityServiceImpl service) {
        super(service);
        this.service = service;
    }

}
