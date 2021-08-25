package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.User;
import pl.wsikora.wseanalyzer.repositories.UserRepository;

@Service
public class UserServiceImpl extends CrudServiceImpl<User> implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
