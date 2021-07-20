package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.services.CompanyGeneralInfoService;

import java.util.List;

import static pl.wsikora.wseanalyzer.util.Utils.makeNewUri;


@RestController
@RequestMapping(value = "api/v1/companies_general_info", produces = "application/json")
public class CompanyGeneralInfoController {

    private final CompanyGeneralInfoService service;

    public CompanyGeneralInfoController(CompanyGeneralInfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CompanyGeneralInfo>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyGeneralInfo> getSingle(@PathVariable long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @PostMapping
    public ResponseEntity<CompanyGeneralInfo> create(@RequestBody CompanyGeneralInfo companyGeneralInfo) {
        CompanyGeneralInfo createdCompany = service.create(companyGeneralInfo);
        return ResponseEntity.created(makeNewUri(createdCompany.getId()))
                .body(createdCompany);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyGeneralInfo> update(@PathVariable long id, @RequestBody CompanyGeneralInfo companyGeneralInfo) {
        return ResponseEntity.ok(service.update(id, companyGeneralInfo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CompanyGeneralInfo> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
