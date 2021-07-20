package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getPart(Pageable pageable);

    Optional<User> getSingle(long id);

    User create(User user);

    User update(long id, User user);

    void delete(long id);

}
