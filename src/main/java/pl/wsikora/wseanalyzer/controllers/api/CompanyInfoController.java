package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.CompanyInfo;
import pl.wsikora.wseanalyzer.services.CompanyInfoService;

@RestController
@RequestMapping(value = "api/v1/companies_info", produces = "application/json")
public class CompanyInfoController extends CrudController<CompanyInfo> {

    private final CompanyInfoService service;

    public CompanyInfoController(CompanyInfoService service) {
        super(service);
        this.service = service;
    }

}
