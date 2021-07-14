package pl.wsikora.wseanalyzer.services.company;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.controllers.api.exception.ResourceNotFoundException;
import pl.wsikora.wseanalyzer.model.company.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.repositories.company.CompanyGeneralInfoRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyGeneralInfoServiceImpl implements CompanyGeneralInfoService {

    private final CompanyGeneralInfoRepository repository;

    public CompanyGeneralInfoServiceImpl(CompanyGeneralInfoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<CompanyGeneralInfo> getPart(Pageable pageable) {
        return repository.findAll(pageable)
                .toList();
    }

    @Override
    public Optional<CompanyGeneralInfo> getSingle(long id) {
        return repository.findById(id);
    }

    @Override
    public CompanyGeneralInfo create(CompanyGeneralInfo companyGeneralInfo) {
        return repository.save(companyGeneralInfo);
    }

    @Override
    @Transactional
    public CompanyGeneralInfo update(long id, CompanyGeneralInfo companyGeneralInfo) {
        return repository.findById(id)
                .map(updatedCompanyGeneralInfo -> {
                    updatedCompanyGeneralInfo.setCeo(companyGeneralInfo.getCeo());
                    updatedCompanyGeneralInfo.setCompany(companyGeneralInfo.getCompany());
                    updatedCompanyGeneralInfo.setDebutDate(companyGeneralInfo.getDebutDate());
                    updatedCompanyGeneralInfo.setLocation(companyGeneralInfo.getLocation());
                    updatedCompanyGeneralInfo.setSharesNumber(companyGeneralInfo.getSharesNumber());
                    return updatedCompanyGeneralInfo;
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