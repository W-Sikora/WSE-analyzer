package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.services.CompanyGeneralInfoService;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/companies_general_info", produces = "application/json")
public class CompanyGeneralInfoController implements REST<CompanyGeneralInfo> {

    private final CompanyGeneralInfoService service;

    public CompanyGeneralInfoController(CompanyGeneralInfoService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<CompanyGeneralInfo>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<CompanyGeneralInfo> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<CompanyGeneralInfo> create(CompanyGeneralInfo companyGeneralInfo) {
        CompanyGeneralInfo newCompanyGeneralInfo = service.create(companyGeneralInfo);
        return ResponseEntity.created(makeNewUri(newCompanyGeneralInfo.getId()))
                .body(newCompanyGeneralInfo);
    }

    @Override
    public ResponseEntity<CompanyGeneralInfo> update(long id, CompanyGeneralInfo companyGeneralInfo) {
        return ResponseEntity.ok(service.update(id, companyGeneralInfo));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
