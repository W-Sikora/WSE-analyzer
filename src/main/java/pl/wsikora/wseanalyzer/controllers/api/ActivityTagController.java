package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.ActivityTag;
import pl.wsikora.wseanalyzer.services.ActivityTagService;

@RestController
@RequestMapping(value = "/api/v1/activity_tags")
public class ActivityTagController extends CrudController<ActivityTag> {

    private final ActivityTagService service;

    public ActivityTagController(ActivityTagService service) {
        super(service);
        this.service = service;
    }

}
