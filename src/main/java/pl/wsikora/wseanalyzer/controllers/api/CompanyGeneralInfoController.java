package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.services.CompanyGeneralInfoService;

@RestController
@RequestMapping(value = "api/v1/companies_general_info", produces = "application/json")
public class CompanyGeneralInfoController extends CrudController<CompanyGeneralInfo> {

    private final CompanyGeneralInfoService service;

    public CompanyGeneralInfoController(CompanyGeneralInfoService service) {
        super(service);
        this.service = service;
    }

}
