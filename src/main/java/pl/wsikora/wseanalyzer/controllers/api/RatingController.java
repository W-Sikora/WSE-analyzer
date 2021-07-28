package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.Rating;
import pl.wsikora.wseanalyzer.services.RatingService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/ratings")
public class RatingController implements REST<Rating> {

    private final RatingService service;

    public RatingController(RatingService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Rating>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<Rating> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<Rating> create(Rating rating) {
        Rating newRating = service.create(rating);
        return ResponseEntity.created(makeNewUri(newRating))
                .body(newRating);
    }

    @Override
    public ResponseEntity<Rating> update(long id, Rating rating) {
        return ResponseEntity.ok(service.update(id, rating));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
