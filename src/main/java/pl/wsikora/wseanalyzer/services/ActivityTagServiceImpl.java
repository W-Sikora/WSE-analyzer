package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.ActivityTag;
import pl.wsikora.wseanalyzer.repositories.ActivityTagRepository;

@Service
public class ActivityTagServiceImpl extends CrudServiceImpl<ActivityTag> implements ActivityTagService {

    private final ActivityTagRepository repository;

    public ActivityTagServiceImpl(ActivityTagRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
