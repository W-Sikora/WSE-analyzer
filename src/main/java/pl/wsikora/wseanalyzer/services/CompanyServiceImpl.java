package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.Company;
import pl.wsikora.wseanalyzer.repositories.CompanyRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class CompanyServiceImpl extends CrudServiceImpl<Company> implements CompanyService {

    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public Company update(long id, Company company) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, company)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
