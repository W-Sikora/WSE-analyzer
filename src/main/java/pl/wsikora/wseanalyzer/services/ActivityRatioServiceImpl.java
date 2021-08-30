package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.ActivityRatio;
import pl.wsikora.wseanalyzer.repositories.ActivityRatioRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class ActivityRatioServiceImpl extends CrudServiceImpl<ActivityRatio> implements ActivityRatioService {

    private final ActivityRatioRepository repository;

    public ActivityRatioServiceImpl(ActivityRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public ActivityRatio update(long id, ActivityRatio activityRatio) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, activityRatio)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
