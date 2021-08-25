package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.Company;
import pl.wsikora.wseanalyzer.services.CompanyService;

@RestController
@RequestMapping(value = "api/v1/companies", produces = "application/json")
public class CompanyController extends CrudController<Company> {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        super(service);
        this.service = service;
    }

}
