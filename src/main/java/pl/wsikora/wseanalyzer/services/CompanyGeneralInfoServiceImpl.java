package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.repositories.CompanyGeneralInfoRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class CompanyGeneralInfoServiceImpl extends CrudServiceImpl<CompanyGeneralInfo> implements CompanyGeneralInfoService {

    private final CompanyGeneralInfoRepository repository;

    public CompanyGeneralInfoServiceImpl(CompanyGeneralInfoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public CompanyGeneralInfo update(long id, CompanyGeneralInfo companyGeneralInfo) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, companyGeneralInfo)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
