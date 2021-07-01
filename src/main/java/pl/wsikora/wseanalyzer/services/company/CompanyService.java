package pl.wsikora.wseanalyzer.services.company;

import pl.wsikora.wseanalyzer.model.company.Company;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface CompanyService {

    List<Company> getAll(Pageable pageable);

    Optional<Company> getOne(long id);

    void create(Company company);

    void update(long id, Company newCompany);

    void delete(long id);

}
