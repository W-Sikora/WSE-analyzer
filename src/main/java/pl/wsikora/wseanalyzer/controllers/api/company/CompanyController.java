package pl.wsikora.wseanalyzer.controllers.api.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.dto.company.CompanyDTO;
import pl.wsikora.wseanalyzer.model.company.Company;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @GetMapping
    public List<Company> getAll() {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDTO> getOne(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @GetMapping("/{id}/general")
    public ResponseEntity<CompanyDTO> getGeneralInfo(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Company company) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @PutMapping("/{id}")
    public Company update(@PathVariable long id, @RequestBody Company company) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

}
