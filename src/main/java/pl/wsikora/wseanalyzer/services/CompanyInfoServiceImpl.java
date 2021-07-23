package pl.wsikora.wseanalyzer.services;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.CompanyInfo;
import pl.wsikora.wseanalyzer.repositories.CompanyInfoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    private final CompanyInfoRepository repository;

    public CompanyInfoServiceImpl(CompanyInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CompanyInfo> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<CompanyInfo> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public CompanyInfo create(CompanyInfo companyInfo) {
        return repository.save(companyInfo);
    }

    @Override
    @Transactional
    public CompanyInfo update(long id, CompanyInfo companyInfo) {
        return repository.findById(id)
                .map(existing -> repository.save(existing.merge(companyInfo)))
                .orElseThrow(() -> new ResourceNotFoundException(CompanyInfo.class, id));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(CompanyInfo.class, id);
        }
    }

}
