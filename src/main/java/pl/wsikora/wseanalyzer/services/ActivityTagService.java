package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.ActivityTag;

import java.util.List;
import java.util.Optional;

public interface ActivityTagService {

    List<ActivityTag> getPart(Pageable pageable);

    Optional<ActivityTag> getSingle(long id);

    ActivityTag create(ActivityTag activityTag);

    ActivityTag update(long id, ActivityTag activityTag);

    void delete(long id);

}
