package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.ActivityRatio;
import pl.wsikora.wseanalyzer.repositories.ActivityRatioRepository;

@Service
public class ActivityRatioServiceImpl extends CrudServiceImpl<ActivityRatio> implements ActivityRatioService {

    private final ActivityRatioRepository repository;

    public ActivityRatioServiceImpl(ActivityRatioRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
