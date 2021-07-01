package pl.wsikora.wseanalyzer.services.company.impl;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.company.Company;
import pl.wsikora.wseanalyzer.services.company.CompanyService;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Override
    public List<Company> getAll(Pageable pageable) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @Override
    public Optional<Company> getOne(long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @Override
    public void create(Company company) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @Override
    public void update(long id, Company newCompany) {
        throw new IllegalArgumentException("not implemented yet");
    }

    @Override
    public void delete(long id) {
        throw new IllegalArgumentException("not implemented yet");
    }

}
