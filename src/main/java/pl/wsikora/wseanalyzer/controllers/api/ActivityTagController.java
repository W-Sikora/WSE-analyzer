package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.ActivityTag;
import pl.wsikora.wseanalyzer.services.ActivityTagService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/activity_tags")
public class ActivityTagController implements REST<ActivityTag> {

    private final ActivityTagService service;

    public ActivityTagController(ActivityTagService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<ActivityTag>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<ActivityTag> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<ActivityTag> create(ActivityTag activityTag) {
        ActivityTag newActivityTag = service.create(activityTag);
        return ResponseEntity.created(makeNewUri(newActivityTag.getId()))
                .body(newActivityTag);
    }

    @Override
    public ResponseEntity<ActivityTag> update(long id, ActivityTag activityTag) {
        return ResponseEntity.ok(service.update(id, activityTag));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
