package pl.wsikora.wseanalyzer.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.User;
import pl.wsikora.wseanalyzer.repositories.UserRepository;

@Service
public class UserServiceImpl extends CrudServiceImpl<User> implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
        super(repository);
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public User update(long id, User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return super.update(id, user);
    }

    @Override
    public User create(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return super.create(user);
    }

}
