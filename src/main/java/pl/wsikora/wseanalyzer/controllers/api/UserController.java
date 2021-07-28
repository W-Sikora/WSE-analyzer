package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.User;
import pl.wsikora.wseanalyzer.services.UserService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController implements REST<User> {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<User>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<User> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<User> create(User user) {
        User newUser = service.create(user);
        return ResponseEntity.created(makeNewUri(newUser))
                .body(newUser);
    }

    @Override
    public ResponseEntity<User> update(long id, User user) {
        return ResponseEntity.ok(service.update(id, user));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
