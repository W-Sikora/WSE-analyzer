package pl.wsikora.wseanalyzer.services.company;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.company.CompanyInfo;
import pl.wsikora.wseanalyzer.repositories.company.CompanyInfoRepository;

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
                .map(updateCompanyInfo -> {
                    updateCompanyInfo.setIndustry(companyInfo.getIndustry());
                    updateCompanyInfo.setActivityTags(companyInfo.getActivityTags());
                    updateCompanyInfo.setCompany(companyInfo.getCompany());
                    updateCompanyInfo.setStockExchange(companyInfo.getStockExchange());
                    return updateCompanyInfo;
                })
                .orElseThrow(() -> new ResourceNotFoundException(String.format("CompanyInfo with id %d not found", id)));
    }

    @Override
    public void delete(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(String.format("CompanyInfo with id %d not found", id));
        }
    }

}
