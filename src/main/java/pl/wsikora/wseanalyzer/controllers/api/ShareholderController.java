package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.wsikora.wseanalyzer.model.Shareholder;
import pl.wsikora.wseanalyzer.services.ShareholderService;

@RestController
@RequestMapping(value = "/api/v1/shareholders")
public class ShareholderController extends CrudController<Shareholder> {

    private final ShareholderService service;

    public ShareholderController(ShareholderService service) {
        super(service);
        this.service = service;
    }

}
