package pl.wsikora.wseanalyzer.controllers.api.company;

import org.springframework.web.bind.annotation.*;
import pl.wsikora.wseanalyzer.model.company.Company;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @GetMapping
    public List<Company> getAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Company getOne(@PathVariable long id) {
        return null;
    }

    @PostMapping
    public Company create(@RequestBody Company company) {
        return null;
    }

    @PutMapping("/{id}")
    public Company update(@PathVariable long id, @RequestBody Company company) {
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable long id) {

    }

}
