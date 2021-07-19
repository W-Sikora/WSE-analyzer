package pl.wsikora.wseanalyzer.controllers.api.popularity;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.controllers.api.REST;
import pl.wsikora.wseanalyzer.model.popularity.Popularity;
import pl.wsikora.wseanalyzer.services.popularity.PopularityService;
import pl.wsikora.wseanalyzer.services.popularity.PopularityServiceImpl;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/popularities")
public class PopularityController implements REST<Popularity> {

    private final PopularityService service;

    public PopularityController(PopularityServiceImpl service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Popularity>> getPart(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<Popularity> getSingle(long id) {
        return null;
    }

    @Override
    public ResponseEntity<Popularity> create(Popularity popularity) {
        return null;
    }

    @Override
    public ResponseEntity<Popularity> update(long id, Popularity popularity) {
        return null;
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        return null;
    }

}
