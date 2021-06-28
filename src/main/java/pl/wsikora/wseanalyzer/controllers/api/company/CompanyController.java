package pl.wsikora.wseanalyzer.controllers.api.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.dto.company.CompanyDTO;
import pl.wsikora.wseanalyzer.model.company.Company;


@RestController
@RequestMapping(value = "api/v1/companies", produces = "application/json")
public class CompanyController {

    @GetMapping
    public ResponseEntity<?> getAll() {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping("/{id}/general")
    public ResponseEntity<?> getGeneralInfo(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Company company) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Company company) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

}
