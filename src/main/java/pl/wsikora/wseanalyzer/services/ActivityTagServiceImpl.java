package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.ActivityTag;
import pl.wsikora.wseanalyzer.repositories.ActivityTagRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class ActivityTagServiceImpl extends CrudServiceImpl<ActivityTag> implements ActivityTagService {

    private final ActivityTagRepository repository;

    public ActivityTagServiceImpl(ActivityTagRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public ActivityTag update(long id, ActivityTag activityTag) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, activityTag)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
