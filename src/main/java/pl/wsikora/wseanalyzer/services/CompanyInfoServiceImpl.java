package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.CompanyInfo;
import pl.wsikora.wseanalyzer.repositories.CompanyInfoRepository;

@Service
public class CompanyInfoServiceImpl extends CrudServiceImpl<CompanyInfo> implements CompanyInfoService {

    private final CompanyInfoRepository repository;

    public CompanyInfoServiceImpl(CompanyInfoRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
