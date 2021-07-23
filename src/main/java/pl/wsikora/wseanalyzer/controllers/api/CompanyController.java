package pl.wsikora.wseanalyzer.controllers.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.controllers.api.REST;
import pl.wsikora.wseanalyzer.model.Company;
import pl.wsikora.wseanalyzer.services.CompanyService;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/companies", produces = "application/json")
public class CompanyController implements REST<Company> {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<Company>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @Override
    public ResponseEntity<Company> getSingle(long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @Override
    public ResponseEntity<Company> create(Company company) {
        Company createdCompany = service.create(company);
        return ResponseEntity.created(makeNewUri(createdCompany.getId()))
                .body(createdCompany);
    }

    @Override
    public ResponseEntity<Company> update(long id, Company company) {
        return ResponseEntity.ok(service.update(id, company));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
