package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.ActivityTag;
import pl.wsikora.wseanalyzer.repositories.ActivityTagRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ActivityTagServiceImpl implements ActivityTagService {

    private final ActivityTagRepository repository;

    public ActivityTagServiceImpl(ActivityTagRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ActivityTag> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<ActivityTag> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public ActivityTag create(ActivityTag activityTag) {
        return repository.save(activityTag);
    }

    @Override
    public ActivityTag update(long id, ActivityTag activityTag) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(activityTag)))
                .orElseThrow(() -> new ResourceNotFoundException(ActivityTag.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(ActivityTag.class, id);
        }
    }

}
