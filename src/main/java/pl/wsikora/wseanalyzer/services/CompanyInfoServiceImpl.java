package pl.wsikora.wseanalyzer.services;

import org.springframework.stereotype.Service;
import pl.wsikora.wseanalyzer.model.CompanyInfo;
import pl.wsikora.wseanalyzer.repositories.CompanyInfoRepository;

import static pl.wsikora.wseanalyzer.util.entities.Merger.merge;

@Service
public class CompanyInfoServiceImpl extends CrudServiceImpl<CompanyInfo> implements CompanyInfoService {

    private final CompanyInfoRepository repository;

    public CompanyInfoServiceImpl(CompanyInfoRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public CompanyInfo update(long id, CompanyInfo companyInfo) {
        return repository.findById(id)
                .map(e -> repository.save(merge(e, companyInfo)))
                .orElseThrow(IllegalArgumentException::new);
    }

}
