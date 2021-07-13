package pl.wsikora.wseanalyzer.controllers.api.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.services.company.CompanyService;

import java.util.List;

import static pl.wsikora.wseanalyzer.util.Utils.makeNewUri;


@RestController
@RequestMapping(value = "api/v1/companies", produces = "application/json")
public class CompanyController {

    private final CompanyService service;

    public CompanyController(CompanyService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getPart(Pageable pageable) {
        return ResponseEntity.ok(service.getPart(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getSingle(@PathVariable long id) {
        return ResponseEntity.of(service.getSingle(id));
    }

    @PostMapping
    public ResponseEntity<Company> create(@RequestBody Company company) {
        Company createdCompany = service.create(company);
        return ResponseEntity.created(makeNewUri(createdCompany.getId()))
                .body(createdCompany);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable long id, @RequestBody Company company) {
        return ResponseEntity.ok(service.update(id, company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Company> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

}
