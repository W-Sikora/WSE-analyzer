package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.Company;
import pl.wsikora.wseanalyzer.repositories.CompanyRepository;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Company> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<Company> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public Company create(Company company) {
        return repository.save(company);
    }

    @Override
    @Transactional
    public Company update(long id, Company company) {
        return repository.findById(id)
                .map(updatedCompany -> {
                    updatedCompany.setBankerAcronym(company.getBankerAcronym());
                    updatedCompany.setBusinessRadarAcronym(company.getBusinessRadarAcronym());
                    updatedCompany.setTicker(company.getTicker());
                    updatedCompany.setName(company.getName());
                    updatedCompany.setIsin(company.getIsin());
                    return updatedCompany;
                })
                .orElseThrow(() -> new ResourceNotFoundException(Company.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(Company.class, id);
        }
    }

}
