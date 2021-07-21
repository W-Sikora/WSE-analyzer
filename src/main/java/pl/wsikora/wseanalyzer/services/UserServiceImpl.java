package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.User;
import pl.wsikora.wseanalyzer.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<User> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public User create(User user) {
        return repository.save(user);
    }

    @Override
    public User update(long id, User user) {
        return repository.findById(id)
                .map(updatedUser -> {
                    return updatedUser;
                })
                .orElseThrow(() -> new ResourceNotFoundException(User.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(User.class, id);
        }
    }

}
