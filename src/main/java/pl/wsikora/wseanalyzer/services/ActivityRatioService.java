package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.ActivityRatio;

import java.util.List;
import java.util.Optional;

public interface ActivityRatioService {

    List<ActivityRatio> getPart(Pageable pageable);

    Optional<ActivityRatio> getSingle(long id);

    ActivityRatio create(ActivityRatio activityRatio);

    ActivityRatio update(long id, ActivityRatio activityRatio);

    void delete(long id);

}
