package pl.wsikora.wseanalyzer.controllers.collector;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.wseanalyzer.services.CompanyService;

@Controller
@RequestMapping("collector/companies")
public class CompanyCollectorController {

    private final CompanyService service;

    public CompanyCollectorController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public void save() {

    }




}
