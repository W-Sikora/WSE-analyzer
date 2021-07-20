package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.CompanyInfo;
import pl.wsikora.wseanalyzer.services.CompanyInfoService;

import java.util.List;

import static pl.wsikora.wseanalyzer.util.Utils.makeNewUri;


@RestController
@RequestMapping(value = "api/v1/companies_info", produces = "application/json")
public class CompanyInfoController {

    private final CompanyInfoService service;

    public CompanyInfoController(CompanyInfoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CompanyInfo>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyInfo> getSingle(@PathVariable long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @PostMapping
    public ResponseEntity<CompanyInfo> create(@RequestBody CompanyInfo companyInfo) {
        CompanyInfo createdCompany = service.create(companyInfo);
        return ResponseEntity.created(makeNewUri(createdCompany.getId()))
                .body(createdCompany);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompanyInfo> update(@PathVariable long id, @RequestBody CompanyInfo companyInfo) {
        return ResponseEntity.ok(service.update(id, companyInfo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CompanyInfo> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
