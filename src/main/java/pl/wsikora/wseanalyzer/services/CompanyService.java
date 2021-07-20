package pl.wsikora.wseanalyzer.services;

import pl.wsikora.wseanalyzer.model.Company;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> getPart(Pageable pageable);

    Optional<Company> getSingle(long id);

    Company create(Company company);

    Company update(long id, Company company);

    void delete(long id);

}
