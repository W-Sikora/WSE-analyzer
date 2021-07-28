package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.controllers.api.REST;
import pl.wsikora.wseanalyzer.model.Popularity;
import pl.wsikora.wseanalyzer.services.PopularityService;
import pl.wsikora.wseanalyzer.services.PopularityServiceImpl;

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
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<Popularity> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<Popularity> create(Popularity popularity) {
        Popularity newPopularity = service.create(popularity);
        return ResponseEntity.created(makeNewUri(newPopularity))
                .body(newPopularity);
    }

    @Override
    public ResponseEntity<Popularity> update(long id, Popularity popularity) {
        return ResponseEntity.ok(service.update(id, popularity));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
