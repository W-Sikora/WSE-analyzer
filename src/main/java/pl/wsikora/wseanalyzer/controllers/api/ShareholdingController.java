package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.Shareholding;
import pl.wsikora.wseanalyzer.services.ShareholdingService;

@RestController
@RequestMapping(value = "/api/v1/shareholdings")
public class ShareholdingController extends CrudController<Shareholding> {

    private final ShareholdingService service;

    public ShareholdingController(ShareholdingService service) {
        super(service);
        this.service = service;
    }

}
