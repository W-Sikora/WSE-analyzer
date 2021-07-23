package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.CompanyInfo;
import pl.wsikora.wseanalyzer.services.CompanyInfoService;

import java.util.List;


@RestController
@RequestMapping(value = "api/v1/companies_info", produces = "application/json")
public class CompanyInfoController implements REST<CompanyInfo> {

    private final CompanyInfoService service;

    public CompanyInfoController(CompanyInfoService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<CompanyInfo>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<CompanyInfo> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<CompanyInfo> create(CompanyInfo companyInfo) {
        CompanyInfo newCompanyInfo = service.create(companyInfo);
        return ResponseEntity.created(makeNewUri(newCompanyInfo.getId()))
                .body(newCompanyInfo);
    }

    @Override
    public ResponseEntity<CompanyInfo> update(long id, CompanyInfo companyInfo) {
        return ResponseEntity.ok(service.update(id, companyInfo));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
