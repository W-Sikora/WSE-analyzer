package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.Rating;
import pl.wsikora.wseanalyzer.services.RatingService;

@RestController
@RequestMapping(value = "/api/v1/ratings")
public class RatingController extends CrudController<Rating> {

    private final RatingService service;

    public RatingController(RatingService service) {
        super(service);
        this.service = service;
    }

}
