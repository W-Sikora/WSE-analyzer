package pl.wsikora.wseanalyzer.services.company.impl;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.repositories.company.CompanyRepository;
import pl.wsikora.wseanalyzer.services.company.CompanyService;

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
        Company updatedCompany = repository.findById(id).get();
        updatedCompany.setBankerAcronym(company.getBankerAcronym());
        updatedCompany.setBusinessRadarAcronym(company.getBusinessRadarAcronym());
        updatedCompany.setTicker(company.getTicker());
        updatedCompany.setName(company.getName());
        updatedCompany.setIsin(company.getIsin());
        return updatedCompany;
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean exist(long id) {
        return repository.existsById(id);
    }

}
