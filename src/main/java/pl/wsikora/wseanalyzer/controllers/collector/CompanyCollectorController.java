package pl.wsikora.wseanalyzer.controllers.collector;

import org.jsoup.nodes.Document;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.wsikora.wseanalyzer.services.CompanyService;
import pl.wsikora.wseanalyzer.util.collector.Utils;

import java.util.List;

@Controller
@RequestMapping("/")
public class CompanyCollectorController {

    private final CompanyService service;

    public CompanyCollectorController(CompanyService service) {
        this.service = service;
    }


}
