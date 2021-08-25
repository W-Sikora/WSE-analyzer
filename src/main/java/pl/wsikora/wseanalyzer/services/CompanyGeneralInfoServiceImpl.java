package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.CompanyGeneralInfo;
import pl.wsikora.wseanalyzer.repositories.CompanyGeneralInfoRepository;

@Service
public class CompanyGeneralInfoServiceImpl extends CrudServiceImpl<CompanyGeneralInfo> implements CompanyGeneralInfoService {

    private final CompanyGeneralInfoRepository repository;

    public CompanyGeneralInfoServiceImpl(CompanyGeneralInfoRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
