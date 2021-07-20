package pl.wsikora.wseanalyzer.services;

import pl.wsikora.wseanalyzer.model.CompanyInfo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Pageable;

public interface CompanyInfoService {

    List<CompanyInfo> getPart(Pageable pageable);

    Optional<CompanyInfo> getSingle(long id);

    CompanyInfo create(CompanyInfo companyInfo);

    CompanyInfo update(long id, CompanyInfo updateCompanyInfo);

    void delete(long id);

}
