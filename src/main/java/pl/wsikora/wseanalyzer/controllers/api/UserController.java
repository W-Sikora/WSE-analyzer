package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.User;
import pl.wsikora.wseanalyzer.services.UserService;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController extends CrudController<User> {

    private final UserService service;

    public UserController(UserService service) {
        super(service);
        this.service = service;
    }

}
