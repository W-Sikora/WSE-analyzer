package pl.wsikora.wseanalyzer.controllers.api.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.wsikora.wseanalyzer.controllers.api.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.services.company.CompanyService;

import org.springframework.data.domain.Pageable;

import java.net.URI;
import java.util.List;


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
        return ResponseEntity.created(makeNewUri(createdCompany))
                .body(createdCompany);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> update(@PathVariable long id, @RequestBody Company company) {
        verify(id);
        return ResponseEntity.ok(service.update(id, company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Company> delete(@PathVariable long id) {
        verify(id);
        service.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

    private void verify(long id) throws ResourceNotFoundException {
        if (!service.exist(id)) {
            throw new ResourceNotFoundException("Company with id " + id + " not found");
        }
    }

    private URI makeNewUri(Company company) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(company.getId())
                .toUri();
    }

}
