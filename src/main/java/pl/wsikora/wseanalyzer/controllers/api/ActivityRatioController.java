package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.ActivityRatio;
import pl.wsikora.wseanalyzer.services.ActivityRatioService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/activity_ratios")
public class ActivityRatioController implements REST<ActivityRatio> {

    private final ActivityRatioService service;

    public ActivityRatioController(ActivityRatioService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<ActivityRatio>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<ActivityRatio> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<ActivityRatio> create(ActivityRatio activityRatio) {
        ActivityRatio createdActivityRatio = service.create(activityRatio);
        return ResponseEntity.created(makeNewUri(createdActivityRatio))
                .body(createdActivityRatio);
    }

    @Override
    public ResponseEntity<ActivityRatio> update(long id, ActivityRatio activityRatio) {
        return ResponseEntity.ok(service.update(id, activityRatio));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
