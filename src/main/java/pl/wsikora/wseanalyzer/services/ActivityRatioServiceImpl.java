package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.ActivityRatio;
import pl.wsikora.wseanalyzer.repositories.ActivityRatioRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityRatioServiceImpl implements ActivityRatioService {

    private final ActivityRatioRepository repository;

    public ActivityRatioServiceImpl(ActivityRatioRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ActivityRatio> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<ActivityRatio> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public ActivityRatio create(ActivityRatio activityRatio) {
        return repository.save(activityRatio);
    }

    @Override
    @Transactional
    public ActivityRatio update(long id, ActivityRatio activityRatio) {
        return repository.findById(id)
                .map(updatedActivityRatio -> {
                    return updatedActivityRatio;
                })
                .orElseThrow(() -> new ResourceNotFoundException(ActivityRatio.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(ActivityRatio.class, id);
        }
    }

}
