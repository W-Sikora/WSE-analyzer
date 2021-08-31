package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Company;
import pl.wsikora.wseanalyzer.repositories.CompanyRepository;

@Service
public class CompanyServiceImpl extends CrudServiceImpl<Company> implements CompanyService {

    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
