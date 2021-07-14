package pl.wsikora.wseanalyzer.services.company;

import pl.wsikora.wseanalyzer.model.company.CompanyGeneralInfo;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface CompanyGeneralInfoService  {

    List<CompanyGeneralInfo> getPart(Pageable pageable);

    Optional<CompanyGeneralInfo> getSingle(long id);

    CompanyGeneralInfo create(CompanyGeneralInfo companyGeneralInfo);

    CompanyGeneralInfo update(long id, CompanyGeneralInfo updatedCompanyGeneralInfo);

    void delete(long id);

}
