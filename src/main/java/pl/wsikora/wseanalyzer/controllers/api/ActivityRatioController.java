package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.ActivityRatio;
import pl.wsikora.wseanalyzer.services.ActivityRatioService;

@RestController
@RequestMapping(value = "/api/v1/activity_ratios")
public class ActivityRatioController extends CrudController<ActivityRatio> {

    private final ActivityRatioService service;

    public ActivityRatioController(ActivityRatioService service) {
        super(service);
        this.service = service;
    }

}
